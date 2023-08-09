package PostgreSQL.Database.Demo.Controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PostgreSQL.Database.Demo.Repo.PersonRepo;
import PostgreSQL.Database.Demo.model.Person;
import jakarta.transaction.Transactional;

@Service
public class PersonServices {
	
	private final PersonRepo personRepo;
	
	@Autowired
	public PersonServices(PersonRepo personRepo) {
		this.personRepo = personRepo;
	}
	
	@Transactional
	public void updatePerson(Long id, String first_name, String last_name,String email, String gender, String date_of_birth, String country_of_birth) {
		
		try{
			Person person = new Person();
			
			person = personRepo.findById(id).get();
						
			if(first_name != null && first_name.length() > 0 && !Objects.equals(person.getFirst_name(), first_name)){
				person.setFirst_name(first_name);
				}
			if(last_name != null && last_name.length() > 0 && !Objects.equals(person.getLast_name(), last_name)){
				person.setLast_name(last_name);
				}
			if(email != null && email.length() > 0 && !Objects.equals(person.getEmail(), email)){
				person.setEmail(email);
				}
			if(gender != null && gender.length() > 0 && !Objects.equals(person.getGender(), gender)){
				person.setGender(gender);
				}
			if(date_of_birth != null && date_of_birth.length() > 0 && !Objects.equals(person.getDate_of_birth(), date_of_birth)){
				person.setDate_of_birth(date_of_birth);
				}
			if(country_of_birth != null && country_of_birth.length() > 0 && !Objects.equals(person.getCountry_of_birth(), country_of_birth)){
				person.setCountry_of_birth(country_of_birth);
				}
			
			personRepo.save(person);
			
			}	
		catch(Exception e){
			System.out.println("Id does not exist");
		}
	}
}
