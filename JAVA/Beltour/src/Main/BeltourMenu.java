package Main;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import Controller.AtualizarController;
import Controller.CadastrarController;
import Controller.ExcluirController;
import Controller.PesquisarController;
import Controller.MenuController;

import java.sql.Date;
import mainDAO.ClienteDAO;
import mainDAO.EmpresaViagemDAO;
import mainDAO.ReservasDAO;
import mainDAO.ViagemDAO;

public class BeltourMenu {

	public static void main(String[] args) {
		MenuController menuController = new MenuController();
		menuController.controller();
	}

};
		
		/*ID_EMPRESA_VIAGEM
		NOME_EMPRESA_VIAGEM
		CNPJ
		TIPO
		ENDERECO_EMPRESA_VIAGEM
		TELEFONE_EMPRESA_VIAGEM
		EMAIL_EMPRESA_VIAGEM
		STATUS_EMPRESA*/
		
		// SET EMPRESA USANDO O METODO DE EMPRESAVIAGEMDAO
		/*
		empresa.setNome("TRANSBRASIL");
		empresa.setCnpj(132465);
		empresa.setTipo("Aerea");
		empresa.setEndereco("av. chile 121");
		empresa.setTelefone(0);
		empresa.setEmail("@.");
		empresa.setStatus("Inativa");
		
		empresaDAO.createEmpresa(empresa);
		*/
		
		
		/* SET CLIENTE USANDO O METODO EM CLIENTEDAO
	 	cliente.setStatus("Ativo")  ;
		cliente.setNome("Hagar");
		cliente.setCpf(11133366612L);
		cliente.setTelefone(21999060262L);
		cliente.setEndereco("Pio Borges, 2822");
		cliente.setEmail("hagar.telles@gmail.com");
		clienteDAO.createCliente(cliente);*/
		
		
		//DELETANDO CLIENTE METODO
		//System.out.println(clienteDAO.deleteById(3));
		//clienteDAO.deleteById(3);
		
		//empresaDAO.deleteById(3);
		//EmpresaViagem buscaEmpresa = empresaDAO.findById(3);
		//System.out.println(buscaEmpresa);
		
		//EmpresaViagem empresaAlvo = empresaDAO.findById(2);
		//empresaAlvo.setNome("Transfaliu");
		//empresaAlvo.setStatus("FALIU");
		//empresaDAO.updateEmpresa(empresaAlvo);
		
		
		
		
		/* METODO DE PROCURAR CLIENTE PELO ID
		Cliente currentClient = clienteDAO.findById(4);
		ATUALIZANDO O CLIENTE
	    currentClient.setNome("Victor");
	    clienteDAO.deleteById(4);
	    clienteDAO.updateCliente(currentClient);
		*/
		
		/*
		LocalDate localdate = LocalDate.now();
		Date dataSaida = Date.valueOf(localdate);
		viagem.setStatus("Ativa");
		viagem.setDestino("Rio de Janeiro");
		viagem.setDataSaida(dataSaida);
		viagem.setDataRetorno(dataSaida);
		empresa.setId(1);
		viagem.setEmpresaViagem(empresa);
		viagemDAO.createViagem(viagem);
		*/
		
		//Viagem buscaViagem = viagemDAO.findById(1);
		//buscaViagem.setEmpresaViagem(empresaDAO.findById(buscaViagem.getEmpresaViagem().getId()));
		// CRIANDO VARIAVEL PARA RECEBER O ID DA EMPRESA VIAGEM
		/*if(buscaViagem == null) {
			System.out.println("Nenhum cadastro encontrado");
		} else {
			long chaveEstrangeiraDaViagem = buscaViagem.getEmpresaViagem().getId();
			EmpresaViagem empresaViagemDaViagem = empresaDAO.findById(chaveEstrangeiraDaViagem);
			buscaViagem.setEmpresaViagem(empresaViagemDaViagem);
		
			System.out.println(buscaViagem.getEmpresaViagem().getId());
			System.out.println(buscaViagem);
		}*/
		
	
		//List<Viagem> viagens = viagemDAO.findAll();
		//viagens.forEach(v -> System.out.println(v));
		
		//viagemDAO.updateViagem(buscaViagem);
	
		/*ID_RESERVA
		ID_VIAGEM
		ID_CLIENTE
		STATUS_RESERVA
		DATA_RESERVA
    	 */
		
		/*Reservas reserva = new Reservas();
		ReservasDAO reservasDAO = new ReservasDAO();
		cliente.setId(1);
		viagem.setId(2);
		
		reserva.setCliente(cliente);
		reserva.setViagem(viagem);
		reserva.setStatus("Ativa");
		reservasDAO.createReserva(reserva);
		
		List<Reservas> reservas = reservasDAO.findAll();
		reservas.forEach(reservasCadastradas-> {
			System.out.println(reservasCadastradas);
			System.out.println("===================================================");
		});
		
		*/

