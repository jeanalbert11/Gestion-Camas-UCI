import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Patient } from 'src/app/models/patient';
import { PatientService } from 'src/app/services/patient.service';
import { CommonFormComponent } from '../common-form.component';

@Component({
  selector: 'app-pacientes-form',
  templateUrl: './pacientes-form.component.html',
  styleUrls: ['./pacientes-form.component.css'],
})
export class PacientesFormComponent
  extends CommonFormComponent<Patient, PatientService>
  implements OnInit
{
  patient: Patient = new Patient();
  error: any;

  //Inyeccion de dependencias
  constructor(service: PatientService, router: Router, route: ActivatedRoute) {
    super(service, router, route);
    this.title = 'Create patients';
    this.model = new Patient();
    this.redirect = '/pacientes';
    this.nombreModel = Patient.name;
  }

  // ngOnInit(): void {
  //   this.route.paramMap.subscribe((params) => {
  //     const id: number = +params.get('id');
  //     if (id) {
  //       this.service.ver(id).subscribe((patient) => (this.patient = patient));
  //     }
  //   });
  // }

  // public crear(): void {
  //   this.service.crear(this.patient).subscribe(
  //     (patient) => {
  //       console.log(patient);
  //       Swal.fire(
  //         'Created:',
  //         `Patient ${patient.nombre} was created successfully`,
  //         'success'
  //       );
  //       this.router.navigate(['/pacientes']);
  //     },
  //     (err) => {
  //       if (err.status === 400) {
  //         this.error = err.error;
  //         console.log(this.error);
  //       }
  //     }
  //   );
  // }
  // public editar(): void {
  //   this.service.editar(this.patient).subscribe(
  //     (patient) => {
  //       console.log(patient);
  //       Swal.fire('Edit',`Patient ${patient.nombre} was update successfully`,'success');
  //       this.router.navigate(['/pacientes']);
  //     },
  //     (err) => {
  //       if (err.status === 400) {
  //         this.error = err.error;
  //         console.log(this.error);
  //       }
  //     }
  //   );
  // }
}
