import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Nurse } from '../models/nurse';
import { CommonService } from './common.service';
import { END_POINT_BASE } from '../config/app';
@Injectable({
  providedIn: 'root',
})
export class NurseService extends CommonService<Nurse> {
  protected urlEndPoint: string = END_POINT_BASE + '/nurses';

  constructor(http: HttpClient) {
    super(http);
  }

  createProfileImage(nurse: Nurse, archivo: File): Observable<Nurse> {
    const formData = new FormData();
    formData.append('archivo', archivo);
    formData.append('cedula', nurse.cedula);
    formData.append('tarjetaProfesional', nurse.tarjetaProfesional);
    formData.append('nombre', nurse.nombre);
    formData.append('apellido', nurse.apellido);
    formData.append('correo', nurse.correo);
    return this.http.post<Nurse>(
      this.urlEndPoint + '/crear-con-foto',
      formData
    );
  }

  updateProfileImage(nurse: Nurse, archivo: File): Observable<Nurse> {
    const formData = new FormData();
    formData.append('archivo', archivo);
    formData.append('cedula', nurse.cedula);
    formData.append('tarjetaProfesional', nurse.tarjetaProfesional);
    formData.append('nombre', nurse.nombre);
    formData.append('apellido', nurse.apellido);
    formData.append('correo', nurse.correo);
    return this.http.put<Nurse>(
      `${this.urlEndPoint}/editar-con-foto/${nurse.id}`,
      formData
    );
  }
}
