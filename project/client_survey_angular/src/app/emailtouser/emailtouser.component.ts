import { Component, OnInit } from '@angular/core';
import { UserService } from '../shared/user.service';

@Component({
  selector: 'app-emailtouser',
  templateUrl: './emailtouser.component.html',
  styleUrls: ['./emailtouser.component.css']
})
export class EmailtouserComponent implements OnInit {
  users!:any
  constructor(private userService : UserService) { }

  ngOnInit(): void {
    this.userService.allUsers().subscribe(res=>{
      this.users=res
    })
  }

}
