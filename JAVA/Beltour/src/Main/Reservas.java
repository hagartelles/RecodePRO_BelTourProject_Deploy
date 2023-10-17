package Main;

import java.sql.Date;


public class Reservas {

		private long id;
		private String status;
		private Date dataReserva;
		private Cliente cliente;
		private Viagem viagem;
		
		
		public Reservas(long id, String statusReserva, Date dataReserva, Cliente cliente, Viagem viagem) {
			super();
			this.id = id;
			this.status = statusReserva;
			this.dataReserva = dataReserva;
			this.cliente = cliente;
			this.viagem = viagem;
		}

		public Reservas() {};
		
		public String getStatus() {
			return status;
		}
		public void setStatus(String statusReserva) {
			this.status = statusReserva;
		}

		public Date getDataReserva() {
			return dataReserva;
		}
		public void setDataReserva(Date dataReserva) {
			this.dataReserva = dataReserva;
		}

		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}

		public Cliente getCliente() {
			return cliente;
		}
		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}

		public Viagem getViagem() {
			return viagem;
		}
		public void setViagem(Viagem viagem) {
			this.viagem = viagem;
		}
		
		@Override
		public String toString() {
			return "Dados da Reserva "
					+ "\nID: " + id + ""
					+ "\nStatus: " + status + ""
					+ "\nNome do cliente: " + cliente.getNome() + ""
					+ "\nEmpresa de Viagem: " + viagem.getDestino() + ""
					+ "\nData: " + dataReserva + "";
					
		}
}
