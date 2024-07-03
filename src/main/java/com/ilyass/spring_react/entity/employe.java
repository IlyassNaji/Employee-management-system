package com.ilyass.spring_react.entity;

import jakarta.persistence.*;

@Entity
@Table(name="employees")
public class employe {
	
public employe() {
		super();
	}
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
@Column(name="lastName")
private String lastName;
@Column(name="firstName")
private String firstName;
@Column(name="email")
private String email;
public employe(int id,String lastName, String firstName, String email) {
	this.id=id;
	this.lastName = lastName;
	this.firstName = firstName;
	this.email = email;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

}
