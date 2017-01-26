package Restaurante;

public class Produto {

	private double valor;
	private String nome;

	public Produto(double valor, String nome){
		this.valor = valor;
		this.nome = nome;
	}

	public double getValor(){
		return this.valor;
	}
	public String getNome(){
		return this.nome;
	}

	public boolean comparar(Produto outro){
		if (this.nome.equals(outro.nome)){
			return true;
		}
		return false;
	}

}