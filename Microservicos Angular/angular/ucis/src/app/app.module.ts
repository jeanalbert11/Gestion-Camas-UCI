import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PacientesComponent } from './components/pacientes/pacientes.component';

import { HomeComponent } from './components/home/home.component';
import { LayoutModule } from './layout/layout.module';
import { HttpClientModule } from '@angular/common/http';
import { PacientesFormComponent } from './components/pacientes/pacientes-form.component';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
// import { LoginComponent } from './components/usuarios/login.component';
import { EnfermerasComponent } from './components/enfermeras/enfermeras.component';
import { EnfermerasFormComponent } from './components/enfermeras/enfermeras-form.component';
import { HospitalesComponent } from './components/hospitales/hospitales.component';
import { HospitalesFormComponent } from './components/hospitales/hospitales-form.component';
import { UnidadesComponent } from './components/unidades/unidades.component';
import { UnidadesFormComponent } from './components/unidades/unidades-form.component';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatPaginatorModule} from '@angular/material/paginator';
import { AsignarCamasComponent } from './components/unidades/asignar-camas.component';
import { CamasComponent } from './components/camas/camas.component';
import { CamasFormComponent } from './components/camas/camas-form.component';
// Modulos para asignar camas a unidades
import { MatTableModule } from '@angular/material/table';
import { MatInputModule } from '@angular/material/input';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatButtonModule } from '@angular/material/button';
import { HistoryAssignmentsComponent } from './components/historyAssignments/history-assignments.component';
import { HistoryAssignmentsFormComponent } from './components/historyAssignments/history-assignments-form.component';
import { MatCardModule} from '@angular/material/card';
import {MatTabsModule} from '@angular/material/tabs';
import {MatRadioModule} from '@angular/material/radio';
import {MatButtonToggleModule} from '@angular/material/button-toggle';












@NgModule({
  declarations: [
    AppComponent,
    PacientesComponent,
    EnfermerasComponent,
    HomeComponent,
    PacientesFormComponent,
    EnfermerasFormComponent,
    // LoginComponent,
    HospitalesComponent,
    HospitalesFormComponent,
    UnidadesComponent,
    UnidadesFormComponent,
    AsignarCamasComponent,
    CamasComponent,
    CamasFormComponent,
    HistoryAssignmentsComponent,
    HistoryAssignmentsFormComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    LayoutModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatInputModule,
    MatCheckboxModule,
    MatButtonModule,
    BrowserAnimationsModule,
    MatPaginatorModule,
    MatTableModule,    
    MatCardModule,
    MatTabsModule,
    MatRadioModule,
  MatButtonToggleModule,

  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
