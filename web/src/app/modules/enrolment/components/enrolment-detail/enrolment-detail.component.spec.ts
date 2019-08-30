import { TestBed, async } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { EnrolmentDetailComponent } from './enrolment-detail.component';

describe('EnrolmentDetailComponent', () => {
    beforeEach(async(() => {
      TestBed.configureTestingModule({
        imports: [
          RouterTestingModule
        ],
        declarations: [
          EnrolmentDetailComponent
        ],
      }).compileComponents();
    }));

    it('should create the enrolment-detail', () => {
      const fixture = TestBed.createComponent(EnrolmentDetailComponent);
      const enrolmentDetail = fixture.debugElement.componentInstance;
      expect(enrolmentDetail).toBeTruthy();
    });
});
