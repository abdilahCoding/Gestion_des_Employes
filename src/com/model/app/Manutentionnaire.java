package com.model.app;

import java.sql.Date;

public class Manutentionnaire extends Employee {
private final int prixHeur=50;
private int nbrHeurs;
public Manutentionnaire() {}
public Manutentionnaire(String firstName,String lastName,int age , String date, int nbrHeurs) {
	super(firstName,lastName,age,date);
	this.nbrHeurs=nbrHeurs;
}
public int getNbrHeurs() {
	return nbrHeurs;
}
public void setNbrHeurs(int nbrHeurs) {
	this.nbrHeurs = nbrHeurs;
}
@Override
public double calculerSalaire() {
	// TODO Auto-generated method stub
	return prixHeur*nbrHeurs;
}
@Override
public String toString() {
	return super.toString() + "Nombre heure est : " + this.nbrHeurs + "]";
}
}
