package Controller;

import java.sql.Date;
import java.time.LocalDate;

import Main.Cliente;
import Main.EmpresaViagem;
import Main.Reservas;
import Main.ScannerAux;
import Main.Viagem;
import mainDAO.ClienteDAO;
import mainDAO.EmpresaViagemDAO;
import mainDAO.ReservasDAO;
import mainDAO.ViagemDAO;

public class AtualizarController {
	
	private ClienteDAO clienteDAO = new ClienteDAO();
	private EmpresaViagemDAO empresaDAO = new EmpresaViagemDAO();
	private ViagemDAO viagemDAO = new ViagemDAO();
	private ReservasDAO reservasDAO = new ReservasDAO(); 
	
	public void atualizar() {
		
		do {
			System.out.println("=================================");
			System.out.println("		Atualizar  ");
			System.out.println("	1 - Cliente           "); 
			System.out.println("	2 - Empresa           ");
			System.out.println("	3 - Viagem           ");
			System.out.println("	4 - Reserva           "); 
			System.out.println("	5 - Sair                ");
			System.out.println("=================================");
			
			switch (ScannerAux.scanInt()) {
				case 1:
					atualizarCliente();
					System.out.println("Cliente atualizado com sucesso!");
					atualizar();
					break;
				case 2:
					atualizarEmpresa();
					System.out.println("Empresa atualizada com sucesso!");
					atualizar();
					break;
				case 3:
					atualizarViagem();
					System.out.println("Viagem atualizada com sucesso!");
					atualizar();
					break;
				case 4:
					atualizarReserva();
					atualizar();
					break;
				case 5:
					System.exit(0);
				default:
					System.out.println("Opção inválida.");
			}
			
		} while (ScannerAux.scanInt() != 5);
		
	};
	
	private void atualizarCliente() {
		//preenchendo
		
		System.out.println("informe o ID do cliente a ser atualizado");
		Cliente clienteAlvo = clienteDAO.findById(ScannerAux.scanLong());
		
		System.out.println("Informe o nome");
		clienteAlvo.setNome(ScannerAux.scanText());
		
		System.out.println("Informe o cpf");
		clienteAlvo.setCpf(ScannerAux.scanLong());
		
		System.out.println("Informe o endereço");
		clienteAlvo.setEndereco(ScannerAux.scanText());
		
		System.out.println("Informe o Telefone");
		clienteAlvo.setTelefone(ScannerAux.scanLong());
		
		System.out.println("Informe o E-mail");
		clienteAlvo.setEmail(ScannerAux.scanText());
		
		System.out.println("Informe o Status");
		clienteAlvo.setStatus(ScannerAux.scanText());
		
		clienteDAO.updateCliente(clienteAlvo);
		}
	
	private void atualizarEmpresa(){
		//preenchendo
		
		System.out.println("Informe o ID da empresa a ser atualizada");
		EmpresaViagem empresaAlvo = empresaDAO.findById(ScannerAux.scanLong());
		
		
		System.out.println("Informe o nome");
		empresaAlvo.setNome(ScannerAux.scanText());
		
		System.out.println("Informe o nome do cnpj");
		empresaAlvo.setCnpj(ScannerAux.scanLong());
		
		System.out.println("Informe o endereço");
		empresaAlvo.setEndereco(ScannerAux.scanText());
		
		System.out.println("Informe o Telefone");
		empresaAlvo.setTelefone(ScannerAux.scanLong());
		
		System.out.println("Informe o E-mail");
		empresaAlvo.setEmail(ScannerAux.scanText());
		
		System.out.println("Informe o Status");
		empresaAlvo.setStatus(ScannerAux.scanText());
		
		System.out.println("Informe o tipo de transporte da empresa");
		empresaAlvo.setTipo(ScannerAux.scanText());
		
		empresaDAO.updateEmpresa(empresaAlvo);
		}
	
	private void atualizarViagem(){
		//preenchendo
		EmpresaViagem empresa = new EmpresaViagem();
		
		System.out.println("Informe o ID da viagem a ser atualizada");
		Viagem viagemAlvo = viagemDAO.findById(ScannerAux.scanLong());
		
		System.out.println("Informe o Destino");
		viagemAlvo.setDestino(ScannerAux.scanText());
		
		System.out.println("Informe a data da viagem");
		String NovaDataViagem = ScannerAux.scanText();
		
		System.out.println("Informe a data de retorno");
		String NovaDataRetorno = ScannerAux.scanText();
		
		System.out.println("Informe o id da empresa de viagem");
		empresa.setId(ScannerAux.scanLong());
		viagemAlvo.setEmpresaViagem(empresa);
		
		System.out.println("Informe o status da viagem");
		viagemAlvo.setStatus(ScannerAux.scanText());
		

		
		viagemDAO.updateViagem(viagemAlvo);
	}
	
	private void atualizarReserva(){
		//preenchendo
		
		Reservas reserva = new Reservas();
		ReservasDAO reservasDAO = new ReservasDAO();
		Cliente cliente = new Cliente();
		Viagem viagem = new Viagem();
		
		System.out.println("Informe o n° da Reserva");
		Reservas reservaAlvo = reservasDAO.findById(ScannerAux.scanLong());
		
		System.out.println("Informe o n° do Cliente");
		cliente.setId(ScannerAux.scanLong());
		reservaAlvo.setCliente(cliente);
		
		System.out.println("Informe o n° da viagem");
		viagem.setId(ScannerAux.scanLong());
		reservaAlvo.setViagem(viagem);		
		
		System.out.println("Informe o status da Reserva");
		reservaAlvo.setStatus(ScannerAux.scanText());
		
		LocalDate localdate = LocalDate.now();
		Date dataReserva = Date.valueOf(localdate);
		reservaAlvo.setDataReserva(dataReserva);
		
		reservasDAO.updateReserva(reservaAlvo);
	}
}
