import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpHeaders
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { KeycloakService } from 'keycloak-angular';

@Injectable()
export class TokenInterceptor implements HttpInterceptor {

  constructor(
    private keycloakService: KeycloakService
  ) { }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const keycloakToken = this.keycloakService.getKeycloakInstance().token;
    const authRequest = request.clone({
      headers: new HttpHeaders({
        Authorization: `Bearer ${{keycloakToken}}`
      })
    });

    return next.handle(authRequest);
  }
}
