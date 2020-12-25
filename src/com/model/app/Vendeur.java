package com.model.app;

import java.sql.Date;

public class Vendeur extends Commercial {
	private final int bonus=1500;
	public Vendeur() {
	}
	public Vendeur(String firstName, String lastName, int age, String date, double prix) {
		super(firstName, lastName, age, date, prix);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculerSalaire() {
		// TODO Auto-generated method stub
		return (getChiffreDaffaire() * getMensuel()) + bonus;
	}
	@Override
	public String toString() {
		return super.toString() + "]";
	}
}
