package controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import play.db.DB;

public class Parameters {
	public static  String ADMIN_UID = "";
	public static  String SUBJECT = "";
	public static  String EMAIL_DOMAIN = "";
	public static  String YT_YEAR1_UID = "";
	public static  String YT_YEAR2_UID = "";
	public static  String YT_YEAR3_UID = "";
	public static  String YT_YEAR1_NAME = "";
	public static  String YT_YEAR2_NAME = "";
	public static  String YT_YEAR3_NAME = "";
	public static  String DOT_UID = "";
	public static  String DOT_NAME = "";
	public static  String EMAIL_SUBJECT_YT_STD = "";
	public static  String EMAIL_BODY_YT_STD = "";
	public static  String EMAIL_SUBJECT_YT = "";
	public static  String EMAIL_BODY_YT = "";
	public static  String EMAIL_SUBJECT_DOT_STD = "";
	public static  String EMAIL_BODY_DOT_STD = "";
	public static  String EMAIL_SUBJECT_DOT = "";
	public static  String EMAIL_BODY_DOT = "";
	public static  String EMAIL_GREETING = "";
	
	/**
	 * Get and set the parameters from the system. These are coming from the table SPAM_PARAMETERS.
	 * @throws SQLException 
	 */
	public static void getParameters() throws SQLException{
		Connection conn = DB.getConnection();
	    Statement stmt = null;
	    
	    try {
	    	stmt = conn.createStatement();
		 	ResultSet rs = stmt.executeQuery("Select * from spam_parameters");
		 	rs.next();
		 	
			ADMIN_UID = rs.getString("ADMIN_UID");
			EMAIL_DOMAIN = rs.getString("EMAIL_DOMAIN");
			YT_YEAR1_UID = rs.getString("YT_YEAR1_UID");
			YT_YEAR2_UID = rs.getString("YT_YEAR2_UID");
			YT_YEAR3_UID = rs.getString("YT_YEAR3_UID");
			YT_YEAR1_NAME = rs.getString("YT_YEAR1_NAME");
			YT_YEAR2_NAME = rs.getString("YT_YEAR2_NAME");
			YT_YEAR3_NAME = rs.getString("YT_YEAR3_NAME");
			DOT_UID = rs.getString("DOT_UID");
			DOT_NAME = rs.getString("DOT_NAME");
			EMAIL_SUBJECT_YT_STD = rs.getString("EMAIL_SUBJECT_YT_STD");
			EMAIL_BODY_YT_STD = rs.getString("EMAIL_BODY_YT_STD");
			EMAIL_SUBJECT_YT = rs.getString("EMAIL_SUBJECT_YT");
			EMAIL_BODY_YT = rs.getString("EMAIL_BODY_YT");
			EMAIL_SUBJECT_DOT_STD = rs.getString("EMAIL_SUBJECT_DOT_STD");
			EMAIL_BODY_DOT_STD = rs.getString("EMAIL_BODY_DOT_STD");
			EMAIL_SUBJECT_DOT = rs.getString("EMAIL_SUBJECT_DOT");
			EMAIL_BODY_DOT = rs.getString("EMAIL_BODY_DOT");
			EMAIL_GREETING = rs.getString("EMAIL_GREETING");
			
			conn.close();
		 	
		} catch (Exception e) {
			e.printStackTrace();
			conn.close();
		}
	}
	
	/**
	 * Gets the responsible name for the current student. It can be year tutor or DOT.
	 * @param year_of_study
	 * @param stage_of_process
	 * @return responsible name
	 */
	public static String getResponsibleName(int year_of_study, String stage_of_process){
		
		if (stage_of_process.toUpperCase().equals("FIRST TIME")){
			switch(year_of_study){
				case 1:
					return YT_YEAR1_NAME;
				case 2:
					return YT_YEAR2_NAME;
				case 3:
					return YT_YEAR3_NAME;
			}
		}
		
		return DOT_NAME;
	}
	
	/**
	 * Gets the responsible uid for the current student. It can be year tutor or DOT.
	 * @param year_of_study
	 * @param stage_of_process
	 * @return responsible uid
	 */
	public static String getResponsibleUid(int year_of_study, String stage_of_process){
		
		if (stage_of_process.toUpperCase().equals("FIRST TIME")){
			switch(year_of_study){
				case 1:
					return YT_YEAR1_UID;
				case 2:
					return YT_YEAR2_UID;
				case 3:
					return YT_YEAR3_UID;
			}
		}
		return DOT_UID;
	}
}
