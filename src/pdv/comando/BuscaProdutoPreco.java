package pdv.comando;

import java.util.Scanner;

import pdv.dao.ProdutoDAO;

public class BuscaProdutoPreco implements Comando{
	
	public void execute (Scanner scanner) {
		ProdutoDAO DAO = new ProdutoDAO();
		
		System.out.println("Digite o preco: ");
		scanner.nextLine();
		double preco = scanner.nextDouble();
		
		System.out.println("Deseja pesquisar todos os maiores que " + preco + " ou menores que " + preco + "? \nMaior:true\nMenor:false\n");
		scanner.nextLine();
		boolean opcaoP = scanner.nextBoolean();
		System.out.println(DAO.buscaPreco(preco, opcaoP));
		
	}

}
