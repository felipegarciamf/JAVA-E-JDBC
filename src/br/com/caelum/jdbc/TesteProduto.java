package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;



import br.com.caelum.jdbc.modelo.Produto;

public class TesteProduto {

	public static void main(String[] args) throws SQLException {
		Database database = new Database();
		
		Produto mesa = new Produto("Mesa azul", "Mesa com pés");
		
		
		
        try (Connection con = new Database().getConnection()) {
        	String sql = "insert into Produto(nome, descricao) values (?, ?)";
        	
        	try(PreparedStatement sts = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
        		sts.setString(1, "nome");
        		sts.setString(2, "descricao");
        		sts.execute();
        		try(ResultSet rs = sts.getGeneratedKeys() ){
        			if(rs.next()) {
        				int id = rs.getInt("id");
        				mesa.setId(id);
        			}
        		}
        	}
        	

        }
		
	}
	
}
