import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SurveyServiceService } from '../survey-service.service';

@Component({
  selector: 'app-searchsurvey',
  templateUrl: './searchsurvey.component.html',
  styleUrls: ['./searchsurvey.component.css']
})
export class SearchsurveyComponent implements OnInit {
   survey! :any;

  constructor(private router : ActivatedRoute,private surveyservice:SurveyServiceService,private route:Router) { }

  ngOnInit(): void {

    let id = this.router.snapshot.params['search']
    console.log(id)
    this.surveyservice.search(id).subscribe(res=>{
      console.log(res)
      this.survey=res
    })
  }
  deleteSurvey(id : number) {
    sessionStorage.setItem("delete_id",JSON.stringify(id));

    // this.onDelete(id)
    
    // this.surveyservice.deleteSurvey(id)
    //   .subscribe(
    //     data => {
    //       console.log(data);
          
    //     },
    //     error => console.log(error));
        // location.reload(); 
  
  }
 onDelete(){
  var id = JSON.parse(sessionStorage.getItem('delete_id') || '{}')
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
    var k = btoa("addquestion"+id);
    sessionStorage.setItem("survey_id",JSON.stringify(id));
    this.route.navigate(['addquestion/survey_id',k]);

  }

  onEdit(id :number){
    console.log("edit id: ",id)
   
   var k = btoa("surevey"+id+" editsurvey ");
   console.log(k)
    sessionStorage.setItem("edit_id",JSON.stringify(id))
  //  var k = this.surveyservice.getSurvey(id).subscribe(data=>{
  //   this.survey=data
  //  })
  //  console.log(k)
   this.route.navigate(['surveylists/editsurvey',k])
  }

}
