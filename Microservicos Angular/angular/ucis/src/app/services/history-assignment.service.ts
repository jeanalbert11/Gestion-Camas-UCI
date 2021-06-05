import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Bed } from '../models/bed';
import { HistoryAssignment } from '../models/history-assignment';
import { Patient } from '../models/patient';
import { CommonService } from './common.service';
import { END_POINT_BASE } from '../config/app';

@Injectable({
  providedIn: 'root',
})
export class HistoryAssignmentService extends CommonService<HistoryAssignment> {
  protected urlEndPoint: string = END_POINT_BASE + '/beds/historyAssignments';

  constructor(http: HttpClient) {
    super(http);
  }

  findAllPatients(): Observable<Patient[]> {
    return this.http.get<Patient[]>(`${this.urlEndPoint}/patients`);
  }
  findAllBeds(): Observable<Bed[]> {
    return this.http.get<Bed[]>(`${this.urlEndPoint}/beds`);
  }
}
