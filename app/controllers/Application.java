package controllers;

import models.Patients;

import com.avaje.ebean.Ebean;

import play.mvc.*;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render(Ebean.find(Patients.class).findList()));
    }

}
