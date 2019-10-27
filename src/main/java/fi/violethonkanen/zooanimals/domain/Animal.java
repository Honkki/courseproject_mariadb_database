package fi.violethonkanen.zooanimals.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//annotaatio kertoo että tämä luokka on entity-luokka
@Entity
public class Animal {
	//annotaatiot kertovat, että tämä on uniikki id ja se tulee automaattisesti tietokannasta
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name, species;
	private double weight;
	
	@ManyToOne
	@JoinColumn(name = "sexid")
	private Sex sex;
	
	//constructor ilman attribuutteja
	public Animal() {}
	
	//constructor attribuuteilla
	public Animal(String name, String species, double weight, Sex sex) {
		super();
		this.name = name;
		this.species = species;
		this.weight = weight;
		this.sex = sex;
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
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}
	
	@Override
	public String toString() {
		if (this.sex != null)
			return "Animal [id=" + id + ", name=" + name + ", species=" + species + ", weight=" + weight + " sex =" + this.getSex() + "]";		
		else
			return "Animal [id=" + id + ", name=" + name + ", species=" + species + ", weight=" + weight + "]";
	}
}
