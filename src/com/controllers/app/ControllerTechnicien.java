package com.controllers.app;

import java.sql.SQLException;

import com.model.app.Technicien;

public class ControllerTechnicien extends ConnectionLoad {
Technicien technicien ;
	public ControllerTechnicien() throws SQLException {
		// TODO Auto-generated constructor stub
		super();
		technicien = new Technicien();
		
	}
	public void Afficher() throws Exception {
		String sql="SELECT * FROM technicien";
		statement=connect.createStatement();
		resultSet=statement.executeQuery(sql);
		while(resultSet.next()) {
			technicien.setFirstName(resultSet.getString("firstName"));
			technicien.setLastName(resultSet.getString("lastName"));
			technicien.setAge(resultSet.getInt("age"));
			technicien.setDateEntree(resultSet.getString("date"));
			technicien.setNbrProduit(resultSet.getInt("nbrProduit"));
			System.out.println(technicien.toString());
		}
	}
		//Add and update
				public int AddOrUpdate( String firstName,String lastName,int age,String date,int nbrProduit,String choix) throws SQLException {
					String req="";
					if(choix=="Add") {
					req="INSERT INTO technicien VALUES(?,?,?,?,?)";
					prepare=connect.prepareStatement(req);
					prepare.setString(1, firstName);
					prepare.setString(2, lastName);
					prepare.setInt(3, age);
					prepare.setString(4, date);
					prepare.setInt(5, nbrProduit);
					
					}else if(choix=="update"){
						req="UPDATE technicien SET firstName=? , lastName =? , age=? , date=? , nbrProduit=?  WHERE  1";
						prepare=connect.prepareStatement(req);
						prepare.setString(1, firstName);
						prepare.setString(2, lastName);
						prepare.setInt(3, age);
						prepare.setString(4, date);
						prepare.setInt(5, nbrProduit);
					}
					int executeReq=prepare.executeUpdate();
					return executeReq;
				}
				public int delete() throws SQLException {
					String sql= "DELETE FROM technicien WHERE 1";
					prepare= connect.prepareStatement(sql);
					return prepare.executeUpdate();
				}
				public int NumberRow() throws Exception {
					int count=0;
					String sql="SELECT COUNT(*) FROM technicien";
					statement=connect.createStatement(resultSet.TYPE_SCROLL_INSENSITIVE,resultSet.CONCUR_READ_ONLY);
					resultSet=statement.executeQuery(sql);
					resultSet.next();
					count = resultSet.getInt(1);
					return count;
					
				}

}
