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

public class DotController extends Controller{
	
	private static Connection conn;
	private static String feedback = "";
	
	@SuppressWarnings("unchecked")
	public static Result getJSON() throws SQLException {
		Parameters.getParameters();
    	conn = DB.getConnection();
    	Statement stmt = null;
    	JSONArray jArray = new JSONArray();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT v.stud_ref, v.name, v.email, v.academic_year, v.ss_year, v.attended, v.total, v.overall,\n " +
					"v.stage_of_process, v.tutor_id, v.tutor_name, v.id_meeting, sm.responsible_id, sm.datetime " +
					"FROM v_student_report v\n " +
					"inner join v_recent_meeting sm on (v.id_meeting = sm.id) \n" +
					"where upper(v.stage_of_process) != 'FIRST TIME' \n" +
					"and upper(sm.status) = 'MEETING TO HAPPEN' \n" +
					"order by v.name"
			);
			while (rs.next()) {
	            JSONObject studJSON = new JSONObject();
	            studJSON.put("stud_ref", rs.getString("stud_ref"));
	            studJSON.put("name", rs.getString("name"));
	            studJSON.put("email", rs.getString("email"));
	            studJSON.put("overall", rs.getString("overall"));
	            studJSON.put("stage_of_process", rs.getString("stage_of_process"));
	            studJSON.put("datetime", rs.getString("datetime"));
	            studJSON.put("id_meeting", rs.getString("id_meeting"));
	            studJSON.put("academic_year", rs.getString("academic_year"));
	            studJSON.put("responsible_uid", rs.getString("responsible_id"));
	            jArray.add(studJSON);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.close();
		}
   
        return ok(jArray.toJSONString());
    }
	
	public static Result updateOutcome() throws SQLException {
		
		DynamicForm formArray = Form.form().bindFromRequest();
		Statement stmt = null;
		
		try {
			conn = DB.getConnection();	
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			
			String stud_absent = "student not attended";
			String sql_stage_of_proccess = "";
			String sql_meeting = "";
			String sql = "";
			String datetime = formArray.get("date") +" "+ formArray.get("hours") + ":" + formArray.get("minutes");
			
			sql_meeting =
					"update spam_meeting sm\n " +
					"set sm.OUTCOME = '" + formArray.get("outcome") + "', \n" +
					"sm.STATUS = '" + stud_absent + "', \n" +
					"sm.DATETIME = " + "TO_TIMESTAMP('"+datetime+ "', 'DD/MM/YYYY HH24:MI') \n" +
					"where sm.ID = " + formArray.get("id_meeting")
			;
			
			if(formArray.get("absent") != null){//student absent
				String stage_of_proccess = "Second time not attended";
				sql_stage_of_proccess =
						"update spam_unsatisfactory_student \n" +
						"set stage_of_process = '" + stage_of_proccess + "', \n" +
						"	 responsible_id = '" + Parameters.DOT_UID + "'\n" +
						" where stud_ref = '" +  formArray.get("stud_ref") + 
						"' and curr_year = '"+  formArray.get("cur_year") + "'";
				
				sql = sql_meeting + ";\n " + sql_stage_of_proccess;
				System.out.println(sql);
				stmt.executeQuery(sql_meeting);
				stmt.executeQuery(sql_stage_of_proccess);
				
				//send an email with student name back to the admin to arrange a new meeting
				if(Application.sendEmail(formArray, "admin", false)){
					stmt.executeQuery("commit");
				}
			} else {
				stud_absent = "student attended";
				sql_meeting =
						"update spam_meeting sm\n " +
						"set sm.OUTCOME = '" + formArray.get("outcome") + "',\n " +
						"sm.STATUS = '" + stud_absent + "', \n" +
						"sm.DATETIME = " + "TO_TIMESTAMP('"+datetime+ "', 'DD/MM/YYYY HH24:MI') \n" +
						"where sm.ID = " + formArray.get("id_meeting");
				sql = sql_meeting;
				System.out.println(sql);
//				stmt.executeQuery(sql);
//				stmt.executeQuery("COMMIT");
			}
			
			feedback = "Submited successfully!";
			conn.close();
			
		} catch (SQLException e) {
			stmt.executeQuery("ROLLBACK");
			feedback = "Sorry, an error has occurred while saving the data.\n";
			conn.close();
			System.out.println("error update");
			e.printStackTrace();
		}
		
		session("feedback", feedback);
		return redirect(routes.Application.dotList()+"?dotUid="+formArray.get("responsible_uid"));
	}
}
