import { Conges } from './../model/conges';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class DemandecongeService {
  private static URL = 'http://127.0.0.1:9001/projet/api/conge';
  private httpHeaders: HttpHeaders;

  constructor(private http: HttpClient) {
    this.initHeader();
  }

  private initHeader() {
    this.httpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: `Basic ${localStorage.getItem('auth')}`,
    });
  }

  public getDemandeConge(id: number): Observable<Conges> {
    this.initHeader();
    return this.http.get<Conges>(DemandecongeService.URL + '/' + id, {
      headers: this.httpHeaders,
    });
  }

  public getConges(): Observable<Conges[]> {
    this.initHeader();
    return this.http.get<Conges[]>(DemandecongeService.URL, {
      headers: this.httpHeaders,
    });
  }

  public update(conges: Conges): Observable<Conges> {
    this.initHeader();
    return this.http.put<Conges>(
      DemandecongeService.URL + '/' + conges.id,
      conges,
      {
        headers: this.httpHeaders,
      }
    );
  }

  public insert(conges: Conges): Observable<Conges> {
    this.initHeader();
    const congesFormate = {
      dateDemande: conges.dateDemande,
      dateDebut: conges.dateDebut,
      dateFin: conges.dateFin,
      motif: conges.motif,
    };
    return this.http.post<Conges>(DemandecongeService.URL, congesFormate, {
      headers: this.httpHeaders,
    });
  }

  public delete(id: number): Observable<void> {
    this.initHeader();
    return this.http.delete<void>(`${DemandecongeService.URL}/${id}`, {
      headers: this.httpHeaders,
    });
  }
}
