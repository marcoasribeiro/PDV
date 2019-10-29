package pdv.comando;

import java.util.Scanner;

import pdv.dao.ProdutoDAO;
import pdv.modelo.Produto;

public class BuscaProdutoNome implements Comando {
	
	public void execute(Scanner scanner) {
		ProdutoDAO DAO = new ProdutoDAO();
		
		System.out.println("Digite o nome do produto: ");
		scanner.nextLine();
     	String nome = scanner.nextLine(); 
     	
     	for(Produto prodto : DAO.buscaProdutos(nome)) {
     		System.out.println(prodto);
     	}  
     }
		
}