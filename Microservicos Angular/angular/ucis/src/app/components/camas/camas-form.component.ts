import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Bed } from 'src/app/models/bed';
import { Nurse } from 'src/app/models/nurse';
import { BedService } from 'src/app/services/bed.service';
import { CommonFormComponent } from '../common-form.component';

@Component({
  selector: 'app-camas-form',
  templateUrl: './camas-form.component.html',
  styleUrls: ['./camas-form.component.css'],
})
export class CamasFormComponent
  extends CommonFormComponent<Bed, BedService>
  implements OnInit
{
  bed: Bed = new Bed();
  error: any;
  //Para llenar el drown down list
  nurses: Nurse[] = [];

  //Inyeccion de dependencias
  constructor(service: BedService, router: Router, route: ActivatedRoute) {
    super(service, router, route);
    this.title = 'Create beds';
    this.model = new Bed();
    this.redirect = '/camas';
    this.nombreModel = Bed.name;
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe((params) => {
      // const id: number = params.get('id');
      const id: number = +params.get('id');
      if (id) {
        this.service.ver(id).subscribe((m) => {
          this.model = m;
          this.title = 'Editar ' + this.nombreModel;
        });
      }
    });   
    // obtenemos todas las enfermeras
    this.service
      .findAllNurses()
      .subscribe((nurses) => (this.nurses = nurses)); 
  }

}
