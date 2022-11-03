import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-forgetpassword',
  templateUrl: './forgetpassword.component.html',
  styleUrls: ['./forgetpassword.component.css']
})
export class ForgetpasswordComponent implements OnInit {
  email!:string

  constructor(private router : Router) { }

  ngOnInit(): void {
    console.log(this.email)
   
  }
  
  onSubmit(){
    this.router.navigate(["/login"])

  }
  

}
