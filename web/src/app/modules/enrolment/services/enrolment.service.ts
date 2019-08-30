import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Enrolment } from '../models/enrolment';
import { EnrolmentResponse } from '../models/enrolment-response';

@Injectable()
export class EnrolmentService {

  constructor(private http: HttpClient) { }

  addEnrolment(enrolment: Enrolment): Observable<EnrolmentResponse> {
    return this.http.post<EnrolmentResponse>(`${environment.apiUrl}/application`, enrolment);
  }

  getEnrolmentList(): Observable<Enrolment[]> {
    return this.http.get<Enrolment[]>(`${environment.apiUrl}/application`);
  }

}
