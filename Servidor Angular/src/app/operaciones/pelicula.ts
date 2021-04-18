import { Nave } from './nave';
import { Persona } from './persona';

export class Pelicula {
  id!: number;

	title!:string;

	opening_crawl!:string;

	director!:string;

	producer!:string;

	release_date!:string;

	characters!:Persona[];

	planets!:string;

	starships!: Nave[];

	vehicles!:string;

	species!:string;

	created!:string;

	edited!:string;

	url!:string;

}
