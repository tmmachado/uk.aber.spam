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
import views.html.yt_list;

public class YearTutorController extends Controller{
	
	private static Connection conn;
	
	@SuppressWarnings("unchecked")
	public static Result getJSON() throws SQLException {
    	conn = DB.getConnection();
    	Statement stmt = null;
    	JSONArray jArray = new JSONArray();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT v.stud_ref, v.name, v.email, v.academic_year, v.ss_year, v.attended, v.total, v.overall,\n " +
					"v.status, v.tutor_id, v.tutor_name, v.id_meeting, sm.responsible_id, sm.datetime " +
					"FROM v_student_report v\n " +
					"inner join spam_meeting sm on (v.id_meeting = sm.id) \n" +
					"where (sm.DATETIME - SYSTIMESTAMP) > interval '10' minute \n" +
					"and sm.DATETIME is not null \n" +
					"and sm.outcome is null"
			);
			while (rs.next()) {
	            JSONObject studJSON = new JSONObject();
	            studJSON.put("stud_ref", rs.getString("stud_ref"));
	            studJSON.put("name", rs.getString("name"));
	            studJSON.put("email", rs.getString("email"));
	            studJSON.put("overall", rs.getString("overall"));
	            studJSON.put("status", rs.getString("status"));
	            studJSON.put("tutor_id", rs.getString("tutor_id"));
	            studJSON.put("tutor_name", rs.getString("tutor_name"));
	            studJSON.put("datetime", rs.getString("datetime"));
	            studJSON.put("id_meeting", rs.getString("id_meeting"));
	            studJSON.put("academic_year", rs.getString("academic_year"));
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
			stmt = conn.createStatement();
			
			String stud_absent = "student not attend";
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
			
			if(formArray.get("absent") != null){
				String stage_of_proccess = "First time not attended";
				
				sql_stage_of_proccess =
						"update spam_unsatisfactory_student \n" +
						"set STATUS = '" + stage_of_proccess + "' \n" +
						"where stud_ref = '" +  formArray.get("stud_ref") + 
						"' and curr_year = '"+  formArray.get("cur_year") + "'";
				
				sql = sql_meeting + ";\n " + sql_stage_of_proccess;
				System.out.println(sql);
				stmt.addBatch(sql_meeting);
				stmt.addBatch(sql_stage_of_proccess);
				stmt.executeBatch();
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
				stmt.executeQuery(sql);
			}
			
			stmt.executeQuery("COMMIT");
			
			conn.close();
			
		} catch (SQLException e) {
			stmt.executeQuery("ROLLBACK");
			conn.close();
			System.out.println("error update");
		}
		
		return redirect(routes.Application.ytList()+"?ytUid="+formArray.get("year_tutor_uid"));
	}
}
