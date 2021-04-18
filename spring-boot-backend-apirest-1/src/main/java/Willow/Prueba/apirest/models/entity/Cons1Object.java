package Willow.Prueba.apirest.models.entity;

import java.util.List;

public class Cons1Object {

	private Persona persona;
	
	private int NumeroPeliculas;

	private List<String> peliculas;
	
	public Cons1Object(){}
	
	public Cons1Object(Persona pers,int numero, List<String> peliculas) {
		this.persona=pers;
		this.NumeroPeliculas=numero;
		this.peliculas=peliculas;
	}
	
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<String> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(List<String> peliculas) {
		this.peliculas = peliculas;
	}

	public int getNumeroPeliculas() {
		return NumeroPeliculas;
	}

	public void setNumeroPeliculas(int numeroPeliculas) {
		this.NumeroPeliculas = numeroPeliculas;
	}
	
	
}
