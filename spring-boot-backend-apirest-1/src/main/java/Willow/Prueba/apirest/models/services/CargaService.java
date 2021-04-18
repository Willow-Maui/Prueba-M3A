package Willow.Prueba.apirest.models.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import Willow.Prueba.apirest.models.entity.Nave;
import Willow.Prueba.apirest.models.entity.Pelicula;
import Willow.Prueba.apirest.models.entity.Persona;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Service
public class CargaService implements ICargaService {

	private final String baseURL = "https://swapi.dev/api/";
	
	@Autowired
	private IPersonaService personaService;
	
	@Autowired
	private IPeliculaService peliculaService;
	
	@Autowired
	private INaveService naveService;
	
	@Transactional
	public void cargarValores() {
		JsonObject response, responsePage;
		JsonArray responseObjects;
		Map<Long, String[]> pers_peli,pers_nave, peli_nave;
		String next;
		int id=0;
		boolean parar;
		pers_peli=new HashMap<Long, String[]>();
		pers_nave=new HashMap<Long, String[]>();
		peli_nave=new HashMap<Long, String[]>();
		
		responsePage = get(baseURL + "people" + "/");
		parar=false;
		Persona pers;
		while(!parar) {
			parar=responsePage.get("next").isJsonNull();
			responseObjects=responsePage.get("results").getAsJsonArray();
			for(int i=0;i<responseObjects.size();i++) {
				response=responseObjects.get(i).getAsJsonObject();
				pers = new Persona();
				id++;
				pers.setId(Long.valueOf(id));
				pers.setName(response.get("name").getAsString());
				pers.setHeight(response.get("height").getAsString());
				pers.setMass(response.get("mass").getAsString());
				pers.setHair_color(response.get("hair_color").getAsString());
				pers.setSkin_color(response.get("skin_color").getAsString());
				pers.setEye_color(response.get("eye_color").getAsString());
				pers.setBirth_year(response.get("birth_year").getAsString());
				pers.setGender(response.get("gender").getAsString());
				pers.setHomeworld(response.get("homeworld").getAsString());
				//pers.setFilms((List<Pelicula>) response.get("films"));
				pers_peli.put(Long.valueOf(id),toStrArray(response.getAsJsonArray("films")));
				pers.setSpecies(toStrArray(response.getAsJsonArray("species")));
				pers.setSpecies(toStrArray(response.getAsJsonArray("vehicles")));
				//pers.setStarships((List<Nave>) response.get("starships"));
				pers_nave.put(Long.valueOf(id),toStrArray(response.getAsJsonArray("starships")));
				pers.setCreated(response.get("created").getAsString());
				pers.setEdited(response.get("edited").getAsString());
				pers.setUrl(response.get("url").getAsString());
				personaService.save(pers);
			}
			if(!parar) {
				next = arreglarLinks(responsePage.get("next").getAsString());
				responsePage=get(next);
			}
		}
		
		/*
		response = get(baseURL + "people" + "/");
		int personas =response.get("count").getAsInt();
		Persona pers;
		for (Long i = (long) 1; i <personas+1; i++) {
			response = get(baseURL + "people"+"/" + i + "/");
			pers = new Persona();
			pers.setId(i);
			pers.setName(response.get("name").getAsString());
			pers.setHeight(response.get("height").getAsInt());
			pers.setMass(response.get("mass").getAsInt());
			pers.setHair_color(response.get("hair_color").getAsString());
			pers.setSkin_color(response.get("skin_color").getAsString());
			pers.setEye_color(response.get("eye_color").getAsString());
			pers.setBirth_year(response.get("birth_year").getAsString());
			pers.setGender(response.get("gender").getAsString());
			pers.setHomeworld(response.get("homeworld").getAsString());
			//pers.setFilms((List<Pelicula>) response.get("films"));
			pers_peli.put(i,toStrArray(response.getAsJsonArray("films")));
			pers.setSpecies(toStrArray(response.getAsJsonArray("species")));
			//pers.setStarships((List<Nave>) response.get("starships"));
			pers_nave.put(i,toStrArray(response.getAsJsonArray("starships")));
			pers.setCreated(response.get("created").getAsString());
			pers.setEdited(response.get("edited").getAsString());
			pers.setUrl(response.get("url").getAsString());
			personaService.save(pers);
		*/
		
		responsePage = get(baseURL + "films" + "/");
		parar=false;
		id=0;
		Pelicula peli;
		while(!parar) {
			parar=responsePage.get("next").isJsonNull();
			responseObjects=responsePage.get("results").getAsJsonArray();
			for(int i=0;i<responseObjects.size();i++) {
				response=responseObjects.get(i).getAsJsonObject();
				peli = new Pelicula();
				id++;
				peli.setId(Long.valueOf(id));
				peli.setTitle(response.get("title").getAsString());
				peli.setOpening_crawl(response.get("opening_crawl").getAsString());
				peli.setDirector(response.get("director").getAsString());
				peli.setProducer(response.get("producer").getAsString());
				peli.setRelease_date(response.get("release_date").getAsString());
				peli.setPlanets(toStrArray(response.getAsJsonArray("planets")));
				peli_nave.put(Long.valueOf(id),toStrArray(response.getAsJsonArray("starships")));
				peli.setVehicles(toStrArray(response.getAsJsonArray("vehicles")));
				peli.setSpecies(toStrArray(response.getAsJsonArray("species")));
				peli.setCreated(response.get("created").getAsString());
				peli.setEdited(response.get("edited").getAsString());
				peli.setUrl(response.get("url").getAsString());
				peliculaService.save(peli);
			}

			if(!parar) {
				next = arreglarLinks(responsePage.get("next").getAsString());
				responsePage=get(next);
			}
		}
		
		/*
		response = get(baseURL + "films" + "/");
		int pelis =response.get("count").getAsInt();
		Pelicula peli;
		for (Long i = (long) 1; i <2/*pelis+1*//*; i++) {
			response = get(baseURL + "films"+"/" + i + "/");
			peli = new Pelicula();
			peli.setId(i);
			peli.setTitle(response.get("title").getAsString());
			peli.setOpening_crawl(response.get("opening_crawl").getAsString());
			peli.setDirector(response.get("director").getAsString());
			peli.setProducer(response.get("producer").getAsString());
			peli.setRelease_date(response.get("release_date").getAsString());
			peli.setPlanets(toStrArray(response.getAsJsonArray("planets")));
			peli.setVehicles(toStrArray(response.getAsJsonArray("vehicles")));
			peli.setSpecies(toStrArray(response.getAsJsonArray("species")));
			peli.setCreated(response.get("created").getAsString());
			peli.setEdited(response.get("edited").getAsString());
			peli.setUrl(response.get("url").getAsString());
			peliculaService.save(peli);
		}*/
		
		responsePage = get(baseURL + "starships" + "/");
		parar=false;
		id=0;
		Nave nave;
		while(!parar) {
			parar=responsePage.get("next").isJsonNull();
			responseObjects=responsePage.get("results").getAsJsonArray();
			for(int i=0;i<responseObjects.size();i++) {
				response=responseObjects.get(i).getAsJsonObject();
				nave = new Nave();
				id++;
				nave.setId(Long.valueOf(id));
				nave.setName(response.get("name").getAsString());
				nave.setModel(response.get("model").getAsString());
				nave.setManufacturer(response.get("manufacturer").getAsString());
				nave.setCost_in_credits(response.get("cost_in_credits").getAsString());
				nave.setLength(response.get("length").getAsString());
				nave.setMax_atmosphering_speed(response.get("max_atmosphering_speed").getAsString());
				nave.setCrew(response.get("crew").getAsString());
				nave.setPassengers(response.get("passengers").getAsString());
				nave.setCargo_capacity(response.get("cargo_capacity").getAsString());
				nave.setConsumables(response.get("consumables").getAsString());
				nave.setHyperdrive_rating(response.get("hyperdrive_rating").getAsString());
				nave.setMGLT(response.get("MGLT").getAsString());
				nave.setStarship_class(response.get("starship_class").getAsString());
				nave.setCreated(response.get("created").getAsString());
				nave.setEdited(response.get("edited").getAsString());
				nave.setUrl(response.get("url").getAsString());
				naveService.save(nave);
			}
			if(!parar) {
				next = arreglarLinks(responsePage.get("next").getAsString());
				responsePage=get(next);
			}
		}
		/*
		for (Long i = (long) 2; i <naves+1; i++) {
			System.out.println(i);
			response = get(baseURL + "starships"+"/" + i + "/");
			nave = new Nave();
			nave.setId(i);
			nave.setName(response.get("name").getAsString());
			nave.setModel(response.get("model").getAsString());
			nave.setManufacturer(response.get("manufacturer").getAsString());
			nave.setCost_in_credits(response.get("cost_in_credits").getAsLong());
			nave.setLength(response.get("length").getAsFloat());
			nave.setMax_atmosphering_speed(response.get("max_atmosphering_speed").getAsLong());
			nave.setCrew(response.get("crew").getAsString());
			nave.setPassengers(response.get("passengers").getAsString());
			nave.setCargo_capacity(response.get("cargo_capacity").getAsLong());
			nave.setConsumables(response.get("consumables").getAsString());
			nave.setHyperdrive_rating(response.get("hyperdrive_rating").getAsString());
			nave.setMGLT(response.get("MGLT").getAsLong());
			nave.setStarship_class(response.get("starship_class").getAsString());
			nave.setCreated(response.get("created").getAsString());
			nave.setEdited(response.get("edited").getAsString());
			nave.setUrl(response.get("url").getAsString());
			naveService.save(nave);
		}*/
		Set<Long> llaves=pers_peli.keySet();
		Iterator<Long> it=llaves.iterator();
		Long actualId;
		String[] peliculasSinLink;
		ArrayList<Pelicula> peliculas;
		while(it.hasNext()) {
			actualId=it.next();
			pers=personaService.findById(actualId);
			peliculas= new ArrayList<Pelicula>();
			peliculasSinLink=pers_peli.get(actualId);
			for(int i=0;i<peliculasSinLink.length;i++) {
				peli=peliculaService.findByTitle(get(arreglarLinks(peliculasSinLink[i])).get("title").getAsString());
				peliculas.add(peli);
			}
			pers.setFilms(peliculas);
			personaService.save(pers);
		}
		
		llaves=pers_nave.keySet();
		it=llaves.iterator();
		String[] navesSinLink;
		ArrayList<Nave> naves;
		while(it.hasNext()) {
			actualId=it.next();
			pers=personaService.findById(actualId);
			naves=new ArrayList<Nave>();
			navesSinLink=pers_nave.get(actualId);
			for(int i=0;i<navesSinLink.length;i++) {
				nave=naveService.findByName(get(arreglarLinks(navesSinLink[i])).get("name").getAsString());
				naves.add(nave);
			}
			pers.setStarships(naves);
			personaService.save(pers);
		}
		
		llaves=peli_nave.keySet();
		it=llaves.iterator();
		while(it.hasNext()) {
			actualId=it.next();
			peli=peliculaService.findById(actualId);
			naves=new ArrayList<Nave>();
			navesSinLink=peli_nave.get(actualId);
			for(int i=0;i<navesSinLink.length;i++) {
				nave=naveService.findByName(get(arreglarLinks(navesSinLink[i])).get("name").getAsString());
				naves.add(nave);
			}
			peli.setStarships(naves);
			peliculaService.save(peli);
		}
		
	}

	private JsonObject get(String path) {
		RestTemplate restTemplate = new RestTemplate();
		Gson gson = new Gson();
        JsonObject response = gson.fromJson(restTemplate.getForObject(path, String.class), JsonObject.class);
		return response;
	}
	
	private String[] toStrArray(JsonArray tmp) {
		String[] devolver;
		devolver=new String[tmp.size()];
		for(int i=0;i<tmp.size();i++) {
			devolver[i]=tmp.get(i).getAsString();
		}
		return devolver;
	}
	public static String arreglarLinks(String path){
	        String newString = new String();
	        for (int i = 0; i < path.length(); i++) {
	            newString += path.charAt(i);
	            if (i == 3) {
	                newString += 's';
	            }
	        }
	        return newString;
	    }
	  
}
