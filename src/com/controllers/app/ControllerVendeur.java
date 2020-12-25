package com.controllers.app;

import java.sql.SQLException;

import com.model.app.Vendeur;

public class ControllerVendeur extends ConnectionLoad {
Vendeur vendeur;
	public ControllerVendeur() throws SQLException {
		// TODO Auto-generated constructor stub
		super();
		vendeur= new Vendeur();
	}
	public void Afficher() throws Exception {
		String sql="SELECT * FROM vendeur";
		statement=connect.createStatement();
		resultSet=statement.executeQuery(sql);
		while(resultSet.next()) {
			vendeur.setFirstName(resultSet.getString("firstName"));
			vendeur.setLastName(resultSet.getString("lastName"));
			vendeur.setAge(resultSet.getInt("age"));
			vendeur.setDateEntree(resultSet.getString("date"));
			vendeur.setChiffreDaffaire(resultSet.getDouble("prix"));
			System.out.println(vendeur.toString());
		}
	}
		//Add and update
				public int AddOrUpdate( String firstName,String lastName,int age,String date,double prix,String choix) throws SQLException {
					String req="";
					if(choix=="Add") {
					req="INSERT INTO vendeur VALUES(?,?,?,?,?)";
					prepare=connect.prepareStatement(req);
					prepare.setString(1, firstName);
					prepare.setString(2, lastName);
					prepare.setInt(3, age);
					prepare.setString(4, date);
					prepare.setDouble(5, prix);
					
					}else if(choix=="update"){
						req="UPDATE vendeur SET firstName=? , lastName =? , age=? , date=? , prix=?  WHERE 1";
						prepare=connect.prepareStatement(req);
						prepare.setString(1, firstName);
						prepare.setString(2, lastName);
						prepare.setInt(3, age);
						prepare.setString(4, date);
						prepare.setDouble(5, prix);
					}
					int executeReq=prepare.executeUpdate();
					return executeReq;
				}
				public int delete() throws SQLException {
					String sql= "DELETE FROM vendeur WHERE 1";
					prepare= connect.prepareStatement(sql);
					return prepare.executeUpdate();
				}
				
				public int NumberRow() throws Exception {
					int count=0;
					String sql="SELECT COUNT(*) FROM vendeur";
					statement=connect.createStatement(resultSet.TYPE_SCROLL_INSENSITIVE,resultSet.CONCUR_READ_ONLY);
					resultSet=statement.executeQuery(sql);
					resultSet.next();
					count = resultSet.getInt(1);
					return count;
					
				}
}
