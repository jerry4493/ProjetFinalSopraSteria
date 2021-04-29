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

  public getAuthApi(login: Login): Observable<Employe> {
    const texte: string = `${login.email}:${login.password}`;
    const headers: HttpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      authorization: `Basic ${btoa(texte)}`,
    });
    return this.http.get<Employe>('http://localhost:9001/api/auth/login', {
      headers: headers,
    });
  }
}
