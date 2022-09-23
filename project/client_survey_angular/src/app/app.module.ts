import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SurveyListComponent } from './survey-list/survey-list.component';
import { SurveyFormComponent } from './survey-form/survey-form.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { ExampleComponent } from './example/example.component';


@NgModule({
  declarations: [
    AppComponent,
    SurveyListComponent,
    SurveyFormComponent,
    ExampleComponent,
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
  

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
