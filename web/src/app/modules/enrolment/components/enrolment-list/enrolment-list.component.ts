import { Component, OnInit } from '@angular/core';

import { EnrolmentService } from '../../services/enrolment.service';
import { Enrolment } from '../../models/enrolment';

@Component({
  selector: 'app-enrolment-list',
  templateUrl: './enrolment-list.component.html',
  styleUrls: ['./enrolment-list.component.scss']
})
export class EnrolmentListComponent implements OnInit {

  enrolmentList: Enrolment[];

  constructor(
    private enrolmentService: EnrolmentService) { }

  ngOnInit() {
    this.enrolmentService.getEnrolmentList().subscribe(response => {
      this.enrolmentList = response;
    });
   }
}
