import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../shared/login.service';

@Component({
  selector: 'app-forgetpassword',
  templateUrl: './forgetpassword.component.html',
  styleUrls: ['./forgetpassword.component.css']
})
export class ForgetpasswordComponent implements OnInit {
  email!:string
  forgotForm :any;
  constructor(private router : Router,private fb :FormBuilder,private loginService:LoginService) { }

  ngOnInit(): void {


    this.forgotForm= this.fb.group({
     recipient : ""
    })
   
  }
  
  onSubmit(){
   
     
    console.log("email",this.forgotForm.value)

    this.loginService.fotgot(this.forgotForm.value).subscribe(result=>this.reload())
    this.router.navigate(["/login"])

  }
  reload(){

  }

}
