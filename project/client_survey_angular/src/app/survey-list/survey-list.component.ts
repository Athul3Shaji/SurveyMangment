import { Component, OnInit } from '@angular/core';
import { Survey } from '../survey';
import { SurveyServiceService } from '../survey-service.service';

@Component({
  selector: 'app-survey-list',
  templateUrl: './survey-list.component.html',
  styleUrls: ['./survey-list.component.css']
})
export class SurveyListComponent implements OnInit {
   
  survey !: Survey[];

  constructor(private surveyservice : SurveyServiceService ) { }

  ngOnInit(): void {

    this.surveyservice.findAll().subscribe(data=>{
      this.survey = data;

    })
  }

  deleteSurvey(id: number) {
    this.surveyservice.deleteSurvey(id)
      .subscribe(
        data => {
          console.log(data);
          
        },
        error => console.log(error));
        location.reload();
  }

}
