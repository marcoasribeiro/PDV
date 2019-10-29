package pdv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pdv.modelo.Produto;
import pdv.util.ConnectionPDVFactory;

public class ProdutoDAO {
	
	public void insere(Produto produto) {

		Connection conn = null;
		try {
			conn = ConnectionPDVFactory.getConnection();
			String sql = "insert into produto(codigo, nome, preco)" + 
					"values (?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql); // esta pedindo para preparar a conex�o
			ps.setInt(1, produto.getId()); // vai pegar o primeiro parametro ? e colocar o id por isso setInt
			ps.setString(2, produto.getNome());
			ps.setDouble(3, produto.getValor());
                        ps.setDouble(4, produto.getQuantidade());
			ps.executeUpdate(); //� executeUpdate pois quando nos modificamos o estado do bando sempre vai ser update
								// se for inserir, editar, excluir � update .. s� consulta se que query
			conn.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionPDVFactory.close(conn);
		}
				
	}
	

	public void atualizar(Produto produto) {

		Connection conn = null;
		try {
			conn = ConnectionPDVFactory.getConnection();
			String sql = "update produto set nome = (?), valor = (?) where codigo = (?)";
			PreparedStatement ps = conn.prepareStatement(sql); // esta pedindo para preparar a conex�o
			ps.setString(1, produto.getNome());
			ps.setDouble(2, produto.getValor());
			ps.setInt(3, produto.getId());
			ps.executeUpdate(); //� executeUpdate pois quando nos modificamos o estado do bando sempre vai ser update
								// se for inserir, editar, excluir � update .. s� consulta se que query
			conn.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionPDVFactory.close(conn);
		}
				
	}
	
	public void remove(int id) {

		Connection conn = null;
		try {
			conn = ConnectionPDVFactory.getConnection();
			String sql = "delete from produto where codigo = (?)";
			PreparedStatement ps = conn.prepareStatement(sql); 
			ps.setInt(1, id);
			ps.executeUpdate(); 
			conn.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionPDVFactory.close(conn);
		}
				
	}
	
	
	public List<Produto> getProdutos() {
		
		Connection conn = null;
		try {
			conn = ConnectionPDVFactory.getConnection();	
			String sql = "select * from produto";
			PreparedStatement ps = conn.prepareStatement(sql); 
			ResultSet rs = ps.executeQuery(); // Esse resultSet ele vai colocar os resultados em uma tabela .. 
			List<Produto> produtos = new ArrayList<Produto>();
			while(rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getInt(1));
				produto.setNome(rs.getString(2));
				produto.setValor(rs.getDouble(3));
				produtos.add(produto);
			}
			
			conn.close();
			return produtos;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionPDVFactory.close(conn);
		}
				
	}
	
	public List<Produto> buscaProdutos(String nome) {
		
		Connection conn = null;
		try {
			conn = ConnectionPDVFactory.getConnection();	
			String sql = "select * from produto where nome LIKE (?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+nome+"%");
			ResultSet rs = ps.executeQuery(); 
			List<Produto> produtos = new ArrayList<Produto>();
			while(rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getInt(1));
				produto.setNome(rs.getString(2));
				produto.setValor(rs.getDouble(3));
				produtos.add(produto);
			}
			
			conn.close();
			return produtos;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionPDVFactory.close(conn);
		}				
	}
	
	public Produto buscaP (int id) {
		Connection conn = ConnectionPDVFactory.getConnection();
		try {
			String sql = "select * from produto where codigo = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Produto produto = new Produto();
			while(rs.next()) {				
				produto.setId(rs.getInt(1));
				produto.setNome(rs.getString(2));
				produto.setValor(rs.getDouble(3));		
			}
			return produto;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			ConnectionPDVFactory.close(conn);
		}
	}
	
	public List<Produto> buscaPreco(double preco, boolean opcao) {
		Connection conn = ConnectionPDVFactory.getConnection();
		try {
			if(opcao) {
				String sql = "SELECT * FROM PRODUTO WHERE PRECO > ?  ";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setDouble(1, preco);
				ResultSet rs = ps.executeQuery();
				List<Produto> produtos = new ArrayList<>();
				while(rs.next()) {
					Produto p = new Produto();
					p.setId(rs.getInt(1));
					p.setNome(rs.getString(2));
					p.setValor(rs.getDouble(3));
					produtos.add(p);		
				}
				return produtos;
			}else {
				String sql = "SELECT * FROM PRODUTO WHERE PRECO < ? ";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setDouble(1, preco);
				ResultSet rs = ps.executeQuery();
				List<Produto> produtos = new ArrayList<>();
				while(rs.next()) {
					Produto p = new Produto();
					p.setId(rs.getInt(1));
					p.setNome(rs.getString(2));
					p.setValor(rs.getDouble(3));
					produtos.add(p);		
				}
				return produtos;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionPDVFactory.close(conn);
		}
	}

}
