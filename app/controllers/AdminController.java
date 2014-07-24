package controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import play.data.DynamicForm;
import play.data.Form;
import play.db.DB;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.student_report;

import com.typesafe.plugin.MailerAPI;
import com.typesafe.plugin.MailerPlugin;

public class AdminController extends Controller {
	
	public static final String ADMIN = "rpg";
	public static final String SUBJECT = "Meeting - low attendance";
	public static final String LOCATION = "C55, Llandinam Building";
	public static final String EMAIL_DOMAIN = "@aber.ac.uk";
	public static final String YT_UID = "tmm3";
	public static final String DOT_UID = "rpg";
	private static String feedback = "";
    
    @SuppressWarnings("unchecked")
	public static Result getJSON() throws SQLException {
    	Connection conn = DB.getConnection();
    	Statement stmt = null;
    	JSONArray jArray = new JSONArray();
		try {
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(
					"SELECT v.stud_ref, v.name, v.email, v.academic_year, v.ss_year, v.attended, v.total, v.overall,\n " +
					"v.stage_of_process, v.tutor_id, v.tutor_name, v.id_meeting, sm.responsible_id, sm.datetime " +
					"FROM v_student_report v\n " +		
					"left join v_recent_meeting sm on (v.id_meeting = sm.id) \n" +
					"where ((sm.DATETIME - SYSTIMESTAMP) < interval '10' minute \n"
					+ " and upper(sm.status) = 'STUDENT NOT ATTENDED') \n" 
					+ "or sm.DATETIME is null \n" +
					"order by v.name"
			);
			while (rs.next()) {
	            JSONObject studJSON = new JSONObject();
	            studJSON.put("stud_ref", rs.getString("stud_ref"));
	            studJSON.put("name", rs.getString("name"));
	            studJSON.put("email", rs.getString("email"));
	            studJSON.put("academic_year", rs.getString("academic_year"));
	            studJSON.put("ss_year", rs.getString("ss_year"));
	            studJSON.put("attended", rs.getString("attended"));
	            studJSON.put("total", rs.getString("total"));
	            studJSON.put("overall", rs.getString("overall"));
	            studJSON.put("stage_of_process", rs.getString("stage_of_process"));
	            studJSON.put("tutor_id", rs.getString("tutor_id"));
	            studJSON.put("tutor_name", rs.getString("tutor_name"));
	            jArray.add(studJSON);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.close();
		}
   
        return ok(jArray.toJSONString());
    }
    
    public static Result arrangeMeeting() throws SQLException{
    	DynamicForm formArray = Form.form().bindFromRequest();
    	Connection conn = DB.getConnection();
    	
    	try {
			Statement stmt = null;
			conn.setAutoCommit(false);
	    	stmt = conn.createStatement();
	    	
	    	String datetime = formArray.get("date") +" "+ formArray.get("hours") + ":" + formArray.get("minutes");
	    	String sql = 
	    			"insert into spam_meeting\n " +
	    			"(id, stud_ref, responsible_id, datetime, location, arranged_by, datetime_arrangement) values (\n " +
					"seq_spam_meeting.NEXTVAL,\n '" +
	    			formArray.get("stud_ref") + "',\n '" +
	    			formArray.get("year_tutor_uid") + "',\n " +
					"TO_TIMESTAMP('"+datetime+ "', 'DD/MM/YYYY HH24:MI'),\n '" +
					formArray.get("location") + "',\n '" +
					ADMIN + "',\n " +
					"TO_TIMESTAMP('"+datetime+ "', 'DD/MM/YYYY HH24:MI'))\n ";
			stmt.executeQuery(sql);
			if (emailMeeting(formArray) && emailYT(formArray)){
				stmt.executeQuery("commit");
				feedback = "Meeting arranged successfully!";
			} else {
				stmt.executeQuery("rollback");
				feedback += "Sorry, the meeting has not been arranged.";
			}
	    	
			//System.out.println(sql);
			conn.close();
    	} catch (Exception e) {
			conn.close();
			feedback = "An error has occurred while saving the data.\n";
			System.out.println("sql error");
		}
    	
    	session("feedback", feedback);
    	return redirect(routes.Application.studentReport());
    }
    
    public static boolean emailMeeting(DynamicForm formArray){
    	try {
	    	MailerAPI mail = play.Play.application().plugin(MailerPlugin.class).email();
	    	mail.setFrom(ADMIN + EMAIL_DOMAIN);
	    	String responsible = YT_UID;
	    	
	    	if (formArray.get("meeting_with") == "dot") { responsible = DOT_UID; }
	    	
	    	mail.setRecipient(responsible + EMAIL_DOMAIN, formArray.get("stud_uid")+EMAIL_DOMAIN);
	    	mail.setBcc(ADMIN + EMAIL_DOMAIN);
	    	mail.setSubject(SUBJECT);
	    	String message = 
	    			"Dear student and tutor,<br/><br/>	" +
	    			"It has been arranged a meeting to discuss the reason why the student " + 
	    			formArray.get("stud_name").split(", ")[1] + " " + formArray.get("stud_name").split(", ")[0] + 
	    			" has attended " + "less than 50% of the lectures from the past 2 weeks.<br/>"+
	    			"The meeting has been arranged as follows:<br/><br/>" +
	    			"Date: " + formArray.get("date") + "<br/>" +
	    			"Time: " + formArray.get("hours") + ":" + formArray.get("minutes") + "<br/>" +
	    			"Location: " + formArray.get("location") + "<br/>" +
	    			"With: "+ formArray.get("year_tutor_name") + 
	    			"<br/><br/>" +
	    			"Cheers,<br/>The Administrator";
	    	mail.send("", message);
	    	//System.out.println(message);
	    	return true;
    	} catch (Exception e) {
    		System.out.println("email error");
    		feedback = "It wasn't possible to email all the parties.\n";
			return false;
		}
    }
    
    public static boolean emailYT(DynamicForm formArray){
    	String student = formArray.get("stud_name").split(", ")[1] + " " + formArray.get("stud_name").split(", ")[0];
    	try {
	    	MailerAPI mail = play.Play.application().plugin(MailerPlugin.class).email();
	    	mail.setFrom(ADMIN + EMAIL_DOMAIN);
	    	
	    	mail.setRecipient(YT_UID + EMAIL_DOMAIN);
	    	//mail.setBcc(ADMIN + EMAIL_DOMAIN);
	    	mail.setSubject(student);
	    	String message = 
	    			"Dear Professor,<br/><br/>	" +
	    			"Follows the link with details about the meeting with the student " + student + ".<br /><br /> \n" +
	    			"<a href='http://localhost:9000/ytList?ytUid=" + formArray.get("year_tutor_uid") + "&stdUid=" +
	    			formArray.get("stud_uid") + "'>Meeting details</a>" +
			    	"<br/><br/>" +
					"Cheers,<br/>The Administrator";
	    	mail.send("", message);
	    	//System.out.println(message);
	    	return true;
    	} catch (Exception e) {
    		System.out.println("yt email error\n");
    		feedback = "It wasn't possible to email the Tutor.\n";
    		e.printStackTrace();
			return false;
		}
    }
    
}
