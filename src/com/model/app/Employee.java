package com.model.app;


public abstract class  Employee {
	private String firstName;
	private String lastName;
	private int age;
	private String dateEntree;
	public Employee(){
		
	}
	public abstract double calculerSalaire();
	public Employee(String firstName, String lastName,int age , String date ) {
		this.firstName=firstName;
		this.lastName= lastName;
		this.age=age;
		this.dateEntree=date;
	}
	// getters
	public String getFirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public int getAge() {
		return this.age;
		
	}
	public String getDateEntree() {
	return this.dateEntree;
	}
	//Setters
	public void setFirstName(String firstName) {
		this.firstName= firstName;
	}
	public void setLastName(String lastName) {
	this.lastName= lastName;
	}
	public void setAge(int age) {
		this.age= age;
	}
	public void setDateEntree(String date) {
		this.dateEntree= date;
	}
	public String getNom() {
		return "Le nom est : " + this.firstName + " prenom est : " + this.lastName;
	}
	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", dateEntree="
				+ dateEntree +"";
	}
	
}
