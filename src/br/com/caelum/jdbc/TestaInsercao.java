package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		
		String nome = "Notebook";
		String descricao = "Notebook 'Dell";
		String sql = "insert into produtos (nome, descricao) values (?, ?)";
		
		Connection connection = Database.getConnection();

		PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		ResultSet resultSet = statement.getGeneratedKeys();
		
		statement.setString(1, nome);
		statement.setString(2, descricao);
		
		boolean resultado = statement.execute();
		
		while(resultSet.next()) {
			String id = resultSet.getString("id");
			System.out.println("O id é " + id);
		}
		
		resultSet.close();
		statement.close();
		connection.close();
		
	}
	
	
}
