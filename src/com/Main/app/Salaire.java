package com.Main.app;

import java.sql.SQLException;
import java.util.Scanner;

import com.controllers.app.ControllerManutentionnaire;
import com.controllers.app.ControllerRepresentation;
import com.controllers.app.ControllerTechnicien;
import com.controllers.app.ControllerVendeur;
import com.model.app.Employee;
import com.model.app.Manutentionnaire;
import com.model.app.Personnel;
import com.model.app.RisqManutentionnaire;
import com.model.app.RisqTechnicien;
import com.model.app.Technicien;
import com.model.app.Vendeur;

public class Salaire {
	public static void main(String[] args)  {
		try {
        Personnel p = new Personnel();
        Scanner input = new Scanner(System.in);
        ControllerManutentionnaire manutentionnaire= new ControllerManutentionnaire();
        ControllerRepresentation representation = new ControllerRepresentation();
        ControllerTechnicien technicien = new ControllerTechnicien();
        ControllerVendeur vendeur= new ControllerVendeur();
        String firstName,lastName,date;
        double prix=0.0;
        
        int nbrHeurs=0,age=0,nbrProduit=0,choixInput=0, choixNbrTable=0,GestionTableTechnicien=0,GestionTableManutentionnaire=0,GestionTableVendeur=0,GestionTableRespresentation=0;
        System.out.println("Welcom");
        System.out.println(" Gestion base donnee => 1 \n Gestion Personnel =>2  ");
        choixInput=input.nextInt();
       
        	switch(choixInput) {
        	case 1 : 
        		System.out.println("Welcom in dataBase Employee");
        		System.out.println("Tables => Manutentionnaire =>1 \n Respresentation =>2 \n Technicien =>3 \n Vendeur =>4");
        		choixNbrTable= input.nextInt();
        		break;
        	case 2 :
        		p.ajouterEmploye(new Vendeur("ayoub", "reda", 25,"2005", 10000));
                p.ajouterEmploye(new Technicien("ahmed", "jawhari", 28, "2000", 1000));
                p.ajouterEmploye(new Manutentionnaire("abderahman", "jamili", 40, "1998", 35));
                p.ajouterEmploye(new RisqTechnicien("jamal", "imrane", 33, "2007", 300));
                p.ajouterEmploye(new RisqManutentionnaire("Mohammed", "oubouhia", 30, "1999", 50));

                p.calculerSalaires();
                System.out.println("Le salaire moyen dans l'entreprise est de : "
                        + p.salaireMoyen() + " Dhs.");

        		break;
        	}
        	
        	while(true) {
        	switch(choixNbrTable) {
        	case 1 : 
        		System.out.println("table Manutentionnaire : Ajoute =>1 \n Modifier =>2 \n Supprimer => 3");
        		GestionTableManutentionnaire= input.nextInt();
        		break;
        	case 2:
        		System.out.println("table Respresentation : Ajoute =>1 \n Modifier =>2 \n Supprimer => 3");
        		GestionTableRespresentation= input.nextInt();
        		break;
        	case 3:
        		System.out.println("table Technicien : Ajoute =>1 \n Modifier =>2 \n Supprimer => 3");
        		GestionTableTechnicien= input.nextInt();
        		break;
        	case 4:
        		System.out.println("table Vendeur : Ajoute =>1 \n Modifier =>2 \n Supprimer => 3");
        		GestionTableVendeur= input.nextInt();
        		break;
        	}
        	
        	// gestion Ajouter / Modifier / Supprimer table Manutentionnaire
        	switch(GestionTableManutentionnaire) {
        		case 1:
        			System.out.println("Entre le nom ");
        			firstName= input.next();
        			System.out.println("Entre le Prenom ");
        			lastName= input.next();
        			System.out.println("Entre le age ");
        			age= input.nextInt();
        			System.out.println("Entre la date ");
        			date= input.next();
        			System.out.println("Entre le nombre de heure ");
        			nbrHeurs= input.nextInt();
        			if(manutentionnaire.AddOrUpdate(firstName, lastName, age, date, nbrHeurs, "Add")>0) {
        				System.out.println(GestionMessage.AJOUTER.getMessage());
        				manutentionnaire.Afficher();
        			}else {
        				System.out.println(GestionMessage.ERROR.getMessage());
        			}
        		break;
        		
        	case 2 :
        		manutentionnaire.Afficher();
        		if(manutentionnaire.NumberRow()>0) {
        		System.out.println("Entre le nom ");
    			firstName= input.next();
    			System.out.println("Entre le Prenom ");
    			lastName= input.next();
    			System.out.println("Entre le age ");
    			age= input.nextInt();
    			System.out.println("Entre la date ");
    			date= input.next();
    			System.out.println("Entre le nombre de heure ");
    			nbrHeurs= input.nextInt();
    			if(manutentionnaire.AddOrUpdate(firstName, lastName, age, date, nbrHeurs, "update")>0) {
    				System.out.println(GestionMessage.MODIFIER.getMessage());
    				manutentionnaire.Afficher();
    			}else {
    				System.out.println(GestionMessage.ERROR.getMessage());
    			}
        		}
        		break;
        	case 3:
        		manutentionnaire.Afficher();
        		if(manutentionnaire.NumberRow()>0) {
        			if(manutentionnaire.delete()>0) {
        				System.out.println(GestionMessage.SUPPRIMER.getMessage());
        				manutentionnaire.Afficher();
        			}else {
        				System.out.println(GestionMessage.ERROR.getMessage());
        			}
        		}
        		break;
        	}
        	
        	// gestion Ajouter / Modifier / Supprimer table representation
        	switch(GestionTableRespresentation) {
        		case 1:
        			System.out.println("Entre le nom ");
        			firstName= input.next();
        			System.out.println("Entre le Prenom ");
        			lastName= input.next();
        			System.out.println("Entre le age ");
        			age= input.nextInt();
        			System.out.println("Entre la date ");
        			date= input.next();
        			System.out.println("Entre le chiffre daffaire ");
        			prix= input.nextDouble();
        			if(representation.AddOrUpdate(firstName, lastName, age, date, prix, "Add")>0) {
        				System.out.println(GestionMessage.AJOUTER.getMessage());
        				representation.Afficher();
        			}else {
        				System.out.println(GestionMessage.ERROR.getMessage());
        			}
        		break;
        		
        	case 2 :
        		representation.Afficher();
        		if(representation.NumberRow()>0) {
        		System.out.println("Entre le nom ");
    			firstName= input.next();
    			System.out.println("Entre le Prenom ");
    			lastName= input.next();
    			System.out.println("Entre le age ");
    			age= input.nextInt();
    			System.out.println("Entre la date ");
    			date= input.next();
    			System.out.println("Entre le chiffre daffaire ");
    			prix= input.nextDouble();
    			if(representation.AddOrUpdate(firstName, lastName, age, date, prix, "update")>0) {
    				System.out.println(GestionMessage.MODIFIER.getMessage());
    				representation.Afficher();
    			}else {
    				System.out.println(GestionMessage.ERROR.getMessage());
    			}
        		}
        		break;
        	case 3:
        		representation.Afficher();
        		if(representation.NumberRow()>0) {
        			if(representation.delete()>0) {
        				System.out.println(GestionMessage.SUPPRIMER.getMessage());
        				representation.Afficher();
        			}else {
        				System.out.println(GestionMessage.ERROR.getMessage());
        			}
        		}
        		break;
        	}
        	
        	
          	// gestion Ajouter / Modifier / Supprimer table Technicien
        	switch(GestionTableTechnicien) {
        		case 1:
        			System.out.println("Entre le nom ");
        			firstName= input.next();
        			System.out.println("Entre le Prenom ");
        			lastName= input.next();
        			System.out.println("Entre le age ");
        			age= input.nextInt();
        			System.out.println("Entre la date ");
        			date= input.next();
        			System.out.println("Entre le nombre produit ");
        			nbrProduit= input.nextInt();
        			if(technicien.AddOrUpdate(firstName, lastName, age, date, nbrProduit, "Add")>0) {
        				System.out.println(GestionMessage.AJOUTER.getMessage());
        				technicien.Afficher();
        			}else {
        				System.out.println(GestionMessage.ERROR.getMessage());
        			}
        		break;
        		
        	case 2 :
        		technicien.Afficher();
        		if(technicien.NumberRow()>0) {
        		System.out.println("Entre le nom ");
    			firstName= input.next();
    			System.out.println("Entre le Prenom ");
    			lastName= input.next();
    			System.out.println("Entre le age ");
    			age= input.nextInt();
    			System.out.println("Entre la date ");
    			date= input.next();
    			System.out.println("Entre le nombre de produit ");
    			nbrProduit= input.nextInt();
    			if(technicien.AddOrUpdate(firstName, lastName, age, date, nbrProduit, "update")>0) {
    				System.out.println(GestionMessage.MODIFIER.getMessage());
    				technicien.Afficher();
    			}else {
    				System.out.println(GestionMessage.ERROR.getMessage());
    			}
        		}
        		break;
        	case 3:
        		technicien.Afficher();
        		if(technicien.NumberRow()>0) {
        			if(technicien.delete()>0) {
        				System.out.println(GestionMessage.SUPPRIMER.getMessage());
        				technicien.Afficher();
        			}else {
        				System.out.println(GestionMessage.ERROR.getMessage());
        			}
        		}
        		break;
        	}
        	
           	// gestion Ajouter / Modifier / Supprimer table Vendeur
        	switch(GestionTableVendeur) {
        		case 1:
        			System.out.println("Entre le nom ");
        			firstName= input.next();
        			System.out.println("Entre le Prenom ");
        			lastName= input.next();
        			System.out.println("Entre le age ");
        			age= input.nextInt();
        			System.out.println("Entre la date ");
        			date= input.next();
        			System.out.println("Entre le chiffre daffaire ");
        			prix= input.nextDouble();
        			if(vendeur.AddOrUpdate(firstName, lastName, age, date, prix, "Add")>0) {
        				System.out.println(GestionMessage.AJOUTER.getMessage());
        				vendeur.Afficher();
        			}else {
        				System.out.println(GestionMessage.ERROR.getMessage());
        			}
        		break;
        		
        	case 2 :
        		vendeur.Afficher();
        		if(vendeur.NumberRow()>0) {
        		System.out.println("Entre le nom ");
    			firstName= input.next();
    			System.out.println("Entre le Prenom ");
    			lastName= input.next();
    			System.out.println("Entre le age ");
    			age= input.nextInt();
    			System.out.println("Entre la date ");
    			date= input.next();
    			System.out.println("Entre le chiffre daffaire ");
    			prix= input.nextDouble();
    			if(vendeur.AddOrUpdate(firstName, lastName, age, date, prix, "update")>0) {
    				System.out.println(GestionMessage.MODIFIER.getMessage());
    				vendeur.Afficher();
    			}else {
    				System.out.println(GestionMessage.ERROR.getMessage());
    			}
        		}
        		break;
        	case 3:
        		vendeur.Afficher();
        		if(vendeur.NumberRow()>0) {
        			if(vendeur.delete()>0) {
        				System.out.println(GestionMessage.SUPPRIMER.getMessage());
        				vendeur.Afficher();
        			}else {
        				System.out.println(GestionMessage.ERROR.getMessage());
        			}
        		}
        		break;
        	}
        	
        	
        }
        
        
        
        
    
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
	}
}
