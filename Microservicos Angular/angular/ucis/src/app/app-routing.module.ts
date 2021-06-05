import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CamasFormComponent } from './components/camas/camas-form.component';
import { CamasComponent } from './components/camas/camas.component';
import { EnfermerasFormComponent } from './components/enfermeras/enfermeras-form.component';
import { EnfermerasComponent } from './components/enfermeras/enfermeras.component';
import { HistoryAssignmentsFormComponent } from './components/historyAssignments/history-assignments-form.component';
import { HistoryAssignmentsComponent } from './components/historyAssignments/history-assignments.component';
import { HomeComponent } from './components/home/home.component';
import { HospitalesFormComponent } from './components/hospitales/hospitales-form.component';
import { HospitalesComponent } from './components/hospitales/hospitales.component';
import { PacientesFormComponent } from './components/pacientes/pacientes-form.component';
import { PacientesComponent } from './components/pacientes/pacientes.component';
import { AsignarCamasComponent } from './components/unidades/asignar-camas.component';
import { UnidadesFormComponent } from './components/unidades/unidades-form.component';
import { UnidadesComponent } from './components/unidades/unidades.component';
import { LoginComponent } from './components/usuarios/login.component';

// Configuracion de  las rutas
const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'home' },

  { path: 'home', component: HomeComponent },
  { path: 'hospitales', component: HospitalesComponent },
  { path: 'hospitales/form', component: HospitalesFormComponent },
  { path: 'hospitales/form/:id', component: HospitalesFormComponent },

  { path: 'historyAssignments', component: HistoryAssignmentsComponent},
  { path: 'historyAssignments/form', component: HistoryAssignmentsFormComponent},
  { path: 'historyAssignments/form/:id', component: HistoryAssignmentsFormComponent },


  { path: 'enfermeras', component: EnfermerasComponent },
  { path: 'enfermeras/form', component: EnfermerasFormComponent },
  { path: 'enfermeras/form/:id', component: EnfermerasFormComponent },

  { path: 'unidades', component: UnidadesComponent },
  { path: 'unidades/form', component: UnidadesFormComponent },
  { path: 'unidades/form/:id', component: UnidadesFormComponent },
  { path: 'unidades/asignar-camas/:id', component: AsignarCamasComponent },

  { path: 'pacientes', component: PacientesComponent },
  { path: 'pacientes/form', component: PacientesFormComponent },
  { path: 'pacientes/form/:id', component: PacientesFormComponent },

  { path: 'camas', component: CamasComponent },
  { path: 'camas/form', component: CamasFormComponent },
  { path: 'camas/form/:id', component: CamasFormComponent },

  // { path: 'login', component: LoginComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
