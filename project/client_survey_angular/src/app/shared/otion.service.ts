import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Oprequest } from '../oprequest';
import { Option } from '../option';
import { Question } from '../question';

@Injectable({
  providedIn: 'root'
})
export class OtionService {
  optionUrl  !: string;
  questionUrl !: string
  questionEditUrl ! :string
  header = new HttpHeaders()
  
  constructor(private http :HttpClient) { 
    this.optionUrl = 'http://localhost:8082/options';
    this.questionUrl = 'http://localhost:8082/questions';
    this.questionEditUrl='http://localhost:8082/editquestion'
  }
  public findAll():Observable<Question[]>{
    return this.http.get<Question[]>(this.questionUrl);
  }
  public save(question : Question){
    
    return this.http.post<Question>(this.questionUrl+'/addquestion',question);
  }
  public findAllOptions():Observable<Option[]>{
    return this.http.get<Option[]>(this.optionUrl);
  }
  // public optionsave(oprequest : Oprequest){
  //   return this.http.post<Oprequest>(this.optionUrl,oprequest);
  //  }
   public optionsave(option : Option){
    return this.http.post<Option>(this.optionUrl,option);
   }
   public getQuestion(id : number):Observable<Question[]>{
    
    return this.http.get<Question[]>(this.questionUrl+'/surveyId/'+id);
   }

   public getOption(id : number):Observable<Option[]>{
    return this.http.get<Option[]>(this.optionUrl+'/questionId/'+id);
   }

   deleteQuestion(id:number):Observable<any>{
     return this.http.delete(this.questionUrl+'/question_id/'+id);
   }

   public findQuestionById(id :number):Observable<Question[]>{
    return this.http.get<Question[]>(this.questionEditUrl+'/question_id/'+id)
   }
   

   }

