import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { EnrolmentDetailComponent } from './components/enrolment-detail/enrolment-detail.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { EnrolmentRoutingModule } from './enrolment.routing';
import { EnrolmentService } from './services/enrolment.service';
import { EnrolmentStatusComponent } from './components/enrolment-status/enrolment-status.component';
import { EnrolmentListComponent } from './components/enrolment-list/enrolment-list.component';

@NgModule({
    declarations: [
        EnrolmentDetailComponent,
        EnrolmentListComponent,
        EnrolmentStatusComponent
    ],
    imports: [
        CommonModule,
        ReactiveFormsModule,

        SharedModule,

        EnrolmentRoutingModule
    ],
    exports: [],
    providers: [EnrolmentService]
})
export class EnrolmentModule { }
