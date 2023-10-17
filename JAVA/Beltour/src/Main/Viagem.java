package Main;

import java.sql.Date;


public class Viagem {
		
	private long id;
	private String status;
	private String destino;
	private Date dataSaida;
	private Date dataRetorno;
	private EmpresaViagem empresaViagem;
	
	
	public Viagem(long id, String status, String destino, Date dataSaida, Date dataRetorno,
			EmpresaViagem empresaViagem) {
		super();
		this.id = id;
		this.status = status;
		this.destino = destino;
		this.dataSaida = dataSaida;
		this.dataRetorno = dataRetorno;
		this.empresaViagem = empresaViagem;
	}
	
	public Viagem(){
	};


	public String getStatus() {
		return status;
	}
	public void setStatus(String statusViagem) {
		this.status = statusViagem;
	}


	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}


	public Date getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}


	public Date getDataRetorno() {
		return dataRetorno;
	}
	public void setDataRetorno(Date dataRetorno) {
		this.dataRetorno = dataRetorno;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public EmpresaViagem getEmpresaViagem() {
		return empresaViagem;
	}
	public void setEmpresaViagem(EmpresaViagem empresaViagem) {
		this.empresaViagem = empresaViagem;
	}
	
	@Override
	public String toString() {
		return "Dados da Viagem \nID: " + id + "\nStatus: " + status + "\nData de Saída: " + dataSaida + "\nData de Retorno: " + dataRetorno
				+ "\nEmpresa de Viagem: " + empresaViagem.getNome() + "";
	}
	

}
