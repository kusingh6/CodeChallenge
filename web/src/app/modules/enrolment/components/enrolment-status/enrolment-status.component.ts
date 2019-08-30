import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EnrolmentResponse } from '../../models/enrolment-response';

@Component({
  selector: 'app-enrolment-status',
  templateUrl: './enrolment-status.component.html',
  styleUrls: ['./enrolment-status.component.scss']
})
export class EnrolmentStatusComponent implements OnInit {

  enrolmentResponse: EnrolmentResponse;

  constructor(
    private router: Router) {
      this.enrolmentResponse = this.router.getCurrentNavigation().extras.state as EnrolmentResponse;
    }

  ngOnInit() { }

}
