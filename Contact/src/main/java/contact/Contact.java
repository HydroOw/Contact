package contact;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	public String nom;
	public String prenom;
	public int age;
	public String email;
	public String telephone;
	
	protected Contact() {}
	
	public Contact(String nom, String prenom, int age, String email, String telephone) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.email = email;
		this.telephone = telephone;
	}
	
	@Override
    public String toString() {
        return String.format(
                "Customer[id=%d, prenom='%s', nom='%s', age='%d', email='%s', telephone='%s']",
                id, prenom, nom, age, email, telephone);
    }
}
