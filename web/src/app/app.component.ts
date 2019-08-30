import { Component, OnInit } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  userName = '';

  constructor(
    private keycloakService: KeycloakService) { }

  ngOnInit() {
    const userDetails = this.keycloakService.getKeycloakInstance().profile;
    this.userName = userDetails.lastName || '';
    if (userDetails.firstName) {
      this.userName = this.userName ? this.userName + ' ' + userDetails.firstName : '';
    } else {
      this.userName = userDetails.username;
    }
  }

  logout() {
    this.keycloakService.logout();
  }
}
