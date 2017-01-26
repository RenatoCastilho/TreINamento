package Restaurante;

public class Gerente extends Funcionario {

	public Gerente(int id, int senha){
		this.id = id;
		this.senha = senha;
	}

	public void adicionarAoEstoque(Item item, Estoque estoque){
		estoque.adicionar(item);
	}

	public boolean extornar(int idConta, Restaurante restaurante){
		return restaurante.removerVenda(idConta);
	}

	public void imprimirRelatorio(Restaurante restaurante){
		restaurante.gerarRelatorio();
	}

}