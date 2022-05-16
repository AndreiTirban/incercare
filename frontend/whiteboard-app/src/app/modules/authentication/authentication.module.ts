import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthenticationRoutingModule } from './authentication-routing.module';
import { AuthenticationComponent } from './authentication.component';
import { SignupComponent } from './components/signup/signup.component';
import { SharedModule } from 'src/app/shared';
import { SignupForm } from './components/signup-form/signup-form';
import { LoginFormComponent } from "./components/login-form/login-form.component";
import { LoginComponent } from "./components/login/login.component";

@NgModule({
  declarations: [
    AuthenticationComponent,
    SignupComponent,
    SignupForm,
    LoginFormComponent,
    LoginComponent
  ],
  imports: [
    CommonModule,
    AuthenticationRoutingModule,
    SharedModule,
  ]
})
export class AuthenticationModule {
}
