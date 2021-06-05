import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { END_POINT_BASE } from '../config/app';
import { Patient } from '../models/patient';
import { CommonService } from './common.service';

@Injectable({
  providedIn: 'root',
})
export class PatientService extends CommonService<Patient> {
  // protected urlEndPoint: string = 'http://localhost:8090/api/beds/patients';
  protected urlEndPoint: string = END_POINT_BASE + '/patients';

  //Inyeccion de dependencias
  constructor(http: HttpClient) {
    super(http);
  }

  // public listar(): Observable<Patient[]> {
  //   return this.http.get<Patient[]>(this.urlEndPoint);
  // }

  // public ver(id: number): Observable<Patient> {
  //   return this.http.get<Patient>(`${this.urlEndPoint}/${id}`);
  // }

  // public crear(patient: Patient): Observable<Patient> {
  //   return this.http.post<Patient>(this.urlEndPoint, patient, {
  //     headers: this.cabeceras,
  //   });
  // }

  // public editar(patient: Patient): Observable<Patient> {
  //   return this.http.put<Patient>(
  //     `${this.urlEndPoint}/${patient.id}`,
  //     patient,
  //     { headers: this.cabeceras }
  //   );
  // }

  // public eliminar(id: number): Observable<void> {
  //   return this.http.delete<void>(`${this.urlEndPoint}/${id}`);
  // }
}
