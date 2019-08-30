import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from './core/guards/auth.guard';


const routes: Routes = [
  {
    path: '',
    redirectTo: '/pharmacist/enrolment',
    canActivate: [AuthGuard],
    data: { roles: [] },
    pathMatch: 'full'
  },
  {
    path: 'pharmacist',
    canActivate: [AuthGuard],
    data: { roles: [] },
    loadChildren: () =>
      import('./modules/enrolment/enrolment.module').then(m => m.EnrolmentModule)
  },
  // Fallback when no prior routes is matched
  { path: '**', redirectTo: '/', pathMatch: 'full' }
];

@NgModule({
  imports: [
    RouterModule.forRoot(
      routes,
    )],
  exports: [RouterModule]
})
export class AppRoutingModule { }
