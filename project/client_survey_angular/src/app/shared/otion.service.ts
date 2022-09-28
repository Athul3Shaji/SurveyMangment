import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Oprequest } from '../oprequest';
import { Option } from '../option';

@Injectable({
  providedIn: 'root'
})
export class OtionService {
  optionUrl  !: string;

  
  constructor(private http :HttpClient) { 
    this.optionUrl = 'http://localhost:8082/options';
  }


  public optionsave(oprequest : Oprequest){
    return this.http.post<Oprequest>(this.optionUrl,oprequest);
   }
}
