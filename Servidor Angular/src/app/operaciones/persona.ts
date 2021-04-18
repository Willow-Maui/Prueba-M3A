import { Nave } from './nave';
import { Pelicula } from './pelicula';

export class Persona {
  id!:number;
	
	name!:string;

	height!:string;

	mass!:string;

	hair_color!:string;

	skin_color!:string;

	eye_color!:string;

	birth_year!:string;

	gender!:string;

	homeworld!:string;

	films!:Pelicula[];

	species!:string;

	vehicles!:string;

	starships!: Nave[];

	created!:string;

	edited!:string;

  url!:string;
}
