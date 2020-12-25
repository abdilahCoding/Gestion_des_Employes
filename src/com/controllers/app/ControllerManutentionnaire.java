package com.controllers.app;

import java.sql.SQLException;

import com.model.app.Manutentionnaire;

public class ControllerManutentionnaire extends ConnectionLoad {
	Manutentionnaire manutentionnaire;
public ControllerManutentionnaire() throws SQLException {
	super();
	manutentionnaire= new Manutentionnaire();
}

public void Afficher() throws Exception {
	String sql="SELECT * FROM Manutentionnaire";
	statement=connect.createStatement();
	resultSet=statement.executeQuery(sql);
	while(resultSet.next()) {
		manutentionnaire.setFirstName(resultSet.getString("firstName"));
		manutentionnaire.setLastName(resultSet.getString("lastName"));
		manutentionnaire.setAge(resultSet.getInt("age"));
		manutentionnaire.setDateEntree(resultSet.getString("date"));
		manutentionnaire.setNbrHeurs(resultSet.getInt("nbrHeurs"));
		System.out.println(manutentionnaire.toString());
	}
}
	//Add and update
			public int AddOrUpdate( String firstName,String lastName,int age,String date,int nbrHeurs,String choix) throws SQLException {
				String req="";
				if(choix=="Add") {
				req="INSERT INTO Manutentionnaire VALUES(?,?,?,?,?)";
				prepare=connect.prepareStatement(req);
				prepare.setString(1, firstName);
				prepare.setString(2, lastName);
				prepare.setInt(3, age);
				prepare.setString(4, date);
				prepare.setInt(5, nbrHeurs);
				
				}else if(choix=="update"){
					req="UPDATE Manutentionnaire SET firstName=? , lastName =? , age=? , date=? , nbrHeurs=?  WHERE 1";
					prepare=connect.prepareStatement(req);
					prepare.setString(1, firstName);
					prepare.setString(2, lastName);
					prepare.setInt(3, age);
					prepare.setString(4, date);
					prepare.setInt(5, nbrHeurs);
				}
				int executeReq=prepare.executeUpdate();
				return executeReq;
			}
			
			public int delete() throws SQLException {
				String sql= "DELETE FROM Manutentionnaire WHERE 1";
				prepare= connect.prepareStatement(sql);
				return prepare.executeUpdate();
			}
			
			public int NumberRow() throws Exception {
				int count=0;
				String sql="SELECT COUNT(*) FROM Manutentionnaire";
				statement=connect.createStatement(resultSet.TYPE_SCROLL_INSENSITIVE,resultSet.CONCUR_READ_ONLY);
				resultSet=statement.executeQuery(sql);
				resultSet.next();
				count = resultSet.getInt(1);
				return count;
				
			}
			
}
