package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = Database.getConnection();
		Statement statement = connection.createStatement();
		
		boolean resultado = statement.execute("insert into produtos (nome, descricao) values ('Notebook','Notebook Dell')");
		ResultSet resultSet = statement.getGeneratedKeys();
		
		
		while(resultSet.next()) {
			String id = resultSet.getString("id");
			System.out.println("O id é " + id);
		}
		
		resultSet.close();
		statement.close();
		connection.close();
		
	}
	
	
}
