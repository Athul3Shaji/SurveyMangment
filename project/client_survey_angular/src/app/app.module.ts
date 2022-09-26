import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SurveyListComponent } from './survey-list/survey-list.component';
import { SurveyFormComponent } from './survey-form/survey-form.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { ClientLoginComponent } from './client-login/client-login.component';



@NgModule({
  declarations: [
    AppComponent,
    SurveyListComponent,
    SurveyFormComponent,
    ClientLoginComponent,
  
   
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
