package PostgreSQL.Database.Demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import PostgreSQL.Database.Demo.Repo.PersonRepo;
import PostgreSQL.Database.Demo.model.Person;

@RestController
@RequestMapping("/persons")
public class PersonController {
	
	@Autowired
	PersonServices personServices;
	
	private final PersonRepo personRepo;
	
	public PersonController(PersonRepo personRepo) {
		this.personRepo = personRepo;
	}
	
	@GetMapping
	public List<Person> getPerson(){
		return personRepo.findAll();
	}
	record PersonRequest(String first_name, String last_name, String email,
							String gender,String date_of_birth, String country_of_birth) {
	}

	@PostMapping
	public void addPerson(@RequestBody PersonRequest newPersonRequest) {
		Person person = new Person();
		person.setFirst_name(newPersonRequest.first_name);
		person.setLast_name(newPersonRequest.last_name);
		person.setEmail(newPersonRequest.email);
		person.setGender(newPersonRequest.gender);
		person.setDate_of_birth(newPersonRequest.date_of_birth);
		person.setCountry_of_birth(newPersonRequest.country_of_birth);
		personRepo.save(person);
	}
	
	@DeleteMapping("{personId}")
	public void deletePerson(@PathVariable("personId") Long id) {
		personRepo.deleteById(id);
	}
	
	@RequestMapping("{personId}")
	public Person getPersonById(@PathVariable("personId") Long id){
		return personRepo.findById(id).get();
	}
	
	@PutMapping("update/{personId}")
	public void update(@PathVariable("personId") Long id, @RequestBody(required = false) PersonRequest updateRequest) {
		
		personServices.updatePerson(id, updateRequest.first_name, updateRequest.last_name, updateRequest.email,
									updateRequest.gender, updateRequest.date_of_birth, updateRequest.country_of_birth);
		
		
	}
	
//	https://www.youtube.com/watch?v=z8XgBCrTVY0&t=30s

}
