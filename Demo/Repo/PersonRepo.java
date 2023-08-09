package PostgreSQL.Database.Demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import PostgreSQL.Database.Demo.model.Person;


@Repository
public interface PersonRepo extends JpaRepository<Person, Long>{
	
	
	
	

}
