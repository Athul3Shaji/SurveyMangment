import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthguardService } from '../shared/authguard.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private router:Router,private authguardService : AuthguardService) { }

  ngOnInit(): void {
    this.authguardService.logout();
 
    this.router.navigateByUrl('login');
  }

}
