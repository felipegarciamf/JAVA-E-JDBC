package br.com.caelum.jdbc;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

import br.com.caelum.jdbc.modelo.Produto;

public class TesteProduto {

	public static void main(String[] args) throws SQLException {
		
		
		Produto mesa = new Produto("Mesa azul", "Mesa com pés");
		
		teste(mesa);

        
	}

	private static void teste(Produto produtobase) throws SQLException {
		try(Connection con = new Database().getConnection()){
			ProdutosDAO dao = new ProdutosDAO(con);
			dao.salva(produtobase);
			
			List<Produto> produtos = dao.lista();
			for (Produto produto : produtos) {
				System.out.println("Existe o produto: " + produto);
			}
		}
	}
}
