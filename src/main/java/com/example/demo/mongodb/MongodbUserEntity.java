package com.example.demo.mongodb;

import java.io.Serializable;

public class MongodbUserEntity implements Serializable {

	private static final long serialVersionUID = 7174489045092818367L;
	
	private Long id;
    private String userName;
    private String passWord;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	@Override
	public String toString() {
		return "MongodbUserEntity [id=" + id + ", userName=" + userName + ", passWord=" + passWord + "]";
	}
}
