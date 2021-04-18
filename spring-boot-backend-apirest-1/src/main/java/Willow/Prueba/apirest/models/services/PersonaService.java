package Willow.Prueba.apirest.models.services;

import java.util.List;

/*
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Willow.Prueba.apirest.models.DAO.IPersonaDAO;
import Willow.Prueba.apirest.models.entity.Persona;

@Service
public class PersonaService implements IPersonaService {
	
	@Autowired
	private IPersonaDAO personaDAO;
	
	/* @Autowired
	private EntityManager em; */
	
	@Transactional(readOnly=true)
	public List<Persona> findAll() {
		return (List<Persona>) personaDAO.findAll();
	}

	@Transactional(readOnly=true)
	public Persona findById(long id) {
		return personaDAO.findById(id).orElse(null);
	}

	@Transactional
	public Persona save(Persona persona) {
		return personaDAO.save(persona);
	}

	/*
	Buscar quien es la persona que conduce la nave que mas veces aparece en esas películas.
	
	"With (select count(p.id), p.id "
				+ " from Pelicula f left join f.starships s left join s.pilots p "
				+ " group by p.id "
				+ " where f.id in (?) ) as countSubquery "
				+ "Select p "
				+ "from Persona p "
				+ "where p.id=(select p.id "
							+ "from countSubquery "
								+ "where conteo=(select MAX(conteo) "
												+ "from countSubquery)) "*//*
												
	public List<Persona> consulta2(List<Long> peliculas){
		String pelis="";
		boolean saltarPrimero=true;
		for(Long i:peliculas) {
			if(saltarPrimero) {
				saltarPrimero=false;
			}else {
				pelis+=", ";
			}
			pelis+=i.toString();
		}
		System.out.println(pelis);
		TypedQuery<Persona> query = em.createQuery(
				 "Select pers "
				+ "from Persona pers "
				+ "where pers.id=( select pe.id "
							+ "from (select count(pe.id) conteo, pe.id "
							+ "from Pelicula fi left join fi.starships st left join st.pilots pe "
							+ "group by pe.id "
							+ "where fi.id in (?1) ) "
							+ "where conteo=(select MAX(conteo) "
												+ "from (select count(p.id) conteo, p.id "
												+ "from Pelicula f left join f.starships s left join s.pilots p "
												+ "group by p.id "
												+ "where f.id in (?2) ))) "
		, Persona.class);
		query.setParameter(1,pelis);
		query.setParameter(2,pelis);
		return query.getResultList();
	} */
}
