package fi.violethonkanen.zooanimals.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//määritetään entity-class ja id:n tyyppi

public interface AnimalRepository extends CrudRepository<Animal, Long> {
	
	 List<Animal> findByName(String name);

}
