import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { OperacionesComponent } from './operaciones/operaciones.component';
import { HttpClientModule } from '@angular/common/http';
import { Consulta2Component } from './operaciones/consulta2.component';

const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch:'full'},
  {path: 'home', component: HomeComponent},
  {path: 'operaciones', component: OperacionesComponent},
  {path: 'consulta2', component: Consulta2Component}
]
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    FooterComponent,
    HeaderComponent,
    OperacionesComponent,
    Consulta2Component
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(routes),
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
