package Willow.Prueba.apirest.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="starships")
public class Nave implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	private String name;
	
	private String model;

	private String manufacturer;
	
	private String cost_in_credits;
	
	private String length;
	
	private String max_atmosphering_speed;
	
	private String crew;

	private String passengers;
	
	private String cargo_capacity;
	
	private String consumables;
	
	private String hyperdrive_rating;
	
	private String MGLT;
	
	private String starship_class;
	
	@JsonIgnoreProperties(value={"films","starships","hibernateLazyInitializer","handler"},allowSetters=true)
	@ManyToMany(mappedBy="starships")
	private List<Persona> pilots;
	
	@JsonIgnoreProperties(value={"starships","characters","hibernateLazyInitializer","handler"},allowSetters=true)
	@ManyToMany(mappedBy="starships")
	private List<Pelicula> films;
	
	private String created;
	
	private String edited;
	
	private String url;
	
	public Nave(){
		this.pilots=new ArrayList<Persona>();
		this.films=new ArrayList<Pelicula>();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCost_in_credits() {
		return cost_in_credits;
	}

	public void setCost_in_credits(String cost_in_credits) {
		this.cost_in_credits = cost_in_credits;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getMax_atmosphering_speed() {
		return max_atmosphering_speed;
	}

	public void setMax_atmosphering_speed(String max_atmosphering_speed) {
		this.max_atmosphering_speed = max_atmosphering_speed;
	}

	public String getCrew() {
		return crew;
	}

	public void setCrew(String crew) {
		this.crew = crew;
	}

	public String getPassengers() {
		return passengers;
	}

	public void setPassengers(String passengers) {
		this.passengers = passengers;
	}

	public String getCargo_capacity() {
		return cargo_capacity;
	}

	public void setCargo_capacity(String string) {
		this.cargo_capacity = string;
	}

	public String getConsumables() {
		return consumables;
	}

	public void setConsumables(String consumables) {
		this.consumables = consumables;
	}

	public String getHyperdrive_rating() {
		return hyperdrive_rating;
	}

	public void setHyperdrive_rating(String hyperdrive_rating) {
		this.hyperdrive_rating = hyperdrive_rating;
	}

	public String getMGLT() {
		return MGLT;
	}

	public void setMGLT(String string) {
		MGLT = string;
	}

	public String getStarship_class() {
		return starship_class;
	}

	public void setStarship_class(String starship_class) {
		this.starship_class = starship_class;
	}

	public List<Persona> getPilots() {
		return pilots;
	}

	public void setPilots(List<Persona> pilots) {
		this.pilots = pilots;
	}

	public List<Pelicula> getFilms() {
		return films;
	}

	public void setFilms(List<Pelicula> films) {
		this.films = films;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getEdited() {
		return edited;
	}

	public void setEdited(String edited) {
		this.edited = edited;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
/**
 * 	"name": "Star Destroyer",
	"model": "Imperial I-class Star Destroyer",
	"manufacturer": "Kuat Drive Yards",
	"cost_in_credits": "150000000",
	"length": "1,600",
	"max_atmosphering_speed": "975",
	"crew": "47,060",
	"passengers": "n/a",
	"cargo_capacity": "36000000",
	"consumables": "2 years",
	"hyperdrive_rating": "2.0",
	"MGLT": "60",
	"starship_class": "Star Destroyer",
	"pilots": [],
	"films": [
		"http://swapi.dev/api/films/1/",
		"http://swapi.dev/api/films/2/",
		"http://swapi.dev/api/films/3/"
	],
	"created": "2014-12-10T15:08:19.848000Z",
	"edited": "2014-12-20T21:23:49.870000Z",
	"url": "http://swapi.dev/api/starships/3/"
 */
