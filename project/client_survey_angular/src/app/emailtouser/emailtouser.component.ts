import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../shared/user.service';

@Component({
  selector: 'app-emailtouser',
  templateUrl: './emailtouser.component.html',
  styleUrls: ['./emailtouser.component.css']
})
export class EmailtouserComponent implements OnInit {
  users!:any
  constructor(private userService : UserService,private router:Router) {
    console.log(this.router.url)
   }

  ngOnInit(): void {
    this.userService.allUsers().subscribe(res=>{
      this.users=res
    })
  }

}
