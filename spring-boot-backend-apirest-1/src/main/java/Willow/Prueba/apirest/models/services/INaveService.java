package Willow.Prueba.apirest.models.services;

import java.util.List;

import Willow.Prueba.apirest.models.entity.Nave;
import Willow.Prueba.apirest.models.entity.Pelicula;

public interface INaveService {
	
	public List<Nave> findAll();
	
	public Nave findById(long id);
	
	public Nave save(Nave nave);

	public Nave findByName(String name);
}
