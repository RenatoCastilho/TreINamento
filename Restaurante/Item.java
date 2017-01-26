package Restaurante;

public class Item {

	private Produto produto;
	private int quantidade;

	public Item(Produto produto, int quantidade){
		this.produto = produto;
		this.quantidade = Math.abs(quantidade);
	}

	public Produto getProduto(){
		return this.produto;
	}

	public int getQuantidade(){
		return this.quantidade;
	}

	public void adicionarQuantidade(int quantidade){
		this.quantidade += quantidade;
	}

	public void removerQuantidade(int quantidade){
		this.quantidade -= quantidade;
	}

	public String toString(){
		return "Produto: "+produto.getNome()+"\nQuantidade: "+quantidade+
		"\nPreco : "+produto.getValor()*quantidade+" Pecas de Prata.";
	}

}