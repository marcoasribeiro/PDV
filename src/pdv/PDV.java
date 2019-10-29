package pdv;

import pdv.desconto.Desconto;
import pdv.desconto.DescontoGamer;
import pdv.desconto.DescontoGrandeQuantidade;
import pdv.desconto.DescontoProdutoValorAlto;
import pdv.desconto.DescontoValorAlto;
import pdv.desconto.DescontoVendaCasada;
import pdv.desconto.SemDesconto;
import pdv.imposto.ICMSSP;
import pdv.imposto.IPL;
import pdv.modelo.Produto;
import pdv.modelo.Venda;

public class PDV {

	public static void main(String[] args) {
		Desconto d1 = new DescontoGamer();
		Desconto d2 = new DescontoValorAlto();
		Desconto d3 = new DescontoGrandeQuantidade();
		Desconto d4 = new DescontoProdutoValorAlto();
		Desconto d5 = new DescontoVendaCasada();
		Desconto d0 = new SemDesconto();
		d1.setProximo(d2);
		d2.setProximo(d3);
		d3.setProximo(d4);
		d4.setProximo(d5);
		d5.setProximo(d0);
		
		Venda venda = new Venda();
		
		Produto p1 = new Produto();
		p1.setNome("Desktop");
		p1.setValor(3100);
		venda.adicionarProduto(p1);
		Produto p2 = new Produto();
		p2.setNome("Monitor");
		p2.setValor(800);
		venda.adicionarProduto(p2);
		venda.setImposto(new ICMSSP());
		venda.setImposto(new IPL());
		venda.setDesconto(d1);
		System.out.println(venda);
		

	}

}
