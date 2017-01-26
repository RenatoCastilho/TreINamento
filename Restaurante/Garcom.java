package Restaurante;

import java.util.ArrayList;

public class Garcom extends Funcionario{

	public Garcom(int id, int senha){
		this.id = id;
		this.senha = senha;
	}

	public void abrirConta(Restaurante restaurante){
		restaurante.addContaAberta(new Conta(this, restaurante));
	}

	public boolean fecharConta(int id, Restaurante restaurante){
		ArrayList<Conta> contasAbertas = restaurante.getContasAbertas();
		for (int i = 0; i<contasAbertas.size() ; i++) {
			if (contasAbertas.get(i).getId() == id) {
				restaurante.addVenda(contasAbertas.get(i));
				contasAbertas.remove(i);
				return true;
			}
		}
		return false;
	}

	public boolean adicionarNaConta(int id, Item item, Restaurante restaurante){
		ArrayList<Conta> contasAbertas = restaurante.getContasAbertas();
		for (int i = 0; i<contasAbertas.size() ; i++ ) {
			if (contasAbertas.get(i).getId() == id) {
				if (restaurante.getEstoque().remover(item)) {
					contasAbertas.get(i).addItem(item);
					return true;	
				}
			}
		}
		return false;
	}

}