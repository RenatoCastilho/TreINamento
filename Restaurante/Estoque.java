package Restaurante;

import java.util.ArrayList;

public class Estoque {

	private ArrayList<Item> itens;

	public Estoque(ArrayList<Item> itens){
		this.itens = itens;
	}

	public ArrayList<Item> getItens(){
		return this.itens;
	}

	public void adicionar(Item item){
		Produto pi = item.getProduto();
		for (int i = 0; i<itens.size(); i++) {
			if (pi.comparar(itens.get(i).getProduto())) {
				itens.get(i).adicionarQuantidade(item.getQuantidade());
				return;
			}
		}
		itens.add(item);
	}

	public boolean remover(Item item){
		Produto pi = item.getProduto();
		for (int i = 0; i<itens.size(); i++) {
			if (pi.comparar(itens.get(i).getProduto())) {
				Item i1 = itens.get(i);
				if (i1.getQuantidade() < item.getQuantidade()) return false;
				i1.removerQuantidade(item.getQuantidade());
				return true;
			}
		}
		return false;
	}

}