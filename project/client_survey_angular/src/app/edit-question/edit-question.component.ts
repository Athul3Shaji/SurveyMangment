import { Component, Input, OnInit,EventEmitter,Output } from '@angular/core';
import { OtionService } from '../shared/otion.service';
// import { QuestionViewComponent } from '../question-view/question-view.component';
import { ActivatedRoute } from '@angular/router';
import { Question } from '../question';
@Component({
  selector: 'app-edit-question',
  templateUrl: './edit-question.component.html',
  styleUrls: ['./edit-question.component.css']
})
export class EditQuestionComponent implements OnInit {
  
  // @Input() inputFromParent !: string;
  updateQuestion ! :Question[]
  questionedit ! :Question
  countries = [
    { id: 1, name: "Single Type Question" },
    { id: 2, name: "Multi type " },
    { id: 3, name: "Free Type" },
   
  ];


  constructor(private otionService :OtionService,private route :ActivatedRoute) { 
    this.questionedit = new Question;
  }

  ngOnInit(): void {
    
   let id = this.route.snapshot.params['question_id']
    console.log("url_id",id)
   
    var n = parseInt(atob(id))
    console.log("decrypt!",n)
    this.otionService.findQuestionById(n).subscribe(data=>{
      this.updateQuestion =data

    })
   
  }

  onEdito(){
    var k =this.updateQuestion
    console.log(k)
  console.log(this.questionedit)
  }

}
