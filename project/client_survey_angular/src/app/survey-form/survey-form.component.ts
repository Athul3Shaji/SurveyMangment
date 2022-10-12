import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import { never } from 'rxjs';
import { FormGroup, FormControl, FormArray, FormBuilder, NgForm } from '@angular/forms'
import { Survey } from '../survey';
import { SurveyServiceService } from '../survey-service.service';
import { OtionService } from '../shared/otion.service';
import { Option } from '../option';
import { Oprequest } from '../oprequest';
import { Question } from '../question';

@Component({
  selector: 'app-survey-form',
  templateUrl: './survey-form.component.html',
  styleUrls: ['./survey-form.component.css']
})
export class SurveyFormComponent  implements OnInit {

  survey !  : Survey;
  surveys !: Survey[];
  display!: string;
  productForm: FormGroup ;
  
 oprequest ! :Oprequest
 option! :Option
 question ! :Question

  contactForm:FormGroup | undefined;
  surveyForm : FormGroup | undefined; 
  // countries = [
  //   { id: 1, name: "Single Type Question" },
  //   { id: 2, name: "Multi type " },
  //   { id: 3, name: "Free Type" },
   
  // ];
  
  constructor(private route :ActivatedRoute, 
    private router  :Router, private surveyService : SurveyServiceService,private fb:FormBuilder ,private otionService : OtionService)  {
      this.survey =  new Survey;
      this.oprequest = new Oprequest;
      this.option = new Option;
      this.question=new Question;
       
    this.productForm = this.fb.group({
      name: '',
      options: this.fb.array([]) ,
    });
     }
  ngOnInit(): void {
    this.surveyService.findAll().subscribe(data=>{
      this.surveys= data;
  })
}

     onSubmit(){
      
      console.log(this.survey)
      // sessionStorage.setItem('Surveys',JSON.stringify(this.survey))
       var  data = this.surveyService.save(this.survey).subscribe(result => this.gotoUserList());
       
      // console.log(data)

     }
    
     gotoUserList() {
      this.router.navigate(['/surveylists'])
    }
    openModal() {
      this.display = "block";
    }
    onCloseHandled() {
      this.display = "none";
    }


    options() : FormArray {
      return this.productForm.get("options") as FormArray
    }
     
    newQuantity(): FormGroup {
      
      return this.fb.group({
        opt: '',
        
      })
    }
     
    addQuantity() {
      console.log(this.options)
      this.options().push(this.newQuantity());
    }
     
    removeQuantity(i:number) {
      this.options().removeAt(i);
    }
     
    reload(){
      
    }
    onSubmitone() {
      console.log(this.oprequest.question = this.question)
      // console.log(this.question.surveys=12)
      console.log(this.oprequest.option = this.option)
      // var data = this.otionService.optionsave(this.oprequest).subscribe(result => this.reload());
      // console.log(data);
    }


    

    onQuestion(id:number){
      // console.log("number",id)
      // sessionStorage.setItem('survey id',JSON.stringify({
      //   number : Number(id)
      // }))

      // // this.router.navigate(['/question']);

    }
          
    
}