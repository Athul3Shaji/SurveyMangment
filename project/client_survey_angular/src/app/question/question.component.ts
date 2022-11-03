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
 optionForm!:FormGroup ;
 questions ! : Question[]
 options ! : Option[]
 opt! : []
 public values:  any[]=[{

 }]
 
  

//  addoptions ! : FormArray;

 
 countries = [
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

 
      
    }
  

  ngOnInit(): void {
    this.otionService.findAll().subscribe(data=>{
      this.questions = data;})

   

      this.optionForm= this.fb.group({
        addOptions : [""]
      })
      

    console.log(this.optionForm.value)

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
    
     this.question.survey_id=JSON.parse(sessionStorage.getItem('survey_id') || '{}' );
      // this.question.options=this.values   

    console.log("questions",this.question)
    console.log(this.optionForm.value)

    // console.log(this.oprequest.option = this.option)
   this.otionService.save(this.question).subscribe(result => this.reload());

  // console.log("options",this.values)

    // //.survey= JSON.parse(sessionStorage.getItem('Surveys') || '{}' )
    // console.log("hello",this.survey)
    // this.surveyService.save(this.survey).subscribe(result => this.reload());

    // var data = this.otionService.optionsave(this.oprequest).subscribe(result => this.reload());
    // console.log(data);

   
   

   }

   onOption(){
    this.opt =this.optionForm.value
    // console.log("option",this.values  )
    console.log("array",this.opt)
   }

  //  createOption():FormGroup {
  //   return this.fb.group({
  //    addoptions  :''
  //   })



  removevalue(i: number){
    this.values.splice(i,1);
  }

  addvalue(){
  
      this.values.push(" ");
   
  }

  onOptionTwo(){
   
  }
}
 


