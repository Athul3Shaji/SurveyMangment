import { Component, Input, OnInit,EventEmitter,Output } from '@angular/core';
import { OtionService } from '../shared/otion.service';
// import { QuestionViewComponent } from '../question-view/question-view.component';
import { ActivatedRoute } from '@angular/router';
import { Question } from '../question';
import { FormBuilder, FormGroup } from '@angular/forms';
@Component({
  selector: 'app-edit-question',
  templateUrl: './edit-question.component.html',
  styleUrls: ['./edit-question.component.css']
})
export class EditQuestionComponent implements OnInit {
  
  // @Input() inputFromParent !: string;

  questionEdit !: FormGroup
   updateQuestion  :any
  questionedit ! :Question
  countries = [
    { id: 1, name: "Single Type Question" },
    { id: 2, name: "Multi type " },
    { id: 3, name: "Free Type" },
   
  ];


  constructor(private otionService :OtionService,private route :ActivatedRoute,private fb : FormBuilder) { 
    this.questionedit = new Question;
  }

  ngOnInit(): void {
    
   let id = this.route.snapshot.params['question_id']
    console.log("url_id",id)
   
    var n = parseInt(atob(id))
    console.log("decrypt!",n)
    this.otionService.findQuestionById(n).subscribe(data=>{
      this.updateQuestion =data
      console.log(this.updateQuestion)

    })

    this.questionEdit =this.fb.group({
      questionType :[],
      questionName :[]
    });
   
  }

  onEdito(){
    var k =this.updateQuestion
    console.log(k)
  console.log(this.questionedit)
  }

}
