package com.frame;

public class Sql {
	//1명 입력 + 물건 여러개 넣기
	public static String insertUser = "INSERT INTO T_USER VALUES (?,?,?)";
	public static String insertUserItem ="INSERT INTO T_USERITEM VALUES (?,?)";
	//1명 조회
	public static String selectUser = "SELECT * FROM T_USER WHERE ID = ?";
	public static String selectUserItem ="SELECT * FROM T_USERITEM WHERE ID = ?";
	public static String selectAllUser = "SELECT * FROM T_USER";
	
	public static String selectUserItem2 =  
			" SELECT IT.ID AS ID, IT.NAME AS NAME, IT.PRICE AS PRICE\r\n" + 
			" FROM T_USER us ,T_ITEM it, T_USERITEM ui\r\n" + 
			" WHERE us.id = ui.userid\r\n" + 
			" AND ui.itemid = it.id\r\n" + 
			" AND us.id = ? ";
	
}
