import { Component, OnInit } from '@angular/core';
import { Survey } from '../survey';
import { SurveyServiceService } from '../survey-service.service';
import { ActivatedRoute,Router } from '@angular/router';

@Component({
  selector: 'app-survey-list',
  templateUrl: './survey-list.component.html',
  styleUrls: ['./survey-list.component.css']
})
export class SurveyListComponent implements OnInit {
   
  survey !: Survey[];


  constructor(private surveyservice : SurveyServiceService,private router  :Router, ) { }

  ngOnInit(): void {

    this.surveyservice.findAll().subscribe(data=>{
      this.survey = data;

    })
  }

  deleteSurvey(id: number) {
    console.log(id)
    this.surveyservice.deleteSurvey(id)
      .subscribe(
        data => {
          console.log(data);
          
        },
        error => console.log(error));
        location.reload();
  }
  onQuestion(id:number){
    
    console.log("number",id)
    sessionStorage.setItem("survey_id",JSON.stringify(id));
    this.router.navigate(['/question']);

  }

  onEdit(id :number){
    console.log("edit id: ",id)
    sessionStorage.setItem("edit_id",JSON.stringify(id))
  //  var k = this.surveyservice.getSurvey(id).subscribe(data=>{
  //   this.survey=data
  //  })
  //  console.log(k)
   this.router.navigate(['/editsurvey'])
  }

}
