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
   updateQuestion !  : Question[]
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
    this.questionEdit =this.fb.group({
      question_type :[],
      question :[],
      survey_id :[]
    });
    
   let id = this.route.snapshot.params['question_id']
    console.log("url_id",id)
   
    var n = parseInt(atob(id))
    console.log("decrypt!",n)
    this.otionService.findQuestionById(n).subscribe((data:any)=>{
      this.updateQuestion =data

    })
    console.log(this.updateQuestion)


    
   
  }

  onEdito(id: number){
    // var k =this.updateQuestion
    console.log()
    // var k =JSON.parse(sessionStorage.getItem('survey_id') || '{}')
    this.questionEdit
  console.log(this.questionEdit.value)
   this.otionService.updateQuestion(id,this.questionEdit.value).subscribe((data:any)=>{
    alert("updated")
   })
  
  }

}
