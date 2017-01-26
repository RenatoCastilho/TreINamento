package Restaurante;

public abstract class Funcionario {

	protected int id;
	protected int senha;

	public boolean removerDoEstoque(Item item, Estoque estoque){
		return estoque.remover(item);
	}

	public int getId(){
		return this.id;
	}

	public int getSenha(){
		return this.senha;
	}

}