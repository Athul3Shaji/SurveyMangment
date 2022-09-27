import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import { never } from 'rxjs';
import { FormGroup, FormControl, FormArray, FormBuilder } from '@angular/forms'
import { Survey } from '../survey';
import { SurveyServiceService } from '../survey-service.service';
import { OtionService } from '../shared/otion.service';
import { Option } from '../option';

@Component({
  selector: 'app-survey-form',
  templateUrl: './survey-form.component.html',
  styleUrls: ['./survey-form.component.css']
})
export class SurveyFormComponent  {

  survey !  : Survey;
  display!: string;
  productForm: FormGroup ;
  
  option ! : Option;
  
  constructor(private route :ActivatedRoute, 
    private router  :Router, private surveyService : SurveyServiceService,private fb:FormBuilder ,private otionService : OtionService)  {
      this.survey =  new Survey;
      this.option = new Option;
       
    this.productForm = this.fb.group({
      name: '',
      options: this.fb.array([]) ,
    });
     }

     onSubmit(){
      var  data = this.surveyService.save(this.survey).subscribe(result => this.gotoUserList());
      
      console.log(data)

     }
    
     gotoUserList() {
      this.router.navigate(['/surveylists']);
    }
    openModal() {
      this.display = "block";
    }
    onCloseHandled() {
      this.display = "none";
    }


    options() : FormArray {
      return this.productForm.get("options") as FormArray
    }
     
    newQuantity(): FormGroup {
      return this.fb.group({
        opt: '',
        
      })
    }
     
    addQuantity() {
      this.options().push(this.newQuantity());
    }
     
    removeQuantity(i:number) {
      this.options().removeAt(i);
    }
     
    reload(){
      location.reload();
    }
    onSubmitone() {
      this.otionService.optionsave(this.option).subscribe(result => this.reload());
      console.log(this.productForm.value);
    }
}
