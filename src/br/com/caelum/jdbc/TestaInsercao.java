package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		
		String sql = "insert into produtos (nome, descricao) values (?, ?)";
		
		try(Connection connection = new Database().getConnection();){
			connection.setAutoCommit(false);

		try(PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);){

			adiciona("TV LCD", "TV muito boa", statement);
			adiciona("CAVALO", "Um belo cavalo", statement);
			connection.commit();
		} catch(Exception ex) {
			ex.getStackTrace();
			connection.rollback();
			System.err.println("Rollback Efetuado");
		}
		}
		
	}

	private static void adiciona(String nome, String descricao, PreparedStatement statement)
			throws SQLException {
		
		
		if(nome == "TV LCD") {
			throw new IllegalArgumentException("Problema Ocorrido");
			}
		
		statement.setString(1, nome);
		statement.setString(2, descricao);
		
		ResultSet resultSet = statement.getGeneratedKeys();
		boolean resultado = statement.execute();
		
		while(resultSet.next()) {
			String id = resultSet.getString("id");
			System.out.println("O id é " + id);
		}
		
		resultSet.close();
	}
	
	
}
