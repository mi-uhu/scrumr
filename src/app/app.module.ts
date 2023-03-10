import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { WebPresenceComponent } from './web-presence/web-presence.component';
import { FooterComponent } from './footer/footer.component';
import { RoutingModule } from './routing/routing.module';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { BoardComponent } from './board/board.component';

@NgModule({
    declarations: [AppComponent, NavbarComponent, WebPresenceComponent, FooterComponent, LoginComponent, SignupComponent, SidebarComponent, BoardComponent],
    imports: [BrowserModule, RoutingModule],
    providers: [],
    bootstrap: [AppComponent],
})
export class AppModule {}
