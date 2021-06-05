import { Component, OnInit } from '@angular/core';
import { Unit } from 'src/app/models/unit';
import { UnitService } from 'src/app/services/unit.service';
import { CommonListarComponent } from '../common-listar.component';

@Component({
  selector: 'app-unidades',
  templateUrl: './unidades.component.html',
  styleUrls: ['./unidades.component.css'],
})
export class UnidadesComponent
  extends CommonListarComponent<Unit, UnitService>
  implements OnInit
{
  //Inyeccion de dependencias
  constructor(service: UnitService) {
    super(service);
    this.title = 'Units List';
    this.nombreModelo = Unit.name;
  }
}
