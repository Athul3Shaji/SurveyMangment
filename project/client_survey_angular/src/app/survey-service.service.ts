import { Injectable } from '@angular/core';
import { Survey } from './survey';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Option } from './option';

@Injectable({
  providedIn: 'root'
})
export class SurveyServiceService {
  private clientUrl ! : string;
  private clientUrladd! : string;
  private csvUrl! :string;
  header = new HttpHeaders()

  constructor(private http : HttpClient) {
    this.clientUrl = 'http://localhost:8082/surveys';
    this.clientUrladd='http://localhost:8082/addsurvey';
    

    
   }
   getAccessToken() {
    return localStorage.getItem("accessToken")
  }
   public findAll():Observable<Survey[]>{
    return this.http.get<Survey[]>(this.clientUrl);

   }
   
   public save(survey : Survey){
   
    return this.http.post<Survey>(this.clientUrladd,survey,{headers:this.header});
   }
   deleteSurvey(id: number){
    return this.http.delete(`${this.clientUrl}/${id}`);
  }
  public getSurvey(id : number): Observable<Survey[]>{
    return this.http.get<Survey[]>(this.clientUrl+'/'+id);
  }

  public update(id :number,survey : any){
    console.log("service",survey)
    return this.http.put(this.clientUrl+'/editsurvey/'+id,survey);
  }

  public search(search:string){
    return this.http.get(this.clientUrl+'/search/'+search)
  }

  public download(){
    return this.http.get(this.clientUrl+'/export',{responseType:'blob'})
  }
 
}
