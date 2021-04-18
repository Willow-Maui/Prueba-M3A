package Willow.Prueba.apirest.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.Gson;

@Entity
@Table(name="people")
public class Persona implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	
	private String name;
	
	private String height;
	
	private String mass;
	
	private String hair_color;
	
	private String skin_color;
	
	private String eye_color;
	
	private String birth_year;
	
	private String gender;
	
	private String homeworld;
	
	@JsonIgnoreProperties(value={"characters","starships","hibernateLazyInitializer","handler"},allowSetters=true)
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(
			name="people_film", joinColumns=@JoinColumn(name="people_id"),
			inverseJoinColumns=@JoinColumn(name="film_id"),
			uniqueConstraints={@UniqueConstraint(columnNames={"people_id","film_id"})})
	private List<Pelicula> films;
	
	private String species;
	
	private String vehicles;

	@JsonIgnoreProperties(value={"pilots","films","hibernateLazyInitializer","handler"},allowSetters=true)
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(
			name="people_starships", joinColumns=@JoinColumn(name="people_id"),
			inverseJoinColumns=@JoinColumn(name="starships_id"),
			uniqueConstraints={@UniqueConstraint(columnNames={"people_id","starships_id"})})
	private List<Nave> starships;
	
	private String created;
	
	private String edited;
	
	private String url;

	public Persona(){
		this.starships=new ArrayList<Nave>();
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

	public String getHeight() {
		return height;
	}

	public void setHeight(String i) {
		this.height = i;
	}

	public String getMass() {
		return mass;
	}

	public void setMass(String mass) {
		this.mass = mass;
	}

	public String getHair_color() {
		return hair_color;
	}

	public void setHair_color(String hair_color) {
		this.hair_color = hair_color;
	}

	public String getSkin_color() {
		return skin_color;
	}

	public void setSkin_color(String skin_color) {
		this.skin_color = skin_color;
	}

	public String getEye_color() {
		return eye_color;
	}

	public void setEye_color(String eye_color) {
		this.eye_color = eye_color;
	}

	public String getBirth_year() {
		return birth_year;
	}

	public void setBirth_year(String birth_year) {
		this.birth_year = birth_year;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHomeworld() {
		return homeworld;
	}

	public void setHomeworld(String homeworld) {
		this.homeworld = homeworld;
	}

	public List<Pelicula> getFilms() {
		return films;
	}

	public void setFilms(List<Pelicula> films) {
		this.films = films;
	}

	public List<String> getSpecies() {
		return deserializar(species);
	}

	public void setSpecies(String[] species) {
		this.species = serializar(species);
	}

	public List<String> getVehicles() {
		return deserializar(vehicles);
	}

	public void setVehicles(String[] vehicles) {
		this.vehicles = serializar(vehicles);
	}

	public List<Nave> getStarships() {
		return starships;
	}

	public void setStarships(List<Nave> starships) {
		this.starships = starships;
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

	private String serializar(String[] arr) {
		 Gson gson = new Gson();
		 return gson.toJson(arr);
	}
	
	private List<String> deserializar(String inputString) {
		Gson gson = new Gson();
		return (gson.fromJson(inputString, ArrayList.class));
	}
}
/*
 * "name": "Luke Skywalker",
	"height": "172",
	"mass": "77",
	"hair_color": "blond",
	"skin_color": "fair",
	"eye_color": "blue",
	"birth_year": "19BBY",
	"gender": "male",
	"homeworld": "http://swapi.dev/api/planets/1/",
	"films": [
		"http://swapi.dev/api/films/1/",
		"http://swapi.dev/api/films/2/",
		"http://swapi.dev/api/films/3/",
		"http://swapi.dev/api/films/6/"
	],
	"species": [],
	"vehicles": [
		"http://swapi.dev/api/vehicles/14/",
		"http://swapi.dev/api/vehicles/30/"
	],
	"starships": [
		"http://swapi.dev/api/starships/12/",
		"http://swapi.dev/api/starships/22/"
	],
	"created": "2014-12-09T13:50:51.644000Z",
	"edited": "2014-12-20T21:17:56.891000Z",
	"url": "http://swapi.dev/api/people/1/"
 * */