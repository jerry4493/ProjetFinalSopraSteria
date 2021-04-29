import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Conges } from '../model/conges';

@Injectable({
  providedIn: 'root',
})
export class ValidecongeService {
  private static URL = 'http://127.0.0.1:8080/projet/api/validation';
  private httpHeaders: HttpHeaders;

  constructor(private http: HttpClient) {
    this.initHeader();
  }

  private initHeader() {
    this.httpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      //Authorization: `Basic ${localStorage.getItem('auth')}`,
    });
  }

  public list(): Observable<Conges[]> {
    this.initHeader();
    return this.http.get<Conges[]>(ValidecongeService.URL, {
      headers: this.httpHeaders,
    });
  }

  public get(id: number): Observable<Conges> {
    this.initHeader();
    return this.http.get<Conges>(`${ValidecongeService.URL}/${id}`, {
      headers: this.httpHeaders,
    });
  }

  public delete(id: number): Observable<void> {
    this.initHeader();
    return this.http.delete<void>(`${ValidecongeService.URL}/${id}`, {
      headers: this.httpHeaders,
    });
  }

  public update(conge: Conges): Observable<Conges> {
    this.initHeader();
    console.log(conge.id);
    return this.http.put<Conges>(
      `${ValidecongeService.URL}/${conge.id}`,
      conge,
      { headers: this.httpHeaders }
    );
  }

  public insert(conge: Conges): Observable<Conges> {
    this.initHeader();
    const f = {
      id: conge.id,
    };
    return this.http.post<Conges>(ValidecongeService.URL, f, {
      headers: this.httpHeaders,
    });
  }
}
