package pdv.desconto;

import pdv.modelo.Venda;

public abstract class Desconto {
	
	protected Desconto proximo;
	
	public abstract double getValor(Venda venda);
	public abstract void setProximo(Desconto proximo);

}
