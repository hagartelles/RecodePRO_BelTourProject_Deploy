package Controller;

import Main.ScannerAux;

public class MenuController {
	
	private int opcao;
	
	private AtualizarController atualizarController = new AtualizarController();
	private CadastrarController cadastrarController = new CadastrarController();
	private ExcluirController excluirController = new ExcluirController();
	private PesquisarController pesquisarController = new PesquisarController();
	
	public void controller(){

		do {
			System.out.println("=================================");
			System.out.println("|	Bem vindo !             |");
			System.out.println("|	Escolha uma das opções  |");
			System.out.println("|	1 - Cadastrar           |"); 
			System.out.println("|	2 - Pesquisar           |");
			System.out.println("|	3 - Atualizar           |");
			System.out.println("|	4 - Excluir             |"); 
			System.out.println("|	5 - Sair                |");
			System.out.println("=================================");
			opcao = ScannerAux.scanInt();
			
			switch (opcao) {
				case 1:
					cadastrarController.cadastrar();
					break;
				case 2:
					pesquisarController.pesquisar();
					break;
				case 3:
					atualizarController.atualizar();
					break;
				case 4:
					excluirController.excluir();
					break;
				case 5:
					System.exit(0);
				default:
					System.out.println("Opção inválida.");
			}
			
		} while (opcao != 5);
	};

}
