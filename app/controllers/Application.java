package controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.typesafe.plugin.MailerAPI;
import com.typesafe.plugin.MailerPlugin;

import play.data.DynamicForm;
import play.db.DB;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

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
	
	public static Result dotList(){
		String feedback = "";
		if (session("feedback") != null){
			feedback = session("feedback");
			session().remove("feedback");
		}
		return ok(dot_list.render(feedback));
    }
	
	/**
	 * Send an email to responsible and student with the details of the meeting
	 * @param formArray
	 * @param responsible
	 * @param email_std
	 * @return true or false
	 * @throws SQLException
	 */
	public static boolean sendEmail(DynamicForm formArray, String responsible, boolean email_std) throws SQLException{
		Parameters.getParameters();
		
		try {
			String stud_name = formArray.get("stud_name").split(", ")[1] + " " + formArray.get("stud_name").split(", ")[0];
			String date = "";
			String time = "";
			String location = "";
			String responsible_uid = "";
			String stud_uid = "";
			String email_body = "";
 	    	String email_subject = "";
			String dot_name = "";
 	    	
			if(email_std){
				date = formArray.get("date");
	 			time = formArray.get("hours") + ":" + formArray.get("minutes");
	 			location = formArray.get("location");
			}
			
 	    	MailerAPI mail = play.Play.application().plugin(MailerPlugin.class).email();
 	    	   	
			stud_uid = formArray.get("stud_uid");
			String responsible_name = "";
			int year_of_study = Integer.parseInt(formArray.get("year_of_study"));
	
			responsible_uid = Parameters.getResponsibleUid(year_of_study, formArray.get("stage_of_process"));
			responsible_name = Parameters.getResponsibleName(year_of_study, formArray.get("stage_of_process"));
			
 			if(responsible.toUpperCase().equals("YEAR_TUTOR") && email_std){
 				
 				mail.setRecipient(responsible_uid + Parameters.EMAIL_DOMAIN);
 				mail.setBcc(Parameters.ADMIN_UID + Parameters.EMAIL_DOMAIN);
				email_subject = Parameters.EMAIL_SUBJECT_YT_STD;
				email_body = Parameters.EMAIL_BODY_YT_STD;
				email_body = email_body.replace("{date}", date);
				email_body = email_body.replace("{time}", time);
				email_body = email_body.replace("{location}", location);
				email_body = email_body.replace("{stud_name}", stud_name);
				email_body = email_body.replace("{year_tutor_name}", responsible_name);
				email_body += Parameters.EMAIL_GREETING;
				
 			}else if(responsible.toUpperCase().equals("YEAR_TUTOR") && !email_std){
 				
 				mail.setRecipient(responsible_uid + Parameters.EMAIL_DOMAIN);
				email_subject = Parameters.EMAIL_SUBJECT_YT;
				email_body = Parameters.EMAIL_BODY_YT;	
				email_body = email_body.replace("{stud_name}", stud_name);
				email_body = email_body.replace("{year_tutor_uid}", responsible_uid);
				email_body = email_body.replace("{stud_uid}", stud_uid);
				email_body += Parameters.EMAIL_GREETING;
				
 			}else if(responsible.toUpperCase().equals("DOT") && email_std){
 				
 				email_subject = Parameters.EMAIL_SUBJECT_DOT_STD;
 				mail.setBcc(Parameters.ADMIN_UID + Parameters.EMAIL_DOMAIN);
				email_body = Parameters.EMAIL_BODY_DOT_STD;
				email_body = email_body.replace("{date}", date);
				email_body = email_body.replace("{time}", time);
				email_body = email_body.replace("{location}", location);
				email_body = email_body.replace("{stud_name}", stud_name);
				email_body = email_body.replace("{dot_name}", responsible_name);
				
 			}else{
 				
 				mail.setRecipient(responsible_uid + Parameters.EMAIL_DOMAIN);
				email_subject = Parameters.EMAIL_SUBJECT_DOT;
				email_body = Parameters.EMAIL_BODY_DOT;	
				email_body = email_body.replace("{stud_name}", stud_name);
				email_body = email_body.replace("{dot_uid}", responsible_uid);
				email_body = email_body.replace("{stud_uid}", stud_uid);
				email_body += Parameters.EMAIL_GREETING;
 			}
 			
 			mail.setFrom(Parameters.ADMIN_UID + Parameters.EMAIL_DOMAIN);
	    	mail.setSubject(email_subject);
	    	//mail.send("", email_body);
	    	System.out.println(responsible_uid+"\n\n"+email_body);
 	    	
			return true;	
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}		
	}    
}
