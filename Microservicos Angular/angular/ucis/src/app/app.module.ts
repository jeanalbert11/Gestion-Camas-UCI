import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PacientesComponent } from './components/pacientes/pacientes.component';
import { EnfermerasComponent } from './components/enfermeras/enfermeras.component';
import { HomeComponent } from './components/home/home.component';
import { LayoutModule } from './layout/layout.module';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    PacientesComponent,
    EnfermerasComponent,
    HomeComponent,
  ],
  imports: [
    BrowserModule, 
    AppRoutingModule, 
    LayoutModule, 
    HttpClientModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
