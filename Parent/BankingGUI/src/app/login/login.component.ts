import { Component } from '@angular/core';
import { LoginService } from './login.service';
import { HttpClient } from '@angular/common/http';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule,CommonModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  errorMessage:any;
  constructor(private loginService:LoginService,private router:Router){}
  loginForm=new FormGroup({
    userName:new FormControl(''),
    password:new FormControl(''),
  })
  ngOnInit(){
    console.log('asd')
    this.loginService.getDetails().subscribe((data:any)=>{
      console.log(data);
    })

    
  }
  loginData:any;
  successMessage:any;
  submit(){
    console.log(this.loginForm.getRawValue())
    this.loginService.validateLogin(this.loginForm.getRawValue()).subscribe((data:any)=>{
      console.log(JSON.parse(data));
      this.loginData=JSON.parse(data);
      if(this.loginData.errorCode){
        this.errorMessage=this.loginData.message;
      }else{
        this.successMessage=this.loginData.message;
        this.router.navigate(["/banking"]);
      }
      // console.log(data.message);
    })
  }
}
