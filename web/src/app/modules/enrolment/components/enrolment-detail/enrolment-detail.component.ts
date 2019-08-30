import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { EnrolmentService } from '../../services/enrolment.service';
import { Enrolment } from '../../models/enrolment';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ValidationService } from 'src/app/shared/services/validation/validation.service';
import { KeycloakService } from 'keycloak-angular';

@Component({
  selector: 'app-enrolment-detail',
  templateUrl: './enrolment-detail.component.html',
  styleUrls: ['./enrolment-detail.component.scss']
})
export class EnrolmentDetailComponent implements OnInit {

  enrolmentModel = new Enrolment();

  pharmacistRegNoLength = 4;

  enrolmentForm = new FormGroup({
    pharmacistRegNo: new FormControl(
      this.enrolmentModel.pharmacistRegNo,
      ValidationService.emptyOrFixedLengthNumberValidator(this.pharmacistRegNoLength)),
    fullName: new FormControl(this.enrolmentModel.applicantName, Validators.required)
  });

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private keycloakService: KeycloakService,
    private enrolmentService: EnrolmentService) { }

  ngOnInit() {
    const userDetails = this.keycloakService.getKeycloakInstance().profile;
    let fullName = userDetails.lastName || '';
    if (userDetails.firstName) {
      fullName = fullName ? fullName + ' ' + userDetails.firstName : '';
    } else {
      fullName = userDetails.username;
    }
    this.enrolmentForm.patchValue({ fullName });
   }

  onEnrolmentSubmit() {
    if (this.enrolmentForm.valid) {
      this.enrolmentService.addEnrolment(this.enrolmentModel).subscribe(response => {
        this.router.navigate(['../status'], { relativeTo: this.route, state: response });
      });
    }
  }
}
