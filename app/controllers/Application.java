package controllers;

import com.typesafe.plugin.MailerAPI;
import com.typesafe.plugin.MailerPlugin;

import play.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    public static Result sendEmail(){
    	MailerAPI mail = play.Play.application().plugin(MailerPlugin.class).email();
    	mail.setFrom("raulperesgoes@gmail.com");
    	mail.setRecipient("tmm3@aber.ac.uk", "rpg@aber.ac.uk");
    	mail.setSubject("SPAM - Monthly Report");
    	//sends text/html
    	mail.send("", "Dear Year Tutor,<br/><br/>"
    			+ "Folow the link with the list of unsatisfactory students of last month:<br/><br/>"
    			+ "<a href='http://localhost:9000/people'>Report (click me)</a><br/><br/>"
    			+ "Best regards,<br/>"
    			+ "SPAM Administrator");
    	
    	return redirect(routes.Application.index());
    }

}
