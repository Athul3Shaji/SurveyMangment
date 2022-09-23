import { Injectable } from '@angular/core';
import { Survey } from './survey';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SurveyServiceService {
  private clientUrl ! : string;

  constructor(private http : HttpClient) {
    this.clientUrl = 'http://localhost:8080/clients';
   }
   public findAll():Observable<Survey[]>{
    return this.http.get<Survey[]>(this.clientUrl);

   }
   
   public save(survey : Survey){
    return this.http.post<Survey>(this.clientUrl,survey);
   }
   deleteSurvey(id: number): Observable<any> {
    return this.http.delete(`${this.clientUrl}/${id}`, { responseType: 'text' });
  }
}
