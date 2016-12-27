import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule } from '@angular/http';
import { RouterModule } from '@angular/router';

import { AppComponent }  from './app.component';
import { HomeModule } from './home/home.module';
import { AdminModule } from './admin/admin.module';
import { HomeComponent } from './home/home.component';
import { AdminComponent } from './admin/admin.component';

@NgModule({
  imports: [ 
      BrowserModule,
      HttpModule,
      HomeModule,
      AdminModule,
      RouterModule.forRoot([
        {path: 'home', component: HomeComponent},
        {path: '', redirectTo: 'home', pathMatch: 'full'},//if empty router, then redirect to welcome page
        {path: '**', redirectTo: 'home', pathMatch: 'full'}//any other route that are not found, redirect to welcome page or you can do a custom 404 page
      ]) 
  ],
  declarations: [ 
    AppComponent,
    HomeComponent, 
    AdminComponent 
  ],
  bootstrap: [ 
    AppComponent 
  ]
})
export class AppModule { }
