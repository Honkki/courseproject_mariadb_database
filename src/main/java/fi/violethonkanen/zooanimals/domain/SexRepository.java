package fi.violethonkanen.zooanimals.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SexRepository extends CrudRepository<Sex, Long> {
	
	List<Sex> findByGender(String gender);

}
