import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employe } from '../model/employe';
import { Login } from '../model/login';
import { AuthentificationService } from '../services/authentification.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  login: Login = new Login();
  employe: Employe = new Employe();
  message: string;

  constructor(
    private authentificationService: AuthentificationService,
    private router: Router
  ) {}

  ngOnInit(): void {}

  send() {
    this.authentificationService.getAuthApi(this.login).subscribe(
      (res) => {
        this.message = null;
        localStorage.setItem(
          'auth',
          btoa(this.login.email + ':' + this.login.password)
        );

        localStorage.setItem('login', this.login.email);

        this.router.navigate(['/home']);
      },
      (error) => {
        this.message = "erreur d'authentification";
      }
    );
  }
}
