package Main;

import java.util.Objects;

public class Cliente {
	
	private long id;
	private long cpf;
	private long telefone;
	private String nome;
	private String endereco;
	private String email;
	private String status;
	 

	//ID_CLIENTE	bigint
	//STATUS_CLIENTE	varchar(10)
	//NOME_CLIENTE	varchar(30)
	//CPF	bigint
	//TELEFONE	bigint
	//ENDERECO	varchar(30)
	//EMAIL	varchar(30)
	
	public Cliente( long id, long cpf, long telefone, String nome, String endereco, String email, String status) {
		
		this.id = id;
		this.cpf = cpf;
		this.telefone = telefone;
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.status = status;	
	}
	
	
	public Cliente() {
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
		
	
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	
	
	public long getTelefone() {
		return telefone;
	}	
	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}
	
	
	public String getNome() {
		return nome; 
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Cliente [id=" + id + ", cpf=" + cpf + ", telefone=" + telefone + ", nome=" + nome + ", endereco="
				+ endereco + ", email=" + email + ", status=" + status + "]";
	}






	


	
}
