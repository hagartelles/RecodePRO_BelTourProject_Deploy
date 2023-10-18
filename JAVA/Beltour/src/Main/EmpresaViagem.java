package Main;

public class EmpresaViagem {

	private long id;
	private long cnpj;
	private long telefone;
	private String nome;
	private String endereco;
	private String email;
	private String status;
	private String tipo;
	
	
	public EmpresaViagem( long id, long cnpj, String tipo,  long telefone, String nome, String endereco, String email, String status) {
		
		this.id = id;
		this.cnpj = cnpj;
		this.tipo = tipo;
		this.telefone = telefone;
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.status = status;	
	}
	
	
	public EmpresaViagem() {
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public long getCnpj() {
		return cnpj;
	}
	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}

	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
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
		return "Dados da Empresa "
				+ "\nID: " + id + ""
				+ "\nCNPJ: " + cnpj + ""
				+ "\nTelefone: " + telefone + "" 
				+ "\nNome: " + nome + ""
				+ "\nEndereco: " + endereco + ""
				+ "\nEmail: " + email + ""
				+ "\nStatus: " + status + ""
				+ "\nTipo: " + tipo + "";
	}
	
	
}
