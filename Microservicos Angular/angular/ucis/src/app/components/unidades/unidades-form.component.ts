import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Unit } from 'src/app/models/unit';
import { UnitService } from 'src/app/services/unit.service';
import { CommonFormComponent } from '../common-form.component';

@Component({
  selector: 'app-unidades-form',
  templateUrl: './unidades-form.component.html',
  styleUrls: ['./unidades-form.component.css'],
})
export class UnidadesFormComponent
  extends CommonFormComponent<Unit, UnitService>
  implements OnInit
{
  unit: Unit = new Unit();
  error: any;

  //Inyeccion de dependencias
  constructor(service: UnitService, router: Router, route: ActivatedRoute) {
    super(service, router, route);
    this.title = 'Create units';
    this.model = new Unit();
    this.redirect = '/unidades';
    this.nombreModel = Unit.name;
  }
}
