import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
 loginUrl ! : string
  constructor(private http : HttpClient) { 
    this.loginUrl ='http://localhost:8082/login'
  }

  login(data:any){
    return this.http.post(this.loginUrl,data)
  }
}
