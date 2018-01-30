package com.vo;

public class User {
	private String id;
	private String pwd;
	private String name;
	private int grade;
	
	private Item item;
	private int itemcount;
	
	public User() {
		
	}

	public User(String id, String pwd, String name, int grade) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.grade = grade;
	}

	public User(String id, String pwd, String name, int grade, Item item) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.grade = grade;
		this.item = item;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=").append(id).append(", pwd=").append(pwd).append(", name=").append(name)
				.append(", grade=").append(grade).append(", item=").append(item).append("]");
		return builder.toString();
	}

	public int getItemcount() {
		return itemcount;
	}

	public void setItemcount(int itemcount) {
		this.itemcount = itemcount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	
}
