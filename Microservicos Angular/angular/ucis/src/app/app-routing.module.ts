import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EnfermerasComponent } from './components/enfermeras/enfermeras.component';
import { HomeComponent } from './components/home/home.component';
import { PacientesComponent } from './components/pacientes/pacientes.component';

// Configuracion de  las rutas
const routes: Routes = [
  { path: '', pathMatch:'full', redirectTo: 'home'},
  { path: 'home', component: HomeComponent },
  { path: 'pacientes', component: PacientesComponent },
  { path: 'enfermeras', component: EnfermerasComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
