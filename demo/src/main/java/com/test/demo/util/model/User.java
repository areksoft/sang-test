package com.test.demo.util.model;

public class User {

@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", gender=" + gender + ", status=" + status + "]";
	}
int id;
String name;
String gender;
String status;	
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

}
