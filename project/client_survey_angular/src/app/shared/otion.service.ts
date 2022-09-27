import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Option } from '../option';

@Injectable({
  providedIn: 'root'
})
export class OtionService {
  optionUrl  !: string;

  
  constructor(private http :HttpClient) { 
    this.optionUrl = 'http://localhost:8082/options';
  }


  public optionsave(option : Option){
    return this.http.post<Option>(this.optionUrl,option);
   }
}
