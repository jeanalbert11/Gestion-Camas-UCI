import { Component, OnInit } from '@angular/core';
import { Bed } from 'src/app/models/bed';
import { BedService } from 'src/app/services/bed.service';
import { CommonListarComponent } from '../common-listar.component';

@Component({
  selector: 'app-camas',
  templateUrl: './camas.component.html',
  styleUrls: ['./camas.component.css'],
})
export class CamasComponent
  extends CommonListarComponent<Bed, BedService>
  implements OnInit
{
  //Inyeccion de dependencias
  constructor(service: BedService) {
    super(service);
    this.title = 'Beds List';
    this.nombreModelo = Bed.name;
  }
  
}
