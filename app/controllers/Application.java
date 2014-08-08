package controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.typesafe.plugin.MailerAPI;
import com.typesafe.plugin.MailerPlugin;

import play.data.DynamicForm;
import play.data.Form;
import play.db.DB;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render(""));
    }
    
    public static Result summary() {
        return ok(summary.render(""));
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
	
	@SuppressWarnings("unchecked")
	public static Result jsonSummary(String stud_uid, String academic_year) throws SQLException {
//		DynamicForm formArray = Form.form().bindFromRequest();
		Connection conn = DB.getConnection();
		Statement stmt = null;
		JSONArray jArray = new JSONArray();
		
    	try {
	    	stmt = conn.createStatement();
	    	ResultSet rs = stmt.executeQuery(
	    			"select \n" +
					 " stp.EMAIL as stud_uid, \n" +
					 " CONCAT(CONCAT(stp.SURNAME, ', '), stp.FORENAMES) as stud_name, \n" +
					 " stp.ACADEMIC_YEAR, \n" +
					 " stp.SS_YEAR as year_of_study, \n" +
					 " decode(stp.status, 'R', 'Y', 'N') as repeating, \n" +
					 " sus.STAGE_OF_PROCESS, \n" +
					 " sm.DATETIME as datetime_meeting, \n" +
					 " CONCAT(CONCAT(st.SURNAME, ', '), st.FORENAMES) as responsible_name, \n" +
					 " sm.OUTCOME \n" +
					 "from stp_live_view stp \n" +
					 " inner join SPAM_MEETING sm on (stp.STUD_REF = sm.stud_ref) \n" +
					 " inner join st_staff st on (st.USER_ID = sm.RESPONSIBLE_ID) \n" +
					 " inner join spam_unsatisfactory_student sus on (sus.STUD_REF = stp.STUD_REF) \n" +
					 "where \n" +
					 " stp.EMAIL = '" + stud_uid + "' \n" +
					 " and stp.ACADEMIC_YEAR = '" + academic_year + "' "
			);
	    	while (rs.next()) {
	            JSONObject studJSON = new JSONObject();
	            studJSON.put("stud_uid", rs.getString("stud_uid"));
	            studJSON.put("stud_name", rs.getString("stud_name"));
	            studJSON.put("academic_year", rs.getString("academic_year"));
	            studJSON.put("year_of_study", rs.getString("year_of_study"));
	            studJSON.put("repeating", rs.getString("repeating"));
	            studJSON.put("datetime_meeting", rs.getString("datetime_meeting"));
	            studJSON.put("responsible_name", rs.getString("responsible_name"));
	            studJSON.put("outcome", rs.getString("outcome"));
	            studJSON.put("stage_of_process", rs.getString("stage_of_process"));
	            jArray.add(studJSON);
			}
			conn.close();
    	} catch (Exception e) {
			conn.close();
			System.out.println("sql error");
		}
        return ok(jArray.toJSONString());
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
			
			if (!responsible.toUpperCase().equals("ADMIN")){
				int year_of_study = Integer.parseInt(formArray.get("year_of_study"));
		
				responsible_uid = Parameters.getResponsibleUid(year_of_study, formArray.get("stage_of_process"));
				responsible_name = Parameters.getResponsibleName(year_of_study, formArray.get("stage_of_process"));
			}
			
 			if(responsible.toUpperCase().equals("YEAR_TUTOR") && email_std){
 				
 				mail.setRecipient(responsible_uid + Parameters.EMAIL_DOMAIN, stud_uid + Parameters.EMAIL_DOMAIN);
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
				email_subject = email_subject.replace("{stud_name}", stud_name);
				email_body = Parameters.EMAIL_BODY_YT;	
				email_body = email_body.replace("{stud_name}", stud_name);
				email_body = email_body.replace("{year_tutor_uid}", responsible_uid);
				email_body = email_body.replace("{stud_uid}", stud_uid);
				email_body += Parameters.EMAIL_GREETING;
				
 			}else if(responsible.toUpperCase().equals("DOT") && email_std){
 				
 				mail.setRecipient(responsible_uid + Parameters.EMAIL_DOMAIN, stud_uid + Parameters.EMAIL_DOMAIN);
 				email_subject = Parameters.EMAIL_SUBJECT_DOT_STD;
 				mail.setBcc(Parameters.ADMIN_UID + Parameters.EMAIL_DOMAIN);
				email_body = Parameters.EMAIL_BODY_DOT_STD;
				email_body = email_body.replace("{date}", date);
				email_body = email_body.replace("{time}", time);
				email_body = email_body.replace("{location}", location);
				email_body = email_body.replace("{stud_name}", stud_name);
				email_body = email_body.replace("{dot_name}", responsible_name);
				
 			}else if(responsible.toUpperCase().equals("DOT") && !email_std){
 				
 				mail.setRecipient(responsible_uid + Parameters.EMAIL_DOMAIN);
				email_subject = Parameters.EMAIL_SUBJECT_DOT;
				email_subject = email_subject.replace("{stud_name}", stud_name);
				email_body = Parameters.EMAIL_BODY_DOT;	
				email_body = email_body.replace("{stud_name}", stud_name);
				email_body = email_body.replace("{dot_uid}", responsible_uid);
				email_body = email_body.replace("{stud_uid}", stud_uid);
				email_body += Parameters.EMAIL_GREETING;
				
 			} else {
 				
 				email_subject = Parameters.EMAIL_SUBJECT_ADMIN;
 				email_subject = email_subject.replace("{stud_name}", stud_name);
 				mail.setRecipient(Parameters.ADMIN_UID + Parameters.EMAIL_DOMAIN);
 		    	mail.setSubject(email_subject);
 		    	email_body = Parameters.EMAIL_BODY_ADMIN;
 		    	email_body = email_body.replace("{stud_uid}", stud_uid);
 		    	email_body = email_body.replace("{stud_name}", stud_name);
 		    	email_body += Parameters.EMAIL_GREETING;
 			}
 			
 			mail.setFrom(Parameters.ADMIN_UID + Parameters.EMAIL_DOMAIN);
	    	mail.setSubject(email_subject);
	    	mail.send("", email_body);
	    	System.out.println(responsible_uid+"\n\n"+email_body);
 	    	
			return true;	
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}		
	}    
}
