package com.controllers.app;

import java.sql.SQLException;

import com.model.app.Representation;

public class ControllerRepresentation extends ConnectionLoad {
	Representation representation;
	public ControllerRepresentation() throws SQLException {
		// TODO Auto-generated constructor stub
		super();
		representation= new Representation();
	}
	public void Afficher() throws Exception {
		String sql="SELECT * FROM representation";
		statement=connect.createStatement();
		resultSet=statement.executeQuery(sql);
		while(resultSet.next()) {
			representation.setFirstName(resultSet.getString("firstName"));
			representation.setLastName(resultSet.getString("lastName"));
			representation.setAge(resultSet.getInt("age"));
			representation.setDateEntree(resultSet.getString("date"));
			representation.setChiffreDaffaire(resultSet.getDouble("prix"));
			System.out.println(representation.toString());
		}
	}
		//Add and update
				public int AddOrUpdate( String firstName,String lastName,int age,String date,double prix,String choix) throws SQLException {
					String req="";
					if(choix=="Add") {
					req="INSERT INTO representation VALUES(?,?,?,?,?)";
					prepare=connect.prepareStatement(req);
					prepare.setString(1, firstName);
					prepare.setString(2, lastName);
					prepare.setInt(3, age);
					prepare.setString(4, date);
					prepare.setDouble(5, prix);
					
					}else if(choix=="update"){
						req="UPDATE representation SET firstName=? , lastName =? , age=? , date=? , prix=?  WHERE 1";
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
					String sql= "DELETE FROM representation WHERE 1";
					prepare= connect.prepareStatement(sql);
					return prepare.executeUpdate();
				}

				public int NumberRow() throws Exception {
					int count=0;
					String sql="SELECT COUNT(*) FROM representation";
					statement=connect.createStatement(resultSet.TYPE_SCROLL_INSENSITIVE,resultSet.CONCUR_READ_ONLY);
					resultSet=statement.executeQuery(sql);
					resultSet.next();
					count = resultSet.getInt(1);
					return count;
					
				}
}
