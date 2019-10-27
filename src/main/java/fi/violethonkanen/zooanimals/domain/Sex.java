package fi.violethonkanen.zooanimals.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Sex {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long sexid;
	private String gender;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "sex")
	private List<Animal> animals;
	
	public Sex() {}

	public Sex(String gender) {
		super();
		this.gender = gender;
	}

	public Long getSexid() {
		return sexid;
	}

	public void setSexid(Long sexid) {
		this.sexid = sexid;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	@Override
	public String toString() {
		return "Sex [sexid=" + sexid + ", gender=" + gender + "]";
	}
	
}
