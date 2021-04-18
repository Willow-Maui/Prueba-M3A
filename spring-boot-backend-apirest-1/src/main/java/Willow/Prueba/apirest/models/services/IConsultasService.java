package Willow.Prueba.apirest.models.services;

import java.util.List;

import Willow.Prueba.apirest.models.entity.Persona;
import Willow.Prueba.apirest.models.entity.Cons1Object;

public interface IConsultasService {

	public List<Cons1Object> consulta1();
	
	public List<Persona> consulta2(List<Long> peliculas);
}
