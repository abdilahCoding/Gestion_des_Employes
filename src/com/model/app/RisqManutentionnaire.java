package com.model.app;

import java.sql.Date;

public class RisqManutentionnaire extends Manutentionnaire implements Risque {
	public RisqManutentionnaire(String firstName,String lastName,int age ,String date,int nbrHeur) {
			
			super(firstName,lastName,age,date,nbrHeur);
		}
		public double calculerSalaire() {
			return super.calculerSalaire() + prime;
		}
}
