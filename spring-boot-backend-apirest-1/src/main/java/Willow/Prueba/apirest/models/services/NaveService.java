package Willow.Prueba.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Willow.Prueba.apirest.models.DAO.INaveDAO;
import Willow.Prueba.apirest.models.entity.Nave;

@Service
public class NaveService implements INaveService {

	@Autowired
	private INaveDAO naveDAO;

	@Transactional(readOnly=true)
	public List<Nave> findAll() {
		return (List<Nave>) naveDAO.findAll();
	}


	@Transactional(readOnly=true)
	public Nave findById(long id) {
		return naveDAO.findById(id).orElse(null);
	}


	@Transactional
	public Nave save(Nave nave) {
		return naveDAO.save(nave);
	}


	@Override
	@Transactional(readOnly=true)
	public Nave findByName(String name) {
		return naveDAO.findByName(name);
	}
	
	
}
