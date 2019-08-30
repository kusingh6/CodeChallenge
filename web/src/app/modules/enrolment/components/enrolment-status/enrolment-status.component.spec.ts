import { TestBed, async } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { EnrolmentStatusComponent } from './enrolment-status.component';
import { EnrolmentResponse } from '../../models/enrolment-response';
import { Router } from '@angular/router';
class RouterStub {
  getCurrentNavigation() {
    return {
      extras: {
        state: {
          status: true,
          referenceId: '1234',
          message: 'success'
        } as EnrolmentResponse
      }
    };
  }
}

describe('EnrolmentDetailComponent', () => {
    beforeEach(async(() => {
      TestBed.configureTestingModule({
        imports: [
          RouterTestingModule
        ],
        declarations: [
          EnrolmentStatusComponent
        ],
        providers: [{ provide: Router, useClass: RouterStub }]
      }).compileComponents();
    }));

    it('should create the enrolment-status', () => {
      const fixture = TestBed.createComponent(EnrolmentStatusComponent);
      const enrolmentStatus = fixture.debugElement.componentInstance;
      expect(enrolmentStatus).toBeTruthy();
    });
});
