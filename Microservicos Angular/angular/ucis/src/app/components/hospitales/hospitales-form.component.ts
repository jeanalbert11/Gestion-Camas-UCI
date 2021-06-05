import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Hospital } from 'src/app/models/hospital';
import { HospitalService } from 'src/app/services/hospital.service';
import { CommonFormComponent } from '../common-form.component';

@Component({
  selector: 'app-hospitales-form',
  templateUrl: './hospitales-form.component.html',
  styleUrls: ['./hospitales-form.component.css'],
})
export class HospitalesFormComponent
  extends CommonFormComponent<Hospital, HospitalService>
  implements OnInit
{
  hospital: Hospital = new Hospital();
  error: any;

  //Inyeccion de dependencias
  constructor(service: HospitalService, router: Router, route: ActivatedRoute) {
    super(service, router, route);
    this.title = 'Create hospitals';
    this.model = new Hospital();
    this.redirect = '/hospitales';
    this.nombreModel = Hospital.name;
  }
}
