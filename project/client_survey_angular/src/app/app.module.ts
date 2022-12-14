import { NgModule, } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SurveyListComponent } from './survey-list/survey-list.component';
import { SurveyFormComponent } from './survey-form/survey-form.component';
import { HttpClientModule, HTTP_INTERCEPTORS, } from '@angular/common/http';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { ClientLoginComponent } from './client-login/client-login.component';
import { QuestionComponent } from './question/question.component';
import { QuestionViewComponent } from './question-view/question-view.component';
import { EditsurveyComponent } from './editsurvey/editsurvey.component';
import { EditsurveyviewComponent } from './editsurveyview/editsurveyview.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { LogoutComponent } from './logout/logout.component';
import { InterheadInterceptor } from './interhead.interceptor';
import { EditQuestionComponent } from './edit-question/edit-question.component';
import { SendsurveyComponent } from './sendsurvey/sendsurvey.component';
import { ForgetpasswordComponent } from './forgetpassword/forgetpassword.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { EmailtouserComponent } from './emailtouser/emailtouser.component';
import { SearchsurveyComponent } from './searchsurvey/searchsurvey.component';
import {NgxPaginationModule } from 'ngx-pagination';
import { ChartComponent } from './chart/chart.component';
import { ProfileComponent } from './profile/profile.component';
import { FooterComponent } from './footer/footer.component';
import { MatCardModule,MatCardAvatar,MatCard } from "@angular/material/card";
import { NewpasswordComponent } from './newpassword/newpassword.component';
import { AddprofileComponent } from './addprofile/addprofile.component';






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
    HomeComponent,
    HeaderComponent,
    LogoutComponent,
    EditQuestionComponent,
    SendsurveyComponent,
    ForgetpasswordComponent,
    EmailtouserComponent,
    SearchsurveyComponent,
    ChartComponent,
    ProfileComponent,
    FooterComponent,
    NewpasswordComponent,
    AddprofileComponent,
    
  
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    NgxPaginationModule,
    MatCardModule,
    
    
  
    
  

  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: InterheadInterceptor,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
