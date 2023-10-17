package Controller;

import java.sql.Date;
import java.sql.SQLException;
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

public class CadastrarController {
	
	private ClienteDAO clienteDAO = new ClienteDAO();
	private EmpresaViagemDAO empresaDAO = new EmpresaViagemDAO();
	private ViagemDAO viagemDAO = new ViagemDAO();
	private ReservasDAO reservasDAO = new ReservasDAO(); 
	
	public void cadastrar() {
		
		do {
			System.out.println("=================================");
			System.out.println("	Cadastrar  ");
			System.out.println("	1 - Cliente           "); 
			System.out.println("	2 - Empresa           ");
			System.out.println("	3 - Viagem           ");
			System.out.println("	4 - Reserva           "); 
			System.out.println("	5 - Sair                ");
			System.out.println("=================================");
			
			switch (ScannerAux.scanInt()) {
				case 1:
					cadastrarCliente();
					System.out.println("Cliente cadastrado com sucesso!");
					cadastrar();
					break;
				case 2:
					cadastrarEmpresa();
					System.out.println("Empresa cadastrada com sucesso!");
					cadastrar();
					break;
				case 3:
					cadastrarViagem();
					System.out.println("Viagem salva com sucesso!");
					cadastrar();
					break;
				case 4:
					cadastrarReserva();
					System.out.println("Reserva criada com sucesso!");
					cadastrar();
					break;
				case 5:
					System.exit(0);
				default:
					System.out.println("Opção inválida.");
			}
			
		} while (ScannerAux.scanInt() != 5);
		
	};
	
	private void cadastrarCliente() {
		//preenchendo
		Cliente cliente = new Cliente();
		
		System.out.println("Informe o nome do cliente");
		cliente.setNome(ScannerAux.scanText());
		
		System.out.println("Informe o nome do cpf");
		cliente.setCpf(ScannerAux.scanLong());
		
		System.out.println("Informe o endereço do cliente");
		cliente.setEndereco(ScannerAux.scanText());
		
		System.out.println("Informe o Telefone do cliente");
		cliente.setTelefone(ScannerAux.scanLong());
		
		System.out.println("Informe o E-mail do cliente");
		cliente.setEmail(ScannerAux.scanText());
		
		cliente.setStatus("Ativo");
		
		clienteDAO.createCliente(cliente);
		}
	
	private void cadastrarEmpresa(){
		//preenchendo
		
		EmpresaViagem empresa = new EmpresaViagem();
		
		System.out.println("Informe o nome da empresa");
		empresa.setNome(ScannerAux.scanText());
		
		System.out.println("Informe o nome do cnpj da empresa");
		empresa.setCnpj(ScannerAux.scanLong());
		
		System.out.println("Informe o endereço da empresa");
		empresa.setEndereco(ScannerAux.scanText());
		
		System.out.println("Informe o Telefone da empresa");
		empresa.setTelefone(ScannerAux.scanLong());
		
		System.out.println("Informe o E-mail da empresa");
		empresa.setEmail(ScannerAux.scanText());
		
		empresa.setStatus("Ativo");
		
		System.out.println("Informe o tipo de transporte da empresa");
		empresa.setTipo(ScannerAux.scanText());
		
		empresaDAO.createEmpresa(empresa);
		}
	
	private void cadastrarViagem(){
		//preenchendo
		
		Viagem viagem = new Viagem();
		EmpresaViagem empresa = new EmpresaViagem();
		
		System.out.println("Informe o Destino");
		viagem.setDestino(ScannerAux.scanText());
		
		System.out.println("Informe a data da viagem");
		String dataViagem = ScannerAux.scanText();
		
		System.out.println("Informe a data de retorno");
		String dataRetorno = ScannerAux.scanText();
		
		System.out.println("Informe o id da empresa de viagem");
		empresa.setId(ScannerAux.scanLong());
		viagem.setEmpresaViagem(empresa);
		
		viagem.setStatus("Ativo");
		
		LocalDate localdate = LocalDate.now();
		Date dataSaida = Date.valueOf(localdate);
		
		viagemDAO.createViagem(viagem);
	}
	
	private void cadastrarReserva(){
		//preenchendo
		Reservas reserva = new Reservas();
		ReservasDAO reservasDAO = new ReservasDAO();
		Cliente cliente = new Cliente();
		Viagem viagem = new Viagem();
		
		System.out.println("Informe o n° do Cliente");
		cliente.setId(ScannerAux.scanLong());
		reserva.setCliente(cliente);
		
		System.out.println("Informe o n° da viagem");
		viagem.setId(ScannerAux.scanLong());
		reserva.setViagem(viagem);		
		reserva.setStatus("Ativo");
		
		LocalDate localdate = LocalDate.now();
		Date dataReserva = Date.valueOf(localdate);
		reserva.setDataReserva(dataReserva);
		
		reservasDAO.createReserva(reserva);
	}
}
