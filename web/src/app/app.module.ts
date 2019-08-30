import { BrowserModule } from '@angular/platform-browser';
import { NgModule, APP_INITIALIZER, DoBootstrap } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { KeycloakService, KeycloakAngularModule } from 'keycloak-angular';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { CoreModule } from './core/core.module';
import { SharedModule } from './shared/shared.module';
import { environment } from 'src/environments/environment';

const keycloakService = new KeycloakService();

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,

    KeycloakAngularModule,

    CoreModule,
    SharedModule
  ],
  providers: [
    {
      provide: KeycloakService,
      useValue: keycloakService
    }
  ],
  entryComponents: [AppComponent]
})
export class AppModule implements DoBootstrap {
  ngDoBootstrap(app) {

    keycloakService
      .init({ config: environment.keycloak })
      .then(() => {
        console.log('[ngDoBootstrap] bootstrap app');

        app.bootstrap(AppComponent);
      })
      .catch(error => console.error('[ngDoBootstrap] init Keycloak failed', error));
  }
}
