package Willow.Prueba.apirest.models.DAO;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import Willow.Prueba.apirest.models.entity.Persona;

public interface IPersonaDAO extends CrudRepository<Persona, Long>{

	@Query("select p from Persona p where p.name =?1")
	public Persona findByName(String name);
}