package com.model.app;

import java.sql.Date;

public class Technicien extends Employee  {
	private int nbrProduit;
	public Technicien() {}
public Technicien(String firstName,String lastName ,int age , String date,int nbrProduit) {
	super(firstName,lastName,age, date);
	this.nbrProduit=nbrProduit;
}

	public int getNbrProduit() {
	return nbrProduit;
}

public void setNbrProduit(int nbrProduit) {
	this.nbrProduit = nbrProduit;
}

	@Override
	public double calculerSalaire() {
		// TODO Auto-generated method stub
		return 5.0 * nbrProduit;
	}
	@Override
	public String toString() {
		return super.toString() + "Nombre Produit est : " + this.nbrProduit + "]";
	}
}
