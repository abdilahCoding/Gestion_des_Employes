package com.model.app;

import java.sql.Date;

public class RisqTechnicien extends Technicien implements Risque {

	public RisqTechnicien(String firstName, String lastName, int age, String date, int nbrProduit) {
		super(firstName, lastName, age, date, nbrProduit);
		// TODO Auto-generated constructor stub
	}
	public double calculerSalaire() {
		return super.calculerSalaire() + prime;
	}

}
