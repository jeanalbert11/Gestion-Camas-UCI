import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { END_POINT_BASE } from '../config/app';
import { Bed } from '../models/bed';
import { Nurse } from '../models/nurse';
import { CommonService } from './common.service';

@Injectable({
  providedIn: 'root',
})
export class BedService extends CommonService<Bed> {
  protected urlEndPoint: string = END_POINT_BASE + '/beds';

  //Inyeccion de dependencias
  constructor(http: HttpClient) {
    super(http);
  }
  public filtraPorCodigo(room: string): Observable<Bed[]> {
    return this.http.get<Bed[]>(`${this.urlEndPoint}/filtrarPorCodigo/${room}`);
  }

  findAllNurses(): Observable<Nurse[]> {
    return this.http.get<Nurse[]>(`${this.urlEndPoint}/nurses`);
  }
}
