package Willow.Prueba.apirest.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.Gson;

@Entity
@Table(name="films")
public class Pelicula implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	
	private String title;
	
	@Lob
	private String opening_crawl;
	
	private String director;
	
	private String producer;
	
	private String release_date;
	
	@JsonIgnoreProperties(value={"films","starships","hibernateLazyInitializer","handler"},allowSetters=true)
	@ManyToMany(mappedBy="films")
	private List<Persona> characters;
	
	@Column(columnDefinition = "text")
	private String planets;

	@JsonIgnoreProperties(value={"films","pilots","hibernateLazyInitializer","handler"},allowSetters=true)
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(
			name="film_starships", joinColumns=@JoinColumn(name="film_id"),
			inverseJoinColumns=@JoinColumn(name="starships_id"),
			uniqueConstraints={@UniqueConstraint(columnNames={"film_id","starships_id"})})
	private List<Nave> starships;
	
	@Column(columnDefinition = "text")
	private String vehicles;
	
	@Column(columnDefinition = "text")
	private String species;
	
	private String created;
	
	private String edited;
	
	private String url;

	public Pelicula(){
		this.characters=new ArrayList<Persona>();
		this.starships=new ArrayList<Nave>();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOpening_crawl() {
		return opening_crawl;
	}

	public void setOpening_crawl(String opening_crawl) {
		this.opening_crawl = opening_crawl;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	public List<Persona> getCharacters() {
		return characters;
	}

	public void setCharacters(List<Persona> characters) {
		this.characters = characters;
	}

	public List<String> getPlanets() {
		return deserializar(planets);
	}

	public void setPlanets(String[] planets) {
		this.planets = serializar(planets);
	}

	public List<Nave> getStarships() {
		return starships;
	}

	public void setStarships(List<Nave> starships) {
		this.starships = starships;
	}

	public List<String> getVehicles() {
		return deserializar(vehicles);
	}

	public void setVehicles(String[] vehicles) {
		this.vehicles = serializar(vehicles);
	}

	public List<String> getSpecies() {
		return deserializar(species);
	}

	public void setSpecies(String[] species) {
		this.species = serializar(species);
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
/*s
 * "title": "The Empire Strikes Back",
	"episode_id": 5,
	"opening_crawl": "It is a dark time for the\r\nRebellion. Although the Death\r\nStar has been destroyed,\r\nImperial troops have driven the\r\nRebel forces from their hidden\r\nbase and pursued them across\r\nthe galaxy.\r\n\r\nEvading the dreaded Imperial\r\nStarfleet, a group of freedom\r\nfighters led by Luke Skywalker\r\nhas established a new secret\r\nbase on the remote ice world\r\nof Hoth.\r\n\r\nThe evil lord Darth Vader,\r\nobsessed with finding young\r\nSkywalker, has dispatched\r\nthousands of remote probes into\r\nthe far reaches of space....",
	"director": "Irvin Kershner",
	"producer": "Gary Kurtz, Rick McCallum",
	"release_date": "1980-05-17",
	"characters": [
		"http://swapi.dev/api/people/1/"
	],
	"planets": [
		"http://swapi.dev/api/planets/4/"
	],
	"starships": [
		"http://swapi.dev/api/starships/3/"
	],
	"vehicles": [
		"http://swapi.dev/api/vehicles/8/"
	],
	"species": [
		"http://swapi.dev/api/species/1/"
	],
	"created": "2014-12-12T11:26:24.656000Z",
	"edited": "2014-12-15T13:07:53.386000Z",
	"url": "http://swapi.dev/api/films/2/"
 */