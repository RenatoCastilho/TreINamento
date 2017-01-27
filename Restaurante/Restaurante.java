package Restaurante;

import java.util.ArrayList;

public class Restaurante{

	private ArrayList<Funcionario> funcionarios;
	private ArrayList<Conta> vendas;
	private ArrayList<Conta> contasAbertas;
	private Estoque estoque;
	private static int idContas;

	public Restaurante(ArrayList<Funcionario> funcionarios, Estoque estoque){
		this.funcionarios = funcionarios;
		this.vendas = new ArrayList<Conta>();
		this.contasAbertas = new ArrayList<Conta>();
		this.estoque = estoque;
		this.idContas = 0;
	}

	public Restaurante(ArrayList<Funcionario> funcionarios, ArrayList<Conta> vendas, Estoque estoque){
		this.funcionarios = funcionarios;
		this.vendas = vendas;
		this.contasAbertas = new ArrayList<Conta>();
		this.estoque = estoque;
		this.idContas = vendas.get(vendas.size()-1).getId()+1;
	}

	public ArrayList<Funcionario> getFuncionarios(){
		return this.funcionarios;
	}

	public Estoque getEstoque(){
		return this.estoque;
	}

	public int getIdContas(){
		return this.idContas;
	}

	public void incrementarIdContas(){
		this.idContas++;
	}

	public ArrayList<Conta> getContasAbertas(){
		return this.contasAbertas;
	}

	public void addContaAberta(Conta conta){
		this.contasAbertas.add(conta);
	}

	public void addVenda(Conta conta){
		this.vendas.add(conta);
	}

	public boolean removerVenda(int id){
		for (int i = 0; i<vendas.size(); i++) {
			if (vendas.get(i).getId() == id) {
				vendas.remove(i);
				return true;
			}
		}
		return false;
	}

	public void gerarRelatorio(){
		System.out.println("Estoque:");
		for (int i = 0; i<estoque.getItens().size(); i++) {
			System.out.println(estoque.getItens().get(i).toString());
		}
		System.out.println("\nVendas:");
		double totalVendas = 0.0;
		for (int i = 0; i<vendas.size(); i++) {
			totalVendas += vendas.get(i).obterValor();
			System.out.println(vendas.get(i).toString());
		}
		System.out.println("Total de vendas: "+totalVendas);
		if (contasAbertas.size() > 0) {
			System.out.println("Ainda existem contas abertas: ");
				for (int i = 0; i<contasAbertas.size(); i++) {
					System.out.println(contasAbertas.get(i).toString());
				}
		}
	}

}