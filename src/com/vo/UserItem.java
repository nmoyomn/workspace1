package com.vo;

public class UserItem {
	String userId;
	int itemId;
	int count;
	public UserItem() {
	}
	public UserItem(String userId, int itemId, int count) {
		this.userId = userId;
		this.itemId = itemId;
		this.count = count;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserItem [userId=").append(userId).append(", itemId=").append(itemId).append(", count=")
				.append(count).append("]");
		return builder.toString();
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
