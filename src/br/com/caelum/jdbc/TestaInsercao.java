package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

    public static void main(String[] args) throws SQLException {
        String nome = "Notebook";
        String descricao = "Notebook i5";

        Connection connection = Database.getConnection();

        String sql = "insert into Produto (nome, descricao) values ('" + nome + "', '" + descricao + "')";
        Statement stmt = connection.createStatement();
                boolean resultado = stmt.execute(sql);
        System.out.println(resultado);

        stmt.close();
        connection.close();

    }
	
	
}
