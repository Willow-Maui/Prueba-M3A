package Willow.Prueba.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import Willow.Prueba.apirest.models.entity.Cons1Object;
import Willow.Prueba.apirest.models.entity.Nave;
import Willow.Prueba.apirest.models.entity.Pelicula;
import Willow.Prueba.apirest.models.entity.Persona;
import Willow.Prueba.apirest.models.services.ICargaService;
import Willow.Prueba.apirest.models.services.IConsultasService;
import Willow.Prueba.apirest.models.services.INaveService;
import Willow.Prueba.apirest.models.services.IPeliculaService;
import Willow.Prueba.apirest.models.services.IPersonaService;

@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/api")
public class PruebaRestControler {
	
	private boolean cargado=false;
	@Autowired
	private ICargaService cargaService;
	
	@Autowired
	private INaveService naveService;
	
	@Autowired
	private IPeliculaService peliculaService;
	
	@Autowired
	private IPersonaService personaService;
	
	@Autowired
	private IConsultasService consultasService;
	
	@GetMapping("/peliculas")

	@ResponseStatus(HttpStatus.OK)
	public List<Pelicula> peliculas() {
		precarga();
		return peliculaService.findAll();
	}
	
	@GetMapping("/naves")
	@ResponseStatus(HttpStatus.OK)
	public List<Nave> naves() {
		precarga();
		return naveService.findAll();
	}
	
	@GetMapping("/personas")

	@ResponseStatus(HttpStatus.OK)
	public List<Persona> personas() {
		precarga();
		return personaService.findAll();
	}
	
	@GetMapping("/cargar")
	@ResponseStatus(HttpStatus.OK)
	public void cargar() {
		cargaService.cargarValores();
		cargado=true;
	}
	
	@GetMapping("/listadoPersPel")
	@ResponseStatus(HttpStatus.OK)
	public List<Cons1Object> personas_peliculas() {
		precarga();
		return consultasService.consulta1();
	}
	
	@PostMapping("/mas_aparece")
	@ResponseStatus(HttpStatus.OK)
	public List<Persona> conductor_mas_aparece(@RequestBody List<Long> lista) {
		precarga();
		return consultasService.consulta2(lista);
	}
	
	private void precarga() {
		if(!cargado)
			cargar();
	}
}

