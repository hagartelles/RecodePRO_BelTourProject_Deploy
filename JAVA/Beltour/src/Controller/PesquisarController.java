package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Main.Cliente;
import Main.EmpresaViagem;
import Main.Reservas;
import Main.ScannerAux;
import Main.Viagem;
import mainDAO.ClienteDAO;
import mainDAO.EmpresaViagemDAO;
import mainDAO.ReservasDAO;
import mainDAO.ViagemDAO;

public class PesquisarController {
	
	private ClienteDAO clienteDAO = new ClienteDAO();
	private EmpresaViagemDAO empresaDAO = new EmpresaViagemDAO();
	private ViagemDAO viagemDAO = new ViagemDAO();
	private ReservasDAO reservasDAO = new ReservasDAO(); 
	
	public void pesquisar(){
		
		do {
			System.out.println("=================================");
			System.out.println("	Pesquisar  ");
			System.out.println("	1 - Cliente           "); 
			System.out.println("	2 - Empresa           ");
			System.out.println("	3 - Viagem           ");
			System.out.println("	4 - Reserva           "); 
			System.out.println("	5 - Sair                ");
			System.out.println("=================================");
			
			switch (ScannerAux.scanInt()) {
				case 1:
					pesquisarCliente();
					pesquisar();
					break;
				case 2:
					pesquisarEmpresa();
					pesquisar();
					break;
				case 3:
					pesquisarViagem();
					pesquisar();
					break;
				case 4:
					pesquisarReserva();
					pesquisar();
					break;
				
				case 5:
					System.exit(0);
				default:
					System.out.println("Opção inválida.");
			}
			
		} while (ScannerAux.scanInt() != 5);
	};
	
	private void pesquisarCliente() {
		//Buscando
		
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = new Cliente();
		
		
		List<Cliente> clientes = clienteDAO.findAll();
		clientes.forEach(clientesCadastrados-> {
			System.out.println(clientesCadastrados);
			System.out.println("===================================================");
		});
		//clientes.forEach(c -> System.out.println(c));
		
		}
	
	private void pesquisarViagem() {
		//Buscando

		List<Viagem> viagens = viagemDAO.findAll();
		viagens.forEach(viagensCadastradas-> {
			System.out.println(viagensCadastradas);
			System.out.println("===================================================");
		});
		
		}
	
	private void pesquisarReserva() {
		//Buscando

		List<Reservas> reservas = reservasDAO.findAll();
		reservas.forEach(reservasCadastradas-> {
			System.out.println(reservasCadastradas);
			System.out.println("===================================================");
		});
		
		}
	
	private void pesquisarEmpresa() {
		//Buscando

		List<EmpresaViagem> empresas = empresaDAO.findAll();
		empresas.forEach(empresasCadastradas-> {
			System.out.println(empresasCadastradas);
			System.out.println("===================================================");
		});
		
		}
}
