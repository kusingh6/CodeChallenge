import { TestBed, async, ComponentFixture } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { EnrolmentDetailComponent } from './enrolment-detail.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { KeycloakService } from 'keycloak-angular';
import { EnrolmentService } from '../../services/enrolment.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';

class MockKeycloakService {
  getKeycloakInstance() {
    return {
      profile: {
        lastName: '',
        firstName: '',
        username: 'vysakh'
      }
    };
  }
}

describe('EnrolmentDetailComponent', () => {
  let component: EnrolmentDetailComponent;
  let fixture: ComponentFixture<EnrolmentDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        RouterTestingModule,
        HttpClientTestingModule,
        ReactiveFormsModule,
        FormsModule
      ],
      declarations: [
        EnrolmentDetailComponent
      ],
      providers: [
        { provide: KeycloakService, useClass: MockKeycloakService },
        EnrolmentService
      ]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EnrolmentDetailComponent);
    component = fixture.componentInstance;
    component.ngOnInit();
    fixture.detectChanges();
  });

  it('should create the enrolment-detail', () => {
    expect(component).toBeTruthy();
  });

  it('enrolmentForm invalid when empty', () => {
    expect(component.enrolmentForm.valid).toBeTruthy();
  });

  it('enrolmentForm submit', () => {
    // tslint:disable-next-line: no-string-literal
    component.enrolmentForm.controls['pharmacistRegNo'].setValue('1234');
    // tslint:disable-next-line: no-string-literal
    component.enrolmentForm.controls['fullName'].setValue('vysakh');
  });

});
