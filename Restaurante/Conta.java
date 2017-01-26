package Restaurante;

import java.util.ArrayList;

public class Conta {

	private int id;
	private ArrayList<Item> itens;
	private Garcom garcom;

	public Conta(Garcom garcom, Restaurante restaurante){
		this.garcom = garcom;
		this.id = restaurante.getIdContas();
		this.itens = new ArrayList<Item>();
	}

	public Conta(Garcom garcom, ArrayList<Item> itens, Restaurante restaurante){
		this.garcom = garcom;
		this.itens = itens;
		this.id = restaurante.getIdContas();
		restaurante.incrementarIdContas();
	}

	public String toString(){
		return "ID da Conta: "+id+"\nID do Garcom: "+garcom.getId()+
		"\nValor: "+obterValor();
	}

	public Garcom getGarcom(){
		return this.garcom;
	}

	public int getId(){
		return this.id;
	}

	public ArrayList<Item> getItens(){
		return this.itens;
	}

	public void addItem(Item item){
		for (int i = 0; i<itens.size(); i++) {
			if (itens.get(i).getProduto().comparar(item.getProduto())) {
				itens.get(i).adicionarQuantidade(item.getQuantidade());
				return;
			}
		}
		itens.add(item);
	}

	public double obterValor(){
		double sum = 0.0;
		for (int i = 0; i<itens.size() ; i++) {
			sum += itens.get(i).getProduto().getValor();
		}
		return sum;
	}
}