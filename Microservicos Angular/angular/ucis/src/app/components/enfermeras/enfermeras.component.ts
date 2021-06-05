import { Component, OnInit } from '@angular/core';
import { END_POINT_BASE } from '../../config/app';
import { Nurse } from 'src/app/models/nurse';
import { NurseService } from 'src/app/services/nurse.service';
import { CommonListarComponent } from '../common-listar.component';

@Component({
  selector: 'app-enfermeras',
  templateUrl: './enfermeras.component.html',
  styleUrls: ['./enfermeras.component.css'],
})
export class EnfermerasComponent
  extends CommonListarComponent<Nurse, NurseService>
  implements OnInit
{
   urlEndPoint: string = END_POINT_BASE + '/nurses';

  constructor(service: NurseService) {
    super(service);
    this.title = 'Nurses List';
    this.nombreModelo = Nurse.name;
  }
}
