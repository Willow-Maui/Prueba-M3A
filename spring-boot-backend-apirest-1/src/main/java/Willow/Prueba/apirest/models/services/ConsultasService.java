package Willow.Prueba.apirest.models.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Willow.Prueba.apirest.models.entity.Cons1Object;
import Willow.Prueba.apirest.models.entity.Nave;
import Willow.Prueba.apirest.models.entity.Pelicula;
import Willow.Prueba.apirest.models.entity.Persona;

@Service
public class ConsultasService implements IConsultasService {

	@Autowired
	private IPersonaService personaService;
	
	@Autowired
	private IPeliculaService peliculaService;
	
	//Listar todas las personas con el número de películas en las que aparece y el listado de sus títulos
	@Transactional
	public List<Cons1Object> consulta1() {
		List<Persona> personas=personaService.findAll();
		List<Cons1Object> devolver= new ArrayList<Cons1Object>();
		Iterator<Persona> it=personas.iterator();
		List<String> titulos;
		Persona pers;
		while( it.hasNext()) {
			pers=it.next();
			titulos=new ArrayList<String>();
			for (Pelicula peli:pers.getFilms()) {
				titulos.add(peli.getTitle());
			}
			devolver.add(new Cons1Object(pers,pers.getFilms().size(),titulos));
		}
		return devolver;
	}
	
	//Se mostrara el listado de películas para permitir seleccionar un grupo de ellas, 
	//una vez seleccionadas, buscar quien es la persona que conduce la nave que mas veces aparece en esas películas.
	@Transactional
	public List<Persona> consulta2(List<Long> peliculas){
		List<Persona> devolver=new ArrayList<Persona>();
		Map<Persona, Integer> mapa=new HashMap<Persona, Integer>();
		int max=0;
		for(Long pid:peliculas) {
			for(Nave nave:peliculaService.findById(pid).getStarships()) {
				for(Persona pers:nave.getPilots()) {
					if(mapa.keySet().contains(pers)) {
						mapa.put(pers,mapa.get(pers)+1);
					}else {
						mapa.put(pers,1);
					}
					if(max<= mapa.get(pers)) {
						if(max< mapa.get(pers)) {
							devolver.clear();
							max=mapa.get(pers);
						}
						devolver.add(pers);
					}
				}
			}
		}
		return devolver;
	}

}
