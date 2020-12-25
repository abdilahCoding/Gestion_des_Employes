package com.model.app;

import java.sql.Date;

public abstract class Commercial extends Employee {
private double chiffreDaffaire;
private final double mensuel=0.2;
public Commercial() {}
public Commercial(String firstName,String lastName,int age ,String date,double chiffreDaffaire) {
	super(firstName,lastName,age,date);
	this.chiffreDaffaire=chiffreDaffaire;
}
public double getChiffreDaffaire() {
	return chiffreDaffaire;
}
public void setChiffreDaffaire(double prix) {
	this.chiffreDaffaire = prix;
}
public double getMensuel() {
	return mensuel;
}
@Override
public String toString() {
	return super.toString() + "Chifre daffaire est : " + this.chiffreDaffaire + "]";
}

}
