import { TestBed, async } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { EnrolmentDetailComponent } from './enrolment-detail.component';
import { ReactiveFormsModule } from '@angular/forms';
import { KeycloakService } from 'keycloak-angular';
import { EnrolmentService } from '../../services/enrolment.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';

describe('EnrolmentDetailComponent', () => {
    beforeEach(async(() => {
      TestBed.configureTestingModule({
        imports: [
          RouterTestingModule,
          HttpClientTestingModule,
          ReactiveFormsModule
        ],
        declarations: [
          EnrolmentDetailComponent
        ],
        providers: [
          KeycloakService,
          EnrolmentService
        ]
      }).compileComponents();
    }));

    it('should create the enrolment-detail', () => {
      const fixture = TestBed.createComponent(EnrolmentDetailComponent);
      const enrolmentDetail = fixture.debugElement.componentInstance;
      expect(enrolmentDetail).toBeTruthy();
    });
});
