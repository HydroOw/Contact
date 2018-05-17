package contact;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner demo(ContactRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Contact("Jack", "Bauer",45,"jbauer45@wanadoo.org","0123456789"));
			repository.save(new Contact("Chloe", "O'Brian",32,"ch.obrian@aol.bis","9876543210"));
			repository.save(new Contact("Kim", "Bauer",25,"kimkfan@iwantmoney.boobs","0304050607"));

			// fetch all customers
			log.info("Contact found with findAll():");
			log.info("-------------------------------");
			for (Contact contact : repository.findAll()) {
				log.info(contact.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			if(repository.exists(1L)){
			Contact cont = repository.findOne(1L);
					log.info("Contact found with findOne(1L):");
					log.info("--------------------------------");
					log.info(cont.toString());
					log.info("");
			}

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByPrenom("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			// 	log.info(bauer.toString());
			// }
			log.info("");
		};
	}

}