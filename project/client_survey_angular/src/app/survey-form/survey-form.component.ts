import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import { never } from 'rxjs';
import { Survey } from '../survey';
import { SurveyServiceService } from '../survey-service.service';

@Component({
  selector: 'app-survey-form',
  templateUrl: './survey-form.component.html',
  styleUrls: ['./survey-form.component.css']
})
export class SurveyFormComponent  {

  survey !  : Survey;
  display!: string;
  
  
  constructor(private route :ActivatedRoute, 
    private router  :Router, private surveyService : SurveyServiceService )  {
      this.survey =  new Survey;
     }

     onSubmit(){
      this.surveyService.save(this.survey).subscribe(result => this.gotoUserList());

     }
    
     gotoUserList() {
      this.router.navigate(['/surveylists']);
    }
    openModal() {
      this.display = "block";
    }
    onCloseHandled() {
      this.display = "none";
    }
  

   
    onModal(){
      
      console.log()

    }
}
