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
    formData.append('identityCard', nurse.identityCard);
    formData.append('professionalCard', nurse.professionalCard);
    formData.append('name', nurse.name);
    formData.append('surname', nurse.surname);
    formData.append('email', nurse.email);
    return this.http.post<Nurse>(
      this.urlEndPoint + '/crear-con-foto',
      formData
    );
  }

  updateProfileImage(nurse: Nurse, archivo: File): Observable<Nurse> {
    const formData = new FormData();
    formData.append('archivo', archivo);
    formData.append('identityCard', nurse.identityCard);
    formData.append('professionalCard', nurse.professionalCard);
    formData.append('name', nurse.name);
    formData.append('surname', nurse.surname);
    formData.append('email', nurse.email);
    return this.http.put<Nurse>(
      `${this.urlEndPoint}/editar-con-foto/${nurse.id}`,
      formData
    );
  }
}
