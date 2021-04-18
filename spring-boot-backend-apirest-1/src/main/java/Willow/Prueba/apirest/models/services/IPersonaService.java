package Willow.Prueba.apirest.models.services;

import java.util.List;

import Willow.Prueba.apirest.models.entity.Persona;

public interface IPersonaService {

	public List<Persona> findAll();
	
	public Persona findById(long id);
	
	public Persona save(Persona nave);
	
	//public List<Persona> consulta2(List<Long> peliculas);
}
