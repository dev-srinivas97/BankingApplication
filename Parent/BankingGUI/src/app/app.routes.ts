import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { BankingformComponent } from './bankingform/bankingform.component';

export const routes: Routes = [
    {path:'login',component:LoginComponent},
    {path:'banking',component:BankingformComponent},
    {path:'',redirectTo:'/login',pathMatch:'full'}
];
