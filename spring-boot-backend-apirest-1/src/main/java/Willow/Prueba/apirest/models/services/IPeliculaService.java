package Willow.Prueba.apirest.models.services;

import java.util.List;

import Willow.Prueba.apirest.models.entity.Pelicula;

public interface IPeliculaService {

	public List<Pelicula> findAll();
	
	public Pelicula findById(long id);
	
	public Pelicula findByTitle(String title);
	
	public Pelicula save(Pelicula pelicula);
}
