package br.com.caelum.jdbc;

import java.awt.font.TransformAttribute;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.modelo.Produto;

public class ProdutosDAO {
	
	private final Connection con;
	
	public ProdutosDAO(Connection con) {
		this.con = con;
	}
	
	public void salva(Produto produto) throws SQLException {
		String sql = "insert into Produto (nome, descricao) values (?,?)";
		
		try(PreparedStatement stms = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
    		stms.setString(1, "nome");
    		stms.setString(2, "descricao");
    		stms.execute();
    		try(ResultSet rs = stms.getGeneratedKeys() ){
    			if(rs.next()) {
    				int id = rs.getInt("id");
    				produto.setId(id);
    			}
    		}
    	}
	}
	
	public List<Produto> lista() throws SQLException {
		ArrayList<Produto> produtos = new ArrayList<>();
		String sql = "select * from Produto";	
		try(PreparedStatement stmt = con.prepareStatement(sql) ){
			stmt.execute();
			transformarResultadoEmProdutos(stmt, produtos);	
		}
		return produtos;
	}
	
	public void transformarResultadoEmProdutos(PreparedStatement stmt, List<Produto> produtos) throws SQLException {
	
		try(ResultSet rs = stmt.getResultSet()){
			while(rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String descricao = rs.getString("descricao");
				Produto produto = new Produto(nome, descricao);
				produto.setId(id);
				produtos.add(produto);
				
			}
		}
		
	}
	
}


