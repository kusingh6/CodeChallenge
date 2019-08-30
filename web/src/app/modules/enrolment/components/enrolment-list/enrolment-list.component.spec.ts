import { TestBed, async } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { EnrolmentListComponent } from './enrolment-list.component';

describe('EnrolmentListComponent', () => {
    beforeEach(async(() => {
      TestBed.configureTestingModule({
        imports: [
          RouterTestingModule
        ],
        declarations: [
          EnrolmentListComponent
        ],
      }).compileComponents();
    }));

    it('should create the enrolment-list', () => {
      const fixture = TestBed.createComponent(EnrolmentListComponent);
      const enrolmentList = fixture.debugElement.componentInstance;
      expect(enrolmentList).toBeTruthy();
    });
});
