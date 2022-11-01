import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Question } from '../question';
import { OtionService } from '../shared/otion.service';

@Component({
  selector: 'app-sendsurvey',
  templateUrl: './sendsurvey.component.html',
  styleUrls: ['./sendsurvey.component.css']
})
export class SendsurveyComponent implements OnInit {

  question! : Question[];

  constructor(private route: ActivatedRoute,private otionservice : OtionService) { }

  ngOnInit(): void {
    let id = this.route.snapshot.params['survey_id']
    console.log("url_id",id)
    this.otionservice.getQuestion(id).subscribe((data: any)=>{
      this.question =data;
      console.log("question",this.question)
    });

  }

}
