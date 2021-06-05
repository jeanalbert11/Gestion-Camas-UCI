import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  

  // //Inyeccion de dependencias
  // constructor(private http: HttpClient) {}

  // public login(user: User): Observable<any> {
  //   const urlEndPoint = 'http://localhost:8090/api/security/oauth/token';
  //   const credenciales = btoa('angularApp' + ':' + '12345');
  //   const httpHeaders = new HttpHeaders({
  //     'Content-Type': 'application/x-www-form-urlencoded',
  //     'Authorization': 'Basic ' + credenciales,
  //   });
  //   let params = new URLSearchParams();
  //   params.set('grand_type','password');
  //   params.set('username', user.username);
  //   params.set('password', user.password);
  //   return this.http.post<any>(urlEndPoint,params.toString(),{headers:httpHeaders});
  // }
}
