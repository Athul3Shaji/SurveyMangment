import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SurveyListComponent } from './survey-list/survey-list.component';
import { SurveyFormComponent } from './survey-form/survey-form.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { ClientLoginComponent } from './client-login/client-login.component';
import { QuestionComponent } from './question/question.component';
import { QuestionViewComponent } from './question-view/question-view.component';
import { EditsurveyComponent } from './editsurvey/editsurvey.component';
import { EditsurveyviewComponent } from './editsurveyview/editsurveyview.component';



@NgModule({
  declarations: [
    AppComponent,
    SurveyListComponent,
    SurveyFormComponent,
    ClientLoginComponent,
    QuestionComponent,
    QuestionViewComponent,
    EditsurveyComponent,
    EditsurveyviewComponent,
  
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
