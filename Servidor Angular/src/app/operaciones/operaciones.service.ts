import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Cons1 } from './Cons1';
import { Nave } from './nave';
import { Pelicula } from './pelicula';
import { Persona } from './persona';

@Injectable({
  providedIn: 'root'
})
export class OperacionesService {
  private urlEndPoint: string = 'http://localhost:8280/api';

  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient, private router: Router) { }

  getPeliculas(): Observable<Pelicula[]> {
    return this.http.get<Pelicula[]>(`${this.urlEndPoint}/peliculas/`);
  }
  getPersonas(): Observable<Persona[]> {
    return this.http.get<Persona[]>(`${this.urlEndPoint}/personas`);
  }
  getNaves(): Observable<Nave[]> {
    return this.http.get<Nave[]>(`${this.urlEndPoint}/naves`);
  }
  getConsulta1(): Observable<Cons1[]> {
    return this.http.get<Cons1[]>(`${this.urlEndPoint}/listadoPersPel`);
  }
  getConsulta2(lista:number[]):Observable<Persona[]> {
    return this.http.post<Persona[]>(`${this.urlEndPoint}/mas_aparece`,lista, { headers: this.httpHeaders });
  }
}
