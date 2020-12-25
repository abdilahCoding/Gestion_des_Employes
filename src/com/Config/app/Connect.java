package com.Config.app;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class Connect {
private Connection connect;
private String host;
private String User;
private String password;
public Connect() {}
public Connect(String host,String User,String password) {
	this.host=host;
	this.User=User;
	this.password=password;
}

public String getHost() {
	return host;
}
public void setHost(String host) {
	this.host = host;
}
public String getUser() {
	return User;
}
public void setUser(String user) {
	User = user;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Connection config() throws SQLException {
	 connect=(Connection) DriverManager.getConnection(getHost(), getUser(), getPassword());
	 return connect;
}

}
