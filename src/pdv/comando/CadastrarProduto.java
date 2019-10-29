package pdv.comando;

import java.util.Scanner;

import pdv.dao.ProdutoDAO;
import pdv.modelo.Produto;


public class CadastrarProduto implements Comando {
	
	public void execute (Scanner scanner)
	{
		ProdutoDAO DAO = new ProdutoDAO();
		Produto produto = new Produto();
		
	 	System.out.println("Digite o ID do produto: ");
	 	scanner.nextLine();
	 	produto.setId(scanner.nextInt());
	 	
	 	System.out.println("Digite o nome do produto: ");
	 	scanner.nextLine();
	 	produto.setNome(scanner.nextLine());
	 	             	
		System.out.println("Digite o valor do produto: ");
		produto.setValor(scanner.nextDouble());
		DAO.insere(produto);    
		
	}
	
}
