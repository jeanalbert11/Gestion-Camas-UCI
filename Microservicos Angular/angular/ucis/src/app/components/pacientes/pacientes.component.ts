import { Component, OnInit } from '@angular/core';
import { Patient } from 'src/app/models/patient';
import { PatientService } from 'src/app/services/patient.service';
import { CommonListarComponent } from '../common-listar.component';

// Controlador
@Component({
  selector: 'app-pacientes',
  templateUrl: './pacientes.component.html',
  styleUrls: ['./pacientes.component.css'],
})
export class PacientesComponent
  extends CommonListarComponent<Patient, PatientService>
  implements OnInit
{
  // patients!: Patient[];

  //Inyeccion de dependencias
  constructor(service: PatientService) {
    super(service);
    this.title = 'Patients List';
    this.nombreModelo = Patient.name;
  }

  // ngOnInit(): void {
  //   this.service.listar().subscribe((patients) => (this.patients = patients));
  // }

  // public eliminar(patient: Patient): void {
  //   Swal.fire({
  //     title: `Are you sure you want to eliminate ${patient.nombre}?`,
  //     text: "You won't be able to revert this!",
  //     icon: 'warning',
  //     showCancelButton: true,
  //     confirmButtonColor: '#FE0008',
  //     cancelButtonColor: '#00EBFE',
  //     confirmButtonText: 'Yes, delete it!',
  //   }).then((result) => {
  //     if (result.isConfirmed) {
  //       this.service.eliminar(patient.id).subscribe(() => {
  //         this.patients = this.patients.filter((p) => p !== patient);
  //         Swal.fire(
  //           'Delete',
  //           `Patient ${patient.nombre} was delete successfully`,
  //           'warning'
  //         );
  //       });
  //     }
  //   });
  // }
}
