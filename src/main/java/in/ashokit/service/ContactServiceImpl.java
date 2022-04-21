package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.ashokit.entities.Contact;
import in.ashokit.repository.ContactRepo;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepo contactrepo;

	// used to save the record
	@Override
	public boolean saveContact(Contact contact) {
		Contact contact1 = new Contact();
		contact1.setActiveSw("Y");
		if (contactrepo.save(contact) != null) {
			return true;
		}
		return false;
	}

	// used to retrieve all the records
	@Override
	public List<Contact> getAllContacts() {
		Contact contact = new Contact();
		contact.setActiveSw("Y");
		Example<Contact> example = Example.of(contact);

		List<Contact> list = contactrepo.findAll(example);
		return list;
	}

	// used to get the record
	@Override
	public Contact getContactById(Integer contactId) {
		Optional<Contact> findById = contactrepo.findById(contactId);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	// used to soft delete the record
	@Override
	public boolean deleteContactById(Integer contactId) {
		Optional<Contact> findById = contactrepo.findById(contactId);
		if (findById.isPresent()) {
			Contact contact = findById.get();
			contact.setActiveSw("N");
			contactrepo.save(contact);
			return true;
		}
		return false;
	}

}
