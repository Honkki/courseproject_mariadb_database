package fi.violethonkanen.zooanimals.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.violethonkanen.zooanimals.domain.Animal;
import fi.violethonkanen.zooanimals.domain.AnimalRepository;
import fi.violethonkanen.zooanimals.domain.SexRepository;


//Annotaatio kertoo että kyseessä on controller-luokka
@Controller
public class AnimalController {
	
	//autowired vie repositoryn controller-luokkaan
	@Autowired
	private AnimalRepository repository;
	
	@Autowired
	private SexRepository srepository; 
	
	
	//login-sivu
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	//request-mapping kertoo mikä endpoint palauttaa return arvon
	@RequestMapping("/zoolist")
	public String animalList(Model model) {
		//nimi, arvo
		model.addAttribute("animals", repository.findAll());
		//templaten nimi, joka palautetaan:
		return "zoolist";	
	}
	
	//preauthorize estää tekemästä komentoja ilman oikeaa roolia, html vain estää näkemästä poistosivua jne.
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	//kerrotaan mikä on pathvariable ylläolevalle requestmappingille
	public String deleteAnimal(@PathVariable("id") Long animalId, Model model) {
		repository.deleteById(animalId);
		return "redirect:../zoolist";
	}
	
	@RequestMapping("/deletepage")
	public String deletepage(Model model) {
		model.addAttribute("animals", repository.findAll());
	    return "deleteanimal";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/add")
	public String addAnimal(Model model) {
		model.addAttribute("animal", new Animal());
		model.addAttribute("genders", srepository.findAll());
		return "addanimal";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Animal animal) {
		repository.save(animal);
		return "redirect:zoolist";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping(value = "/edit/{id}")
    public String updateAnimal(@PathVariable("id") Long id, Model model) {
    	Animal animal = repository.findById(id).get();
    	System.out.println("update animal " + animal.toString());
    	model.addAttribute("animal", animal);
    	model.addAttribute("genders", srepository.findAll());
    	return "editanimal";
}
}
