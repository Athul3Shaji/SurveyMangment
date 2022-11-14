import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddprofileComponent } from './addprofile/addprofile.component';
import { ClientLoginComponent } from './client-login/client-login.component';
import { EditQuestionComponent } from './edit-question/edit-question.component';
import { EditsurveyComponent } from './editsurvey/editsurvey.component';
import { EmailtouserComponent } from './emailtouser/emailtouser.component';
import { ForgetpasswordComponent } from './forgetpassword/forgetpassword.component';
import { HomeComponent } from './home/home.component';
import { LogoutComponent } from './logout/logout.component';
import { NewpasswordComponent } from './newpassword/newpassword.component';
import { QuestionViewComponent } from './question-view/question-view.component';
import { QuestionComponent } from './question/question.component';
import { SearchsurveyComponent } from './searchsurvey/searchsurvey.component';
import { SendsurveyComponent } from './sendsurvey/sendsurvey.component';
import { AuthguardService } from './shared/authguard.service';
import { SurveyFormComponent } from './survey-form/survey-form.component';
import { SurveyListComponent } from './survey-list/survey-list.component';

const routes: Routes = [
  { path: '', component: ClientLoginComponent },
  { path: 'forgetpassword', component: ForgetpasswordComponent },

  { path: 'surveylists', component: SurveyListComponent, },
  { path: 'addsurvey', component: SurveyFormComponent ,canActivate:[AuthguardService]},
  {path :'addquestion/survey_id/:survey_id', component: QuestionComponent,canActivate:[AuthguardService]},
  {path:'surveylists/editsurvey/:survey_id',component:EditsurveyComponent,canActivate:[AuthguardService]},
  {path:'home',component:HomeComponent,canActivate:[AuthguardService]},
  {path:'questionview',component:QuestionViewComponent,canActivate:[AuthguardService]},
  {path:'questions/editquestion/:question_id',component:EditQuestionComponent,canActivate:[AuthguardService]},
  {path:'sendsurvey/survey_id/:survey_id',component:SendsurveyComponent,canActivate:[AuthguardService]},
  {path:'sendemail',component:EmailtouserComponent,canActivate:[AuthguardService]},
  {path:'search/survey/:search',component:SearchsurveyComponent,canActivate:[AuthguardService]},
  { path: 'newpassword', component:NewpasswordComponent},
  {path:'addprofile',component:AddprofileComponent,canActivate:[AuthguardService]},





  {path:'login',component:ClientLoginComponent,pathMatch:"full"},
  { path: 'logout', component:LogoutComponent}


];



@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
