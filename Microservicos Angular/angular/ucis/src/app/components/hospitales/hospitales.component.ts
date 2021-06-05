import { Component, OnInit } from '@angular/core';
import { Hospital } from 'src/app/models/hospital';
import { HospitalService } from 'src/app/services/hospital.service';
import { CommonListarComponent } from '../common-listar.component';

@Component({
  selector: 'app-hospitales',
  templateUrl: './hospitales.component.html',
  styleUrls: ['./hospitales.component.css'],
})
export class HospitalesComponent
  extends CommonListarComponent<Hospital, HospitalService>
  implements OnInit
{
  //Inyeccion de dependencias
  constructor(service: HospitalService) {
    super(service);
    this.title = 'Hospitals List';
    this.nombreModelo = Hospital.name;
  }
}
