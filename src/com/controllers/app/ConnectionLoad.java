package com.controllers.app;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Config.app.Connect;
import com.mysql.jdbc.Connection;

public class ConnectionLoad   {
	public Connection connect;
	public PreparedStatement prepare;
	public Statement statement;
	public ResultSet resultSet;
	Connect connection;
	public ConnectionLoad() throws SQLException {
	connection= new Connect("jdbc:mysql://localhost/Employee","root","");
	this.prepare=null;
	this.statement=null;
	this.resultSet=null;
	this.connect=connection.config();
	}
}
