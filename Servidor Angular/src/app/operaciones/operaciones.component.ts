import { Component, OnInit } from '@angular/core';
import { Nave } from './nave';
import { OperacionesService } from './operaciones.service';
import { Pelicula } from './pelicula';
import { Persona } from './persona';
import { map} from 'rxjs/operators'
import { Cons1 } from './Cons1';

@Component({
  selector: 'app-operaciones',
  templateUrl: './operaciones.component.html'
})
export class OperacionesComponent implements OnInit {

  peliculas:Pelicula[]=[];
  personas:Persona[]=[];
  naves:Nave[]=[];
  consulta:Cons1[]=[];

  constructor(private opServ:OperacionesService) { }

  ngOnInit(): void {
  }
  verPeliculas(): void {
    this.personas=[];
    this.naves=[];
    this.consulta=[];
    this.opServ.getPeliculas().subscribe((response:Pelicula[]) =>{
        this.peliculas=response});
  }
  verPersonas(): void{
    this.peliculas=[];
    this.naves=[];
    this.consulta=[];
    this.opServ.getPersonas().subscribe((response: Persona[]) =>this.personas=response);
  }
  verNaves():void{
    this.personas=[];
    this.peliculas=[];
    this.consulta=[];
    this.opServ.getNaves().subscribe((response: Nave[]) =>this.naves=response);
  }
  verConsulta():void{
    this.personas=[];
    this.peliculas=[];
    this.naves=[];
    this.opServ.getConsulta1().subscribe((response: Cons1[]) =>this.consulta=response);
  }
}
