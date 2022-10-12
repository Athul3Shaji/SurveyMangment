import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditsurveyComponent } from './editsurvey/editsurvey.component';
import { QuestionComponent } from './question/question.component';
import { SurveyFormComponent } from './survey-form/survey-form.component';
import { SurveyListComponent } from './survey-list/survey-list.component';

const routes: Routes = [
  { path: 'surveylists', component: SurveyListComponent },
  { path: 'addsurvey', component: SurveyFormComponent },
  {path :'question', component: QuestionComponent},
  {path:'editsurvey',component:EditsurveyComponent}
];



@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
