package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.hsqldb.jdbc.JDBCPool;

public class Database {
	
	private DataSource dataSource;
	
	public Database() {
		JDBCPool pool = new JDBCPool();
		pool.setURL("jdbc:hsqldb:hsql://localhost/loja-virtual");
		pool.setUser("SA");
		pool.setPassword("");
		this.dataSource = pool;
	}
	
	
	Connection getConnection()throws SQLException{
	//	Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/loja-virtual", "SA", "");
		Connection connection = dataSource.getConnection();
		return connection;
	
	}
}