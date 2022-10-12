import { Component, OnInit } from '@angular/core';
import { Oprequest } from '../oprequest';
import { Question } from '../question';
import { Option } from '../option';
import { ActivatedRoute, Router } from '@angular/router';
import { SurveyServiceService } from '../survey-service.service';
import { FormBuilder, FormGroup } from '@angular/forms';
import { OtionService } from '../shared/otion.service';
import { Survey } from '../survey';
import { NgForm } from '@angular/forms';

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
 contactForm:FormGroup | undefined;
 questions ! : Question[]
 options ! : Option[]
 
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
   

    console.log(this.question)
    // console.log(this.oprequest.option = this.option)
  this.otionService.save(this.question).subscribe(result => this.reload());



    // //.survey= JSON.parse(sessionStorage.getItem('Surveys') || '{}' )
    // console.log("hello",this.survey)
    // this.surveyService.save(this.survey).subscribe(result => this.reload());

    // var data = this.otionService.optionsave(this.oprequest).subscribe(result => this.reload());
    // console.log(data);

   
   

   }
 

}
