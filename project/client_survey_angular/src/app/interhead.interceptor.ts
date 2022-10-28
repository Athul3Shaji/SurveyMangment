import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { SurveyServiceService } from './survey-service.service';

@Injectable()
export class InterheadInterceptor implements HttpInterceptor {

  constructor(private  surveyService :SurveyServiceService) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    if (this.surveyService.getAccessToken()!="") {
      const accessToken = this.surveyService.getAccessToken();
      request = request.clone({
        setHeaders: {
          Authorization: 'survey ' + accessToken,
        },
      })
   
  }
  return next.handle(request);
  }
}
