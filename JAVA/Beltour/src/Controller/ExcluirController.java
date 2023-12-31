package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Main.Cliente;
import Main.ScannerAux;
import mainDAO.ClienteDAO;
import mainDAO.EmpresaViagemDAO;
import mainDAO.ReservasDAO;
import mainDAO.ViagemDAO;

public class ExcluirController {
	
	private ClienteDAO clienteDAO = new ClienteDAO();
	private EmpresaViagemDAO empresaDAO = new EmpresaViagemDAO();
	private ViagemDAO viagemDAO = new ViagemDAO();
	private ReservasDAO reservasDAO = new ReservasDAO(); 
	
	public void excluir(){
		
		do {
			System.out.println("=================================");
			System.out.println("	Excluir  ");
			System.out.println("	1 - Cliente           "); 
			System.out.println("	2 - Empresa           ");
			System.out.println("	3 - Viagem           ");
			System.out.println("	4 - Reserva           "); 
			System.out.println("	5 - Sair                ");
			System.out.println("=================================");
			
			switch (ScannerAux.scanInt()) {
				case 1:
					excluirCliente();
					excluir();
					break;
				case 2:
					excluirEmpresa();
					excluir();
					break;
				case 3:
					excluirViagem();
					excluir();
					break;
				case 4:
					excluirReserva();
					excluir();
					break;
				case 5:
					System.exit(0);
				default:
					System.out.println("Opção inválida.");
			}
			
		} while (ScannerAux.scanInt() != 5);
	};
	
	private void excluirCliente() {
		//preenchendo
		
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = new Cliente();
		
		System.out.println("Informe o ID da cliente a ser excluido");
		clienteDAO.deleteById(ScannerAux.scanLong());		
		}


	private void excluirEmpresa() {
		//preenchendo
		
			System.out.println("Informe o ID da empresa a ser excluido");
			empresaDAO.deleteById(ScannerAux.scanLong());		
		
		}
	private void excluirReserva() {
		//preenchendo
		
			System.out.println("Informe o ID da reserva a ser excluido");
			reservasDAO.deleteById(ScannerAux.scanLong());		
		
		}
	
	private void excluirViagem() {
		//preenchendo
		
			System.out.println("Informe o ID da Viagem a ser excluido");
			viagemDAO.deleteById(ScannerAux.scanLong());		
		
		}
}

