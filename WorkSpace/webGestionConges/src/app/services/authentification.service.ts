import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employe } from '../model/employe';
import { Login } from '../model/login';

@Injectable({
  providedIn: 'root',
})
export class AuthentificationService {
  constructor(private http: HttpClient) {}

  public authentification(login: Login) {}

  public getAuthApi(login: Login): Observable<void> {
    const texte: string = `${login.email}:${login.password}`;
    const headers: HttpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      authorization: `Basic ${btoa(texte)}`,
    });
    return this.http.get<void>('http://localhost:3000/login', {
      headers: headers,
    });
  }
}
