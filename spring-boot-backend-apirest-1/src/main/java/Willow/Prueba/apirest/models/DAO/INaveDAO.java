package Willow.Prueba.apirest.models.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Willow.Prueba.apirest.models.entity.Nave;

public interface INaveDAO extends JpaRepository<Nave, Long>{

	@Query("select s from Nave s where s.name =?1")
	public Nave findByName(String name);
}
