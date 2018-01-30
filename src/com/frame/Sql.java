package com.frame;

public class Sql {
	// static : 변경이 되지 않고 동시에 여러클래스에서 사용할수 있는 변수일때 사용
	public static String insertUser = "INSERT INTO T_USER VALUES (?,?,?,?)";
	public static String updateUser = "UPDATE T_USER SET PWD =? , NAME = ?, GRADE = ?  WHERE ID = ?";
	public static String deleteUser = "DELETE FROM T_USER WHERE ID = ?";
	public static String selectAllUser = "SELECT * FROM T_USER";
	public static String selectUser ="SELECT * FROM T_USER WHERE ID = ?";
	
	public static String insertItem = "INSERT INTO T_ITEM VALUES (?,?,?,?)";
	public static String updateItem = "UPDATE T_ITEM SET NAME = ?, GRADE = ?, PRICE = ?  WHERE ID = ?";
	public static String deleteItem = "DELETE FROM T_ITEM WHERE ID = ?";
	public static String selectAllItem = "SELECT * FROM T_ITEM";
	public static String selectItem = "SELECT * FROM T_ITEM WHERE ID = ?";
	public static String selectGrade = selectAllItem + " WHERE GRADE = ?";
	
	public static String insertUI = "INSERT INTO T_USERITEM VALUES (?,?,?)";
	public static String updateUI = "UPDATE T_USERITEM SET ITEMID =? , COUNT = ? WHERE USERID = ?";
	public static String deleteUI = "DELETE FROM T_USERITEM WHERE USERID = ?";
	public static String selectAllUI = "SELECT * FROM T_USERITEM";
	public static String selectUI = selectAllUI+" WHERE USERID = ?";
	
}
