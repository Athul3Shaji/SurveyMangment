import { Component, OnInit } from '@angular/core';
import { Oprequest } from '../oprequest';
import { Question } from '../question';
import { Option } from '../option';
import { ActivatedRoute, Router } from '@angular/router';
import { SurveyServiceService } from '../survey-service.service';
import { FormArray, FormBuilder, FormGroup ,FormControl,ReactiveFormsModule,FormsModule} from '@angular/forms';
import { OtionService } from '../shared/otion.service';
import { Survey } from '../survey';
import { NgForm } from '@angular/forms';
// import { NgModel } from '@angular/forms';

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css']
  
})
export class QuestionComponent implements OnInit {
  survey ! : Survey;
  oprequest  :Oprequest
 option! :Option
 question ! :Question
 questionForm!:FormGroup ;
 questions ! : Question[]
//  options ! : Option[]
 opt! : []
 id=JSON.parse(sessionStorage.getItem('survey_id') || '{}' );
  

//  addoptions ! : FormArray;

 
 countries = [
   { id: 0, name: " Select" },
   { id: 1, name: "Single Type Question" },

   { id: 2, name: "Multi type " },
   { id: 3, name: "Free Type" },
  
 ]; 
  k !: Survey;
  


  constructor(private route :ActivatedRoute, 
    private router  :Router, private surveyService : SurveyServiceService,private fb:FormBuilder ,private otionService : OtionService) { 
      this.k =  new Survey;

      this.oprequest = new Oprequest;
      this.option = new Option;
      this.question=new Question; 
      this.survey = new Survey;

      this.questionForm = this.fb.group({
         
        question_type : '',
        question :'',
        surveyId:'',
        options : this.fb.array([]) 


      })
 
      
    }

    get options():FormArray{
      return this.questionForm.get("options") as FormArray
    }
    newOptions(): FormGroup {
      return this.fb.group({
        options:''

      }
        
       
      )
    }

    addOptions() {
      this.options.push(this.newOptions());
    }


    removeOption(i:number) {
      this.options.removeAt(i);
    }

  ngOnInit(): void {
    this.otionService.findAll().subscribe(data=>{
      this.questions = data;})

   }
   
  
  addOption(id : number){
    console.log(id)
    console.log(this.option)

    // console.log(this.oprequest.option=this.option)
  
    this.otionService.optionsave(this.option).subscribe(result => this.reload());
  }

  reload(){
    
  }
  onSubmitone() {
    
  //    this.question.survey_id=JSON.parse(sessionStorage.getItem('survey_id') || '{}' );
      
  this.otionService.save(this.questionForm.value).subscribe(result => this.reload());

  console.log(this.questionForm.value)
   
   

   }

   





}
 


