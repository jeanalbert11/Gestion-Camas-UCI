import { Component, OnInit } from '@angular/core';
import { Patient } from 'src/app/models/patient';
import { PatientService } from 'src/app/services/patient.service';
// Controlador
@Component({
  selector: 'app-pacientes',
  templateUrl: './pacientes.component.html',
  styleUrls: ['./pacientes.component.css'],
})
export class PacientesComponent implements OnInit {
  title: string = 'Patients List';
  patients!: Patient[];

  //Inyeccion de dependencias
  constructor(private service: PatientService) {}

  ngOnInit(): void {
    this.service.listar().subscribe((patients) => this.patients = patients);
  }
}
