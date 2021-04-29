import { Service } from './../model/service';
import { Manager } from './../model/manager';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class InscriptionService {
  constructor(private http: HttpClient) {}

  public inscription(
    nom: string,
    prenom: string,
    manager: Manager,
    service: Service,
    login: string,
    password: string
  ): Observable<void> {
    return this.http.post<void>('http://127.0.0.1:9001/api/inscription/add', {
      login: login,
      password: password,
    });
  }

  public checkLogin(login: string): Observable<boolean> {
    return this.http.get<boolean>('' + login);
  }
  public checkNom(nom: string): Observable<boolean> {
    return this.http.get<boolean>('' + nom);
  }
  public checkPrenom(prenom: string): Observable<boolean> {
    return this.http.get<boolean>('' + prenom);
  }
  public checkManager(manager: number): Observable<boolean> {
    return this.http.get<boolean>('' + manager);
  }
  public checkService(service: string): Observable<boolean> {
    return this.http.get<boolean>('' + service);
  }
}
