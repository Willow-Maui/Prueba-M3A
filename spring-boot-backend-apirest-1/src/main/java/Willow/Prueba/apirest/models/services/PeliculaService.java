package Willow.Prueba.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Willow.Prueba.apirest.models.DAO.IPeliculaDAO;
import Willow.Prueba.apirest.models.entity.Pelicula;

@Service
public class PeliculaService implements IPeliculaService {
	
	@Autowired
	private IPeliculaDAO peliculaDAO;

	@Transactional(readOnly=true)
	public List<Pelicula> findAll() {
		return (List<Pelicula>) peliculaDAO.findAll();
	}


	@Transactional(readOnly=true)
	public Pelicula findById(long id) {
		return peliculaDAO.findById(id).orElse(null);
	}

	@Transactional
	public Pelicula save(Pelicula pelicula) {
		return peliculaDAO.save(pelicula);
	}


	@Override
	@Transactional(readOnly=true)
	public Pelicula findByTitle(String title) {
		return peliculaDAO.findByTitle(title);
	}

}
