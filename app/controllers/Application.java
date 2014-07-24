package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.student_report;
import views.html.yt_list;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render(""));
    }
    
	public static Result studentReport(){
		String feedback = "";
		if (session("feedback") != null){
			feedback = session("feedback");
			session().remove("feedback");
		}
		return ok(student_report.render(feedback));
    }
	
	public static Result ytList(){
		String feedback = "";
		if (session("feedback") != null){
			feedback = session("feedback");
			session().remove("feedback");
		}
		return ok(yt_list.render(feedback));
    }
    
}
