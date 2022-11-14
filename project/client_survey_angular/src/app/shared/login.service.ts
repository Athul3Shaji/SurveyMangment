import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
 loginUrl ! : string
  forgotUrl: string;
  constructor(private http : HttpClient) { 
    this.loginUrl ='http://localhost:8082/login'
    this.forgotUrl='http://localhost:8080/sendMail'
  }

  login(data:any){
    return this.http.post(this.loginUrl,data)
  }

  fotgot(data:any){
    console.log(data)
    return this.http.post(this.forgotUrl,data)
  }
}
