package com.model.app;

import java.util.ArrayList;

public class Personnel {
 ArrayList<Employee> listEmp;
 public Personnel() {
	 listEmp= new ArrayList<>();
 }
 public void ajouterEmploye(Employee e) {
	 listEmp.add(e);
 }
 //calculer Salaire
 public void calculerSalaires() {
     for (int i = 0; i < listEmp.size(); i++) {
         System.out.println(listEmp.get(i).getNom() + " gagne "
                 + listEmp.get(i).calculerSalaire() + " DHs.");
     }
 }
 // Salaire moyen
 public double salaireMoyen() {
	        double somme = 0.0;
	        for (int i = 0; i < listEmp.size(); i++) {
	            somme += listEmp.get(i).calculerSalaire();
	        }
	        return somme /listEmp.size() ;
	    
 }

}
