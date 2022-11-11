import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../shared/login.service';

@Component({
  selector: 'app-client-login',
  templateUrl: './client-login.component.html',
  styleUrls: ['./client-login.component.css']
})
export class ClientLoginComponent implements OnInit {
  loginForm!: any
  
  data: any;
  // refreshToken: any;
  
  

  constructor(private fb : FormBuilder,private loginService:LoginService,private router : Router) { }

  ngOnInit(): void {
    this.loginForm=new FormGroup({
      email:new FormControl(),
      password:new FormControl()
    })
    
  }
  
  onSubmit(){
    this.loginForm=this.fb.group({
      email:this.loginForm.value.email,
      password:this.loginForm.value.password
    });

 
sessionStorage.setItem("usermail",JSON.stringify(this.loginForm.value.email))

    console.log("logged",this.loginForm.value)
    this.loginService.login(this.loginForm.value).subscribe((res: any)=>{
      this.data=res
      localStorage.setItem('accessToken',this.data.accessToken.value)
      localStorage.setItem("refreshToken",this.data.refreshToken.value)

      this.router.navigate(['/home'])
    },
    
      (error:any)=>{
        console.log(error);
        alert("Login Failed")}
        );
    

  }
  }


