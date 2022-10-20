import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientLoginComponent } from './client-login/client-login.component';
import { EditQuestionComponent } from './edit-question/edit-question.component';
import { EditsurveyComponent } from './editsurvey/editsurvey.component';
import { HomeComponent } from './home/home.component';
import { LogoutComponent } from './logout/logout.component';
import { QuestionViewComponent } from './question-view/question-view.component';
import { QuestionComponent } from './question/question.component';
import { AuthguardService } from './shared/authguard.service';
import { SurveyFormComponent } from './survey-form/survey-form.component';
import { SurveyListComponent } from './survey-list/survey-list.component';

const routes: Routes = [
  { path: '', component: ClientLoginComponent },

  { path: 'surveylists', component: SurveyListComponent, },
  { path: 'addsurvey', component: SurveyFormComponent ,canActivate:[AuthguardService]},
  {path :'addquestion/survey_id/:survey_id', component: QuestionComponent,canActivate:[AuthguardService]},
  {path:'surveylists/editsurvey/:survey_id',component:EditsurveyComponent,canActivate:[AuthguardService]},
  {path:'home',component:HomeComponent,canActivate:[AuthguardService]},
  {path:'questionview',component:QuestionViewComponent,canActivate:[AuthguardService]},
  {path:'questions/editquestion/:question_id',component:EditQuestionComponent,canActivate:[AuthguardService]},


  {path:'login',component:ClientLoginComponent,pathMatch:"full"},
  { path: 'logout', component:LogoutComponent}


];



@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
