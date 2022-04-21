package in.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entities.Contact;

public interface ContactRepo extends JpaRepository<Contact, Integer> {

	
	
}
