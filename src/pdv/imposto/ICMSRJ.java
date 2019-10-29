package pdv.imposto;

import pdv.modelo.Venda;

public class ICMSRJ extends TemplateImposto {
	
	@Override
	protected boolean isTaxaMaxima(Venda venda) {
		// TODO Auto-generated method stub 	
		return (venda.calcularValorProdutos() > 2500);
	}

	@Override
	protected double taxaMaxima() {
		// TODO Auto-generated method stub
		return 0.25;
	}

	@Override
	protected double taxaNormal() {
		// TODO Auto-generated method stub
		return 0.15;
	}

}
