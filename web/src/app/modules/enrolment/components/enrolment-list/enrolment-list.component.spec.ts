import { TestBed, async } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { EnrolmentListComponent } from './enrolment-list.component';
import { EnrolmentService } from '../../services/enrolment.service';

describe('EnrolmentListComponent', () => {
    beforeEach(async(() => {
      TestBed.configureTestingModule({
        imports: [
          RouterTestingModule,
          HttpClientTestingModule
        ],
        declarations: [
          EnrolmentListComponent
        ],
        providers: [
          EnrolmentService
        ]
      }).compileComponents();
    }));

    it('should create the enrolment-list', () => {
      const fixture = TestBed.createComponent(EnrolmentListComponent);
      const enrolmentList = fixture.debugElement.componentInstance;
      expect(enrolmentList).toBeTruthy();
    });
});
