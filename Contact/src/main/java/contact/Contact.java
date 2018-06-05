package contact;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Contact {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@NotNull
	public String nom;
	
	@NotNull
	public String prenom;
	
	@NotNull
    @Min(1)
	@Max(121)
	public Integer age;
	
	@NotNull
	public String email;
	
	@NotNull
	@Size(min=4, max=10)
	public String telephone;
	
	protected Contact() {}
	
	public Contact(String nom, String prenom, int age, String email, String telephone) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.email = email;
		this.telephone = telephone;
	}
	
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	@Override
    public String toString() {
        return String.format(
                "Contact[id=%d, prenom='%s', nom='%s', age='%d', email='%s', telephone='%s']",
                id, prenom, nom, age, email, telephone);
    }
}
