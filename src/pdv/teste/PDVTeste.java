package pdv.teste;

import java.util.Hashtable;
import java.util.Scanner;

import pdv.comando.AtualizarProduto;
import pdv.comando.BuscaProdutoNome;
import pdv.comando.BuscaProdutoPreco;
import pdv.comando.CadastrarProduto;
import pdv.comando.Comando;
import pdv.comando.ListarProdutos;
import pdv.comando.RemoverProduto;
import pdv.comando.Sair;


public class PDVTeste {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int escolha = 0;

		System.out.println("\n Escolha a a��o que deseja realizar nos produtos");
		System.out.println("\n 1 - Inserir");
		System.out.println("\n 2 - Atualizar");
        System.out.println("\n 3 - Remover");
        System.out.println("\n 4 - Buscar por nome");
        System.out.println("\n 5 - Buscar por pre�o");
        System.out.println("\n 6 - Listar os produtos");
        System.out.println("\n 0 - Sair");
       
        Hashtable<Integer, Comando> comandos = new Hashtable<Integer, Comando>();
        
        comandos.put(0, new Sair());
        comandos.put(1, new CadastrarProduto());
        comandos.put(2, new AtualizarProduto());
        comandos.put(3, new RemoverProduto());
        comandos.put(4, new BuscaProdutoNome());
        comandos.put(5, new BuscaProdutoPreco());
        comandos.put(6, new ListarProdutos());
    
        while (escolha <= 6) {
        	
        	escolha = scanner.nextInt();
        	comandos.get(escolha).execute(scanner);
        	
        	System.out.println("\n Escolha a a��o que deseja realizar nos produtos");
    		System.out.println("\n 1 - Inserir");
    		System.out.println("\n 2 - Atualizar");
            System.out.println("\n 3 - Remover");
            System.out.println("\n 4 - Buscar por nome");
            System.out.println("\n 5 - Buscar por pre�o");
            System.out.println("\n 6 - Listar os produtos");
            System.out.println("\n 0 - Sair");
          
        }

	}

}
