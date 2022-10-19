import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthguardService implements CanActivate {
  logout() {
    throw new Error('Method not implemented.');
  }

  constructor(private router : Router) { }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    let accessToken=localStorage.getItem("accessToken")
      if(accessToken!=null){
        return true
      }
      
      else{
        this.router.navigateByUrl('')
        return false;
      }
     

  }
}
