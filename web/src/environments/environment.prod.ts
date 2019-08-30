
import { KeycloakConfig } from 'keycloak-angular';

const keycloakConfig: KeycloakConfig = {
  url: 'http://keycloak.aottech.com:8080/auth',
  realm: 'prime',
  clientId: 'client_prime',
};

export const environment = {
  production: true,
  keycloak: keycloakConfig,
  apiUrl: 'http://52.25.173.136:8080/'
};
