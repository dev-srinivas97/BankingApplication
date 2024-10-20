import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient) { }

  getDetails():Observable<any>{
    return this.http.get('http://localhost:8080/banking/details',{ responseType: 'text' })
  }

  validateLogin(login:any):Observable<any>{
    return this.http.post('http://localhost:8080/banking/login',login,{ responseType: 'text' })
  }
}
