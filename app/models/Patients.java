package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import play.data.validation.Constraints.Email;
import play.data.validation.Constraints.MinLength;
import play.data.validation.Constraints.Required;

@Entity
public class Patients {
	@Id
	@GeneratedValue
	public int id;
	
	@Required
	@MinLength(1)
	public String name;
	
	@Email
	@MinLength(4)
	public String email;

}
