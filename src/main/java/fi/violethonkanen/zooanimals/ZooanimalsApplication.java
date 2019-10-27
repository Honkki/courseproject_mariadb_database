package fi.violethonkanen.zooanimals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.violethonkanen.zooanimals.domain.Animal;
import fi.violethonkanen.zooanimals.domain.AnimalRepository;
import fi.violethonkanen.zooanimals.domain.Sex;
import fi.violethonkanen.zooanimals.domain.SexRepository;
import fi.violethonkanen.zooanimals.domain.User;
import fi.violethonkanen.zooanimals.domain.UserRepository;

@SpringBootApplication
public class ZooanimalsApplication {
	private static final Logger log = LoggerFactory.getLogger(ZooanimalsApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(ZooanimalsApplication.class, args);
	}
	
	/*tietoja h2-kantaan
	@Bean
	public CommandLineRunner animalDemo(AnimalRepository arepository, SexRepository srepository, UserRepository urepository) {
		return (args) -> {
			srepository.save(new Sex("Naaras"));
			srepository.save(new Sex("Uros"));
			srepository.save(new Sex("Tuntematon"));
			
			arepository.save(new Animal("Bob", "Ilves", 20.0, srepository.findByGender("Uros").get(0)));
			arepository.save(new Animal("Sam", "Karhu", 100.5, srepository.findByGender("Uros").get(0)));
			arepository.save(new Animal("Liz", "Lisko", 0.1, srepository.findByGender("Naaras").get(0)));
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			for (Animal animal : arepository.findAll()) {
				log.info(animal.toString());
			}
		};
	} */
}
