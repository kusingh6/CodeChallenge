import { TestBed, async, ComponentFixture } from '@angular/core/testing';
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

describe('EnrolmentStatusComponent', () => {
  let component: EnrolmentStatusComponent;
  let fixture: ComponentFixture<EnrolmentStatusComponent>;

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

  beforeEach(() => {
    fixture = TestBed.createComponent(EnrolmentStatusComponent);
    component = fixture.componentInstance;
    component.ngOnInit();
    fixture.detectChanges();
  });

  it('should create the enrolment-status', () => {
    expect(component).toBeTruthy();
  });

  it('enrolmentResponse has valid referenceId', () => {
    expect(component.enrolmentResponse.referenceId).toBe('1234');
  });
});
