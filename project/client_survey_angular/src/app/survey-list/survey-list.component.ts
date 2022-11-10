import { Component, OnInit } from '@angular/core';
import { Survey } from '../survey';
import { SurveyServiceService } from '../survey-service.service';
import { ActivatedRoute,Router } from '@angular/router';
import { DomSanitizer } from '@angular/platform-browser';
import { AngularCsv } from 'angular-csv-ext/dist/Angular-csv';
import{saveAs} from 'file-saver';

@Component({
  selector: 'app-survey-list',
  templateUrl: './survey-list.component.html',
  styleUrls: ['./survey-list.component.css']
})
export class SurveyListComponent implements OnInit {
   
  survey !: Survey[];
  eid ! : number
  search !:string;
  page: number = 1;
  count: number = 0;
  tableSize: number =7 ;
  tableSizes: any = [3, 6, 9, 12];
  fileUrl: any;
  downloadJsonHref: any;
  downloadSurveys! :any;
  fileName : string="survey"



  constructor(private surveyservice : SurveyServiceService,private router  :Router, private sanitizer: DomSanitizer) { }

  ngOnInit(): void {

    this.surveyservice.findAll().subscribe(data=>{
      this.survey = data;
      // console.log(this.survey)
      
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
    this.router.navigate(['addquestion/survey_id',k]);

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
   this.router.navigate(['surveylists/editsurvey',k])
  }

  onSearch(name:string){
  console.log(name)
   this.router.navigate(["/search/survey",name])
  }
  onTableDataChange(event: any) {
    this.page = event;
    this.survey;
  }
  onTableSizeChange(event: any): void {
    this.tableSize = event.target.value;
    this.page = 1;
    this.survey;
  }


 onDownload(){
  this.surveyservice.download().subscribe(blob=>
    saveAs(blob))
 


 }






}
