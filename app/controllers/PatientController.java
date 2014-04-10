package controllers;

import java.util.List;
import com.avaje.ebean.Ebean;
import models.Patients;
import play.data.Form;
import play.data.validation.ValidationError;
import play.mvc.Controller;
import play.mvc.Result;

public class PatientController extends Controller{
	
	public static Result create() {
		
		Form<Patients> form = Form.form(Patients.class).bindFromRequest();
		
		if (form.hasErrors()) {
			
			flash("error", "yes");

			for (String propertyName : form.errors().keySet()) {
				
				List<ValidationError> errorsForThisProperty = form.errors().get(propertyName);

				for (ValidationError firstErrorForThisProperty : errorsForThisProperty) {
					
					
					switch(firstErrorForThisProperty.message()) {
					
					case "error.required" :
						
						flash(propertyName + "-" + firstErrorForThisProperty.message(), propertyName + " is required"); 
						break;
					case "error.minLength" :
						flash(propertyName + "-" + firstErrorForThisProperty.message(), "minium length is " + firstErrorForThisProperty.arguments() + " for " + propertyName); 
						break;
					case "error.email" :
						flash(propertyName + "-" + firstErrorForThisProperty.message(), "Incorrect format for " + propertyName); 
						break;
					}
				}
			}
		} else {
			Patients patient = form.get();
			Ebean.save(patient);
		}

        return redirect(routes.Application.index());
	}

}
