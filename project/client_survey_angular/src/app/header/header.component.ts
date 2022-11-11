import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../shared/user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
userEmail ! :any
user:any
  constructor(private router :Router,private userService:UserService) { }

  ngOnInit(){
     this.userEmail=JSON.parse(sessionStorage.getItem("usermail")|| '{}')
     this.userService.allUsers().subscribe(user=>{
      this.user=user
      console.log(this.user[1].name)

     })
       console.log(this.user)

  }
  Logout(){
    localStorage.clear()
    sessionStorage.clear()
    this.router.navigateByUrl('/login')
  }

}
