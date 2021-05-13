import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Patient } from '../models/patient';

@Injectable({
  providedIn: 'root',
})
export class PatientService {
  private urlEndPoint: string = 'http://localhost:8090/api/patients';
  private cabeceras: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
  });
  //Inyeccion de dependencias
  constructor(private http: HttpClient) {}

  public listar(): Observable<Patient[]> {
    return this.http.get<Patient[]>(this.urlEndPoint);
  }

  public ver(id: number): Observable<Patient> {
    return this.http.get<Patient>(`${this.urlEndPoint}/${id}`);
  }

  public crear(patient: Patient): Observable<Patient> {
    return this.http.post<Patient>(this.urlEndPoint, patient, {
      headers: this.cabeceras,
    });
  }

  public editar(patient: Patient): Observable<Patient> {
    return this.http.put<Patient>(
      `${this.urlEndPoint}/${patient.id}`,
      patient,
      { headers: this.cabeceras }
    );
  }

  public eliminar(id: number): Observable<void> {
    return this.http.delete<void>(`${this.urlEndPoint}/${id}`);
  }
}
