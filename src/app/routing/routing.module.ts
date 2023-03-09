import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { WebPresenceComponent } from '../web-presence/web-presence.component';
import { LoginComponent } from '../login/login.component';
import { SignupComponent } from '../signup/signup.component';

const routes: Routes = [
    { path: '', pathMatch: 'full', component: WebPresenceComponent },
    { path: 'login', component: LoginComponent },
    { path: 'signup', component: SignupComponent },
    { path: '**', component: WebPresenceComponent }, //TODO: not found component
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
})
export class RoutingModule {}
