import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { END_POINT_BASE } from '../config/app';
import { Hospital } from '../models/hospital';
import { CommonService } from './common.service';

@Injectable({
  providedIn: 'root',
})
export class HospitalService extends CommonService<Hospital> {
  protected urlEndPoint: string = END_POINT_BASE + '/units/hospitals';

  constructor(http: HttpClient) {
    super(http);
  }
}
