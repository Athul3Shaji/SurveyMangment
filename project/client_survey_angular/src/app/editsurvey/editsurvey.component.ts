
import { Component, OnInit } from '@angular/core';
import { OtionService } from '../shared/otion.service';
import { Option } from '../option';
import { Survey } from '../survey';
import { SurveyServiceService } from '../survey-service.service';
import { FormBuilder } from '@angular/forms';


@Component({
  selector: 'app-editsurvey',
  templateUrl: './editsurvey.component.html',
  styleUrls: ['./editsurvey.component.css']
})
export class EditsurveyComponent implements OnInit {


  options ! : Option[]
   surveys ! : Survey[];
   surveyedit ! : Survey;
  surveyForm: any;
  constructor(private otionService : OtionService,private surveyService : SurveyServiceService,private fb:FormBuilder) {
    this.surveyedit = new Survey;
   }

  ngOnInit(): void {
    var id = JSON.parse(sessionStorage.getItem('edit_id') || '{}' );
    // var c =this.otionService.findAllOptions().subscribe(data=>{
    //   this.options = data;

    // })
    console.log(id)
    this.surveyService.getSurvey(id).subscribe(data=>{
    this.surveys=data
   });
   
  //  console.log(this.survey)
  //  this.surveyService.update(id).subscribe(result=> this.reload())
    

  this.surveyForm=this.fb.group({
    surveyName:" ",
    survey_description: " "
    
  })
}

  onUpdate(id : number){

     console.log("edit one",id)
    // this.surveyedit.survey_id=id
    console.log("data",this.surveyForm.value)
    this.surveyService.update(id,this.surveyForm.value).subscribe(result=> this.reload())
    

  }
  reload(){

  }

}
