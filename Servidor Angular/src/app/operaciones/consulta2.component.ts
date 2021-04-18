import { Component, OnInit } from '@angular/core';
import { map } from 'rxjs/operators';
import { OperacionesService } from './operaciones.service';
import { Pelicula } from './pelicula';
import { Persona } from './persona';

@Component({
  selector: 'app-consulta2',
  templateUrl: './consulta2.component.html'
})
export class Consulta2Component implements OnInit {
  personas:Persona[]=[];
  peliculas:Pelicula[]=[];
  seleccionadas!: Map<number, boolean>;

  constructor(private opServ:OperacionesService) {
    this.opServ.getPeliculas().subscribe((response: Pelicula[]) =>this.peliculas=response);
    this.seleccionadas= new Map<number,boolean>();
    for (var peli of this.peliculas){
      this.seleccionadas.set(peli.id,false);
    }
  }

  ngOnInit(): void {
  }

  realizarConsulta(): void{
    let numeros:number[]=[];
    for (var pelicula of this.seleccionadas.keys()){
      if(this.seleccionadas.get(pelicula)){
        numeros.push(pelicula);
      }
    }
    this.opServ.getConsulta2(numeros).subscribe(response=>this.personas=response);
  }

  switchOpt(id:number){
    this.seleccionadas.set(id,!this.seleccionadas.get(id));
  }
}
