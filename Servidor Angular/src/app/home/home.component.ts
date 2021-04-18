import { Component, OnInit } from '@angular/core';
import { CargarService } from './cargar.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html'
})
export class HomeComponent implements OnInit {
// Cargar
  constructor(private serv:CargarService) { }

  ngOnInit(): void {
  }
  cargar():void{
    this.serv.cargar();
  }
}
