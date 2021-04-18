import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpRequest } from '@angular/common/http'
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class CargarService {
  private urlEndPoint: string = 'http://localhost:8280/api';

  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(private http: HttpClient, private router: Router) { }

  cargar():void{
    this.http.get<any>(`${this.urlEndPoint}/cargar`, { headers: this.httpHeaders });
    this.router.navigate(['/operaciones']);
  }
}
