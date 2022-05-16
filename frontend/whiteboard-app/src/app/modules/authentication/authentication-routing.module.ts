import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthenticationComponent } from './authentication.component';
import { SignupComponent } from './components/signup/signup.component';
import { LoginComponent } from "./components/login/login.component";

const routes: Routes = [
  {
    path: '', redirectTo:'login', pathMatch:'full', component: AuthenticationComponent,
  },
  { path: 'signup', component: SignupComponent },
  { path: 'login', component: LoginComponent },
];

@NgModule({
  imports: [ RouterModule.forChild(routes) ],
  exports: [ RouterModule ]
})

export class AuthenticationRoutingModule {
}
