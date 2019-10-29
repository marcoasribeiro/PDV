package pdv.modelo;

public class Produto {
	
	private int id;
	private String nome;
	private double valor;
        private int Quantidade;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
        
	public double getQuantidade() {
		return Quantidade;
	}
	
	public void setQuantidade(int Quantidade) {
		this.Quantidade = Quantidade;
	}       
        
	
	public String toString() {
		return "\n Codigo: " + getId() + "\nNome: " + getNome() + "\nValor: " + getValor() + "\nQuantidade: " + getQuantidade();
		
	}
	
	

}
