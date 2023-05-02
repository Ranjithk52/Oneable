package com.emp.model;

import java.io.Serializable;

public class Employee implements Serializable{
public int empid;
public String name;
public String email;
public String empdomain;
public Employee(){
	
}

public Employee(int empid, String name, String email, String empdomain) {
	super();
	this.empid = empid;
	this.name = name;
	this.email = email;
	this.empdomain = empdomain;
}

public int getEmpid() {
	return empid;
}

public void setEmpid(int empid) {
	this.empid = empid;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getEmpdomain() {
	return empdomain;
}

public void setEmpdomain(String empdomain) {
	this.empdomain = empdomain;
}





@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((empdomain == null) ? 0 : empdomain.hashCode());
	result = prime * result + empid;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Employee other = (Employee) obj;
	if (email == null) {
		if (other.email != null)
			return false;
	} else if (!email.equals(other.email))
		return false;
	if (empdomain == null) {
		if (other.empdomain != null)
			return false;
	} else if (!empdomain.equals(other.empdomain))
		return false;
	if (empid != other.empid)
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	return true;
}

@Override
public String toString() {
	return "Employee [empid=" + empid + ", name=" + name + ", email=" + email + ", empdomain=" + empdomain + "]";
}






}
