import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { WebPresenceComponent } from '../web-presence/web-presence.component';
import { LoginComponent } from '../login/login.component';
import { SignupComponent } from '../signup/signup.component';
import { BoardComponent } from '../board/board.component';
import { ProjectsComponent } from '../projects/projects.component';
import { UserManagementComponent } from '../user-management/user-management.component';
import { NotFoundComponent } from '../not-found/not-found.component';

const routes: Routes = [
    { path: '', pathMatch: 'full', component: WebPresenceComponent },
    { path: 'login', component: LoginComponent },
    { path: 'signup', component: SignupComponent },
    { path: 'board', component: BoardComponent },
    { path: 'projects', component: ProjectsComponent },
    { path: 'user-management', component: UserManagementComponent },
    { path: '**', component: NotFoundComponent },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
})
export class RoutingModule {}
