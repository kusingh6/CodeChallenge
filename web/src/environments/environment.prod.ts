
import { KeycloakConfig } from 'keycloak-angular';

const keycloakConfig: KeycloakConfig = {
  url: 'http://localhost:5000/auth',
  realm: 'prime',
  clientId: 'client_prime',
};

export const environment = {
  production: true,
  keycloak: keycloakConfig,
};
