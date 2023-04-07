import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Nurse } from 'src/app/models/nurse';
import { NurseService } from 'src/app/services/nurse.service';
import Swal from 'sweetalert2';
import { CommonFormComponent } from '../common-form.component';

@Component({
  selector: 'app-enfermeras-form',
  templateUrl: './enfermeras-form.component.html',
  styleUrls: ['./enfermeras-form.component.css'],
})
export class EnfermerasFormComponent
  extends CommonFormComponent<Nurse, NurseService>
  implements OnInit
{
  nurse: Nurse = new Nurse();
  error: any;
  private photo!: File;

  //Inyeccion de dependencias
  constructor(service: NurseService, router: Router, route: ActivatedRoute) {
    super(service, router, route);
    this.title = 'Create nurses';
    this.model = new Nurse();
    this.redirect = '/enfermeras';
    this.nombreModel = Nurse.name;
  }

  public seleccionarFoto(event): void {
    this.photo = event.target.files[0];
    console.info(this.photo);
    if (this.photo.type.indexOf('image') < 0) {
      this.photo === null;
      Swal.fire('Error:', 'El archivo debe ser de tipo imagen', 'error');
    }
  }
  public crear(): void {
    if (!this.photo) {
      super.crear();
    } else {
      this.service.createProfileImage(this.model, this.photo).subscribe(
        (nurse) => {
          console.log(nurse);
          Swal.fire(
            'Created:',
            `${this.nombreModel} ${nurse.name} was created successfully`,
            'success'
          );
          this.router.navigate([this.redirect]);
        },
        (err) => {
          if (err.status === 400) {
            this.error = err.error;
            console.log(this.error);
          }
        }
      );
    }
  }
  public editar(): void {
    if (!this.photo) {
      super.editar();
    } else {
      this.service.updateProfileImage(this.model, this.photo).subscribe(
        (nurse) => {
          console.log(nurse);
          Swal.fire(
            'Update:',
            `${this.nombreModel} ${nurse.name} was created successfully`,
            // `${this.nombreModel} ${m.id} was created successfully`,
            'success'
          );
          this.router.navigate([this.redirect]);
        },
        (err) => {
          if (err.status === 400) {
            this.error = err.error;
            console.log(this.error);
          }
        }
      );
    }
  }
}
