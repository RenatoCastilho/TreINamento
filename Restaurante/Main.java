package Restaurante;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		Restaurante rest = new Restaurante(obterFuncionarios(), obterEstoque());

		System.out.println("##Usuários válidos para testes:");
		System.out.println("Gerente: ID = 0, Senha = 0");
		System.out.println("Garcom: ID = 1, Senha = 1");

		//Dummy de Autenticação
		Funcionario fAtual = autenticar(teclado, rest);
		

		//Loops de execução
		if (fAtual instanceof Gerente) {
			Gerente ger = (Gerente)fAtual;
			System.out.println("Logado como GERENTE");
			int op = -1;
			while(op != 0){
				System.out.println("Digite o código da operação desejada:");
				System.out.println("0 - SAIR do programa");
				System.out.println("1 - REMOVER produto ao estoque");
				System.out.println("2 - ADICIONAR produto ao estoque");
				System.out.println("3 - EXTORNAR conta");
				System.out.println("4 - IMPRIMIR relatório");
				op = teclado.nextInt();
				teclado.nextLine();
				switch (op){
					case 0: System.out.println("Finalizando programa");
							break;
					case 1: if(ger.removerDoEstoque(gerarItem(teclado), rest.getEstoque())){
								System.out.println("Removido com sucesso.");
							}
							else{
								System.out.println("Remoção mal sucedida");
							}
							break;
					case 2: ger.adicionarAoEstoque(gerarItem(teclado), rest.getEstoque());
							break;
					case 3: System.out.println("Digite o ID da conta a ser extornada");
							int idConta = teclado.nextInt();
							if (ger.extornar(idConta, rest)) {
								System.out.println("Extorno bem sucedido.");
							}
							else{
								System.out.println("Extorno mal sucedido.");
							}
							break;

					case 4: ger.imprimirRelatorio(rest);
							break;

					default: System.out.println("Código inválido");
				}
			}
			
		}
		else if (fAtual instanceof Garcom) {
			Garcom gar = (Garcom)fAtual;
			System.out.println("Logado como GARCOM");
			int op = -1;
			while(op != 0){
				System.out.println("Digite o código da operação desejada:");
				System.out.println("0 - SAIR do programa");
				System.out.println("1 - REMOVER produto do estoque");
				System.out.println("2 - ABRIR conta");
				System.out.println("3 - FECHAR conta");
				System.out.println("4 - ADICIONAR item a conta");
				op = teclado.nextInt();
				teclado.nextLine();
				switch (op){
					case 0: System.out.println("Finalizando programa");
							break;
					case 1: if(gar.removerDoEstoque(gerarItem(teclado), rest.getEstoque())){
								System.out.println("Removido com sucesso.");
							}
							else{
								System.out.println("Remoção mal sucedida");
							}
							break;
					case 2: gar.abrirConta(rest);
							break;
					case 3: System.out.println("Digite o ID da conta");
							if (gar.fecharConta(teclado.nextInt(), rest)) {
								System.out.println("Conta fechada com sucesso");
							}
							else{
								System.out.println("Conta não fechada");
							}
							break;

					case 4: System.out.println("Digite o ID da conta:");
							int idConta = teclado.nextInt();
							gar.adicionarNaConta(idConta, gerarItem(teclado), rest);

							break;

					default: System.out.println("Código inválido");
				}

			}
		}
	}

	private static Produto gerarProduto(Scanner teclado){
		System.out.println("Digite o nome do produto");
		String nome = teclado.nextLine();
		System.out.println("Digite o valor do produto (double-type)");
		double valor = 0;
		while (true) {
	    	try {
	        	valor = Double.parseDouble(teclado.next());
	        	break; // will only get to here if input was a double
	    	} catch (NumberFormatException ignore) {
	       		 System.out.println("Invalid input");
	    	}
		}
		Produto produto = new Produto(valor, nome);
		return produto;
	}

	private static Item gerarItem(Scanner teclado){
		Produto produto = gerarProduto(teclado);
		System.out.println("Digite a quantidade de produtos:");
		int qtd = teclado.nextInt();
		Item item = new Item(produto, qtd);
		return item;
	}

	private static Funcionario autenticar(Scanner teclado, Restaurante rest){
		Funcionario fAtual = null;
		boolean encontrado = false;
		boolean autenticado = false;
		while (!encontrado) {
			System.out.println("Login:");
			int login = teclado.nextInt();
			for (int i = 0; i < rest.getFuncionarios().size(); i++) {
				if (login == rest.getFuncionarios().get(i).getId()) {
					fAtual = rest.getFuncionarios().get(i);
					encontrado = true;
					System.out.println("Usuário encontrado.");
					break;
				}
			}
			if (!encontrado) {
					System.out.println("Usuário não encontrado.");
					continue;
			}
		}
		while(!autenticado){
			System.out.println("Senha:");
			int senha = teclado.nextInt();
			if (senha == fAtual.getSenha()) {
				autenticado = true;
				System.out.println("Autenticação bem sucedida!");
			}
			else{
				System.out.println("Senha inválida.");
			}
		}
		return fAtual;
	}

	private static Estoque obterEstoque(){
		Produto p1 = new Produto(2.0, "Hidromel");
		Produto p2 = new Produto(7.0, "Javali assado");
		Produto p3 = new Produto(5.0, "Vinho");
		Produto p4 = new Produto(5.0, "Pernil");
		Item i1 = new Item(p1, 10);
		Item i2 = new Item(p2, 5);
		Item i3 = new Item(p3, 10);
		Item i4 = new Item(p4, 5);
		ArrayList<Item> est = new ArrayList();
		est.add(i1);
		est.add(i2);
		est.add(i3);
		est.add(i4);
		Estoque estoque = new Estoque(est);
		return estoque;
	}

	private static ArrayList<Funcionario> obterFuncionarios(){
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		Gerente ge = new Gerente(0, 0);
		Garcom ga = new Garcom(1, 1);
		funcionarios.add(ge);
		funcionarios.add(ga);
		return funcionarios;
	}
}