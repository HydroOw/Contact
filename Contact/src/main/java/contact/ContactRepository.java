package contact;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import contact.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long> {

    List<Contact> findByPrenom(String prenom);
   
}