import { TestBed, async } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { EnrolmentStatusComponent } from './enrolment-status.component';

describe('EnrolmentDetailComponent', () => {
    beforeEach(async(() => {
      TestBed.configureTestingModule({
        imports: [
          RouterTestingModule
        ],
        declarations: [
          EnrolmentStatusComponent
        ],
      }).compileComponents();
    }));

    it('should create the enrolment-status', () => {
      const fixture = TestBed.createComponent(EnrolmentStatusComponent);
      const enrolmentStatus = fixture.debugElement.componentInstance;
      expect(enrolmentStatus).toBeTruthy();
    });
});
