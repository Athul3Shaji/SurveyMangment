import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Option } from '../option';
import { Question } from '../question';
import { OtionService } from '../shared/otion.service';
import { EditQuestionComponent } from '../edit-question/edit-question.component';
@Component({
  selector: 'app-question-view',
  templateUrl: './question-view.component.html',
  styleUrls: ['./question-view.component.css'],
  
})
export class QuestionViewComponent implements OnInit {

  inputText: string = 'Hi...have a nice day - message from parent';


  question ! :Question[];
  options ! : Option[]
  quest ! : Question
  option ! :Option
  edit ! : EditQuestionComponent

  constructor(private  otionService : OtionService,private router: Router,) { 
    this.option =new Option;
  }

  ngOnInit(): void {

    var id = JSON.parse(sessionStorage.getItem('survey_id') || '{}' );
    // console.log("hello",id)

    var idop=JSON.parse(sessionStorage.getItem('question_id') || '{}')
    // this.otionService.findAll().subscribe(data=>{
    //   this.question = data;
    // })
    // this.otionService.findAllOptions().subscribe(data=>{
    //   this.options = data;})
       this.otionService.getOption(idop).subscribe(data=>{
        this.options=data;
       })

      this.otionService.getQuestion(id ).subscribe(data=>{
        this.question =data;
      });

  
}
 
  add(id : number){
    console.log(id)
  
    sessionStorage.setItem("question_id",JSON.stringify(id));
  

  }
  addOption(){
    // console.log(id)
     this.option.question_id=JSON.parse(sessionStorage.getItem('question_id') || '{}');
    console.log(this.option)

    // console.log(this.oprequest.option=this.option)
  
     this.otionService.optionsave(this.option).subscribe(result => this.reload());
  }
  reload(){
    location.reload()
  }
   
  delete(id:number){
    console.log(id)
    sessionStorage.setItem("delete_question_id",JSON.stringify(id));

  }
  onDelete(){
    var id =JSON.parse(sessionStorage.getItem('delete_question_id') || '{}')

       this.otionService.deleteQuestion(id).subscribe(result=> this.reloadon());

  }
  reloadon(){
    location.reload()

  }

  onEdit(id : any){
    console.log("questionId",id)
    var k = btoa(id)
    // sessionStorage.setItem("edit_question_id",JSON.stringify(id));

    this.router.navigate(['questions/editquestion/'+k])
  }
}
