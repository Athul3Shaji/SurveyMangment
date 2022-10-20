import { Component, Input, OnInit,EventEmitter,Output } from '@angular/core';
import { OtionService } from '../shared/otion.service';
// import { QuestionViewComponent } from '../question-view/question-view.component';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-edit-question',
  templateUrl: './edit-question.component.html',
  styleUrls: ['./edit-question.component.css']
})
export class EditQuestionComponent implements OnInit {
  
  @Input() inputFromParent !: string;
   
  constructor(private otionService :OtionService,private route :ActivatedRoute) { }

  ngOnInit(): void {
    
   let id = this.route.snapshot.params['question_id']
    console.log("url_id",id)
   
  }

  onEdito(){


  }

}
