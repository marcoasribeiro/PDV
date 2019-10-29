package pdv.comando;

import pdv.dao.ProdutoDAO;
import pdv.modelo.Produto;

import java.util.Scanner;

public class ListarProdutos implements Comando {
	
	public void execute(Scanner entrada) {
		ProdutoDAO DAO = new ProdutoDAO();
		
		System.out.println("Lista de produtos:");
		for(Produto prod : DAO.getProdutos()) {
			System.out.println(prod);
		} 
	}
}
