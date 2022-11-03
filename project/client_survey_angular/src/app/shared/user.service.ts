import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  userUrl ! : string;

  constructor( private http :HttpClient) { 
    this.userUrl="http://localhost:8082/users";

  }
  public allUsers(){
    return this.http.get(this.userUrl)
  }
}
