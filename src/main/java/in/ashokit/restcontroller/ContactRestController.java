package in.ashokit.restcontroller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.entities.Contact;
import in.ashokit.props.AppProperties;
import in.ashokit.service.ContactService;

@RestController
public class ContactRestController {

	@Autowired
	private ContactService service;

	@Autowired
	private AppProperties properties;

	@PostMapping("/contact")
	public String saveContact(@RequestBody Contact contact) {

		Map<String, String> messages = properties.getMessages();
		contact.setActiveSw("Y");
		boolean saveContact = service.saveContact(contact);
		if (saveContact) {
			return messages.get("contactsavesucc");
		}
		return messages.get("contactsavefail");
	}

	@GetMapping("/contacts")
	public List<Contact> getAllContact() {

		List<Contact> list = service.getAllContacts();
		return list;
	}

	@GetMapping("/contact/{cid}")
	public Contact editContact(@PathVariable("cid") Integer contactId) {
		return service.getContactById(contactId);

	}

	@DeleteMapping("/contact/{cid}")
	public String deleteContact(@PathVariable("cid") Integer contactId) {
		Map<String, String> messages = properties.getMessages();

		boolean status = service.deleteContactById(contactId);
		if (status) {
			Contact contact = new Contact();
			contact.setActiveSw("N");
			return messages.get("contactDelSuc");
		} else {
			Contact contact = new Contact();
			contact.setActiveSw("Y");
			return messages.get("contactDelFail");
		}

	}

}
