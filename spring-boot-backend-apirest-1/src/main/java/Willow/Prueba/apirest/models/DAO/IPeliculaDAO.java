package Willow.Prueba.apirest.models.DAO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import Willow.Prueba.apirest.models.entity.Pelicula;

public interface IPeliculaDAO extends CrudRepository<Pelicula, Long>{

	@Query("select f from Pelicula f where f.title =?1")
	public Pelicula findByTitle(String title);
}
