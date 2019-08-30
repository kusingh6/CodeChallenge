import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { EnrolmentResponse } from '../../models/enrolment-response';

@Component({
  selector: 'app-enrolment-status',
  templateUrl: './enrolment-status.component.html',
  styleUrls: ['./enrolment-status.component.scss']
})
export class EnrolmentStatusComponent implements OnInit {

  enrolmentResponse: EnrolmentResponse;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private location: Location) {
      this.enrolmentResponse = this.router.getCurrentNavigation().extras.state.example as EnrolmentResponse;
    }

  ngOnInit() { }

}
