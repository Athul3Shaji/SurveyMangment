import { Component, OnInit } from '@angular/core';
import { OtionService } from '../shared/otion.service';
import { Option } from '../option';
import { Survey } from '../survey';
import { SurveyServiceService } from '../survey-service.service';


@Component({
  selector: 'app-editsurvey',
  templateUrl: './editsurvey.component.html',
  styleUrls: ['./editsurvey.component.css']
})
export class EditsurveyComponent implements OnInit {


  options ! : Option[]
   surveys ! : Survey[];
   survey ! : Survey;
  constructor(private otionService : OtionService,private surveyService : SurveyServiceService) {
    this.survey= new Survey;
   }

  ngOnInit(): void {
    var id = JSON.parse(sessionStorage.getItem('edit_id') || '{}' );
    this.otionService.findAllOptions().subscribe(data=>{
      this.options = data;

    })
   var k= this.surveyService.getSurvey(id).subscribe(data=>{
        this.surveys=data
  })
  console.log(k)
}

  onUpdate(id:number){

    console.log("edit one",id)
    console.log
    this.surveyService.update(234,this.survey).subscribe(result=> this.reload())
    

  }
  reload(){

  }

}
