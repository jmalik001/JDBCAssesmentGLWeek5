package com.sg.assignment.util;

public class QueryBuilder {
	private static final String delQuery = "DELETE FROM \"user\"\r\n"
			+ "	WHERE \"user\".userid = ?";
	
	private static final String insertQue= "INSERT INTO public.\"user\"(\r\n"
			+ "	firstname, lastname, email, userid)\r\n"
			+ "	VALUES (?, ?, ?, (select max( userid ) from \"user\") +1)";
	
	private static final String displayUserQuery = "SELECT firstname, lastname, email, userid\r\n"
			+ "	FROM \"user\"";
	
	private static final String updateUserQuery = "UPDATE \"user\"\r\n"
			+ "	SET firstname=?, lastname=?, email=?\r\n"
			+ "	WHERE userid = ?";
	// private static final String registerQuery = ""
	
	public static String getDeleteUserQuery() {
		
		return delQuery;
		
	}
	public static String getRegisterQuery() {
		return insertQue;
	}

	
	public static String getDisplayUserQuery(){
		return displayUserQuery;
		
	}
	
	public static String getUpdateUserQuery(){
		return updateUserQuery;
		
	}
	
}
