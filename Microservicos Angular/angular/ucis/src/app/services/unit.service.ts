import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { END_POINT_BASE } from '../config/app';
import { Bed } from '../models/bed';
import { Unit } from '../models/unit';
import { CommonService } from './common.service';

@Injectable({
  providedIn: 'root',
})
export class UnitService extends CommonService<Unit> {
  protected urlEndPoint: string = END_POINT_BASE + '/units';

  //Inyeccion de dependencias
  constructor(http: HttpClient) { 
    super(http);
  }

  asignarCamas(unit: Unit, beds: Bed[]): Observable<Bed> {
    //se envia el id del model en el cuerpo del request
    return this.http.put<Bed>(`${this.urlEndPoint}/${unit.id}/asignar-camas`, beds,
    {headers: this.cabeceras});    
  }

  eliminarCama(unit: Unit, bed: Bed): Observable<Bed> {
    //se envia el id del model en el cuerpo del request
    return this.http.put<Bed>(`${this.urlEndPoint}/${unit.id}/eliminar-cama`, bed,
    {headers: this.cabeceras});    
  }
}
