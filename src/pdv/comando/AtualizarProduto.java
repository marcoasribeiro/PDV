package pdv.comando;

import java.util.Scanner;

import pdv.dao.ProdutoDAO;
import pdv.modelo.Produto;

public class AtualizarProduto implements Comando {
	
	public void execute(Scanner scanner) {
		ProdutoDAO DAO = new ProdutoDAO();
		Produto produto = new Produto();

     	System.out.println("Digite o ID do produto que deseja atualizar: ");
     	scanner.nextLine();
     	produto = DAO.buscaP(scanner.nextInt());
     	
     	System.out.println("Digite o novo nome do produto: ");
     	scanner.nextLine();
     	produto.setNome(scanner.nextLine());
     	
 		System.out.println("Digite o novo valor do produto: ");
 		produto.setValor(scanner.nextDouble()) ;
 		
 		DAO.atualizar(produto);   
	}

}
