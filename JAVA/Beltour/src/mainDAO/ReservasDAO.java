package mainDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Main.Cliente;
import Main.Reservas;
import Main.Viagem;

public class ReservasDAO {
	
private ClienteDAO clienteDAO = new ClienteDAO();
private ViagemDAO viagemDAO = new ViagemDAO();
	
	//CRIAR RESERVA
	public void createReserva(Reservas reserva){

        String sql = "INSERT INTO reservas "
        		+ "(ID_VIAGEM, ID_CLIENTE, STATUS_RESERVA, DATA_RESERVA)"
        		+ " VALUES (?, ?, ?, ?  )";
        PreparedStatement stmt = null;
        
        try{
        	Connection connection = DatabaseConnector.getConnection();
    		stmt = connection.prepareStatement(sql);
        	
        	LocalDate localdate = LocalDate.now();
    		Date dataReserva = Date.valueOf(localdate);
    		
        	stmt.setLong(1, reserva.getViagem().getId());
        	stmt.setLong(2, reserva.getCliente().getId());
        	stmt.setString(3, reserva.getStatus());
        	stmt.setDate(4, dataReserva);

        	stmt.executeUpdate();
        	stmt.close();
        	
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	//BUSCAR RESERVA
	public Reservas findById(long id){
    	
    	
    	Reservas reserva = null;
    	String sql = "SELECT * FROM reservas WHERE ID_reserva = ?";
    	
    	try {
    		Connection connection = DatabaseConnector.getConnection();
    		PreparedStatement stmt = connection.prepareStatement(sql);
    		
        	stmt.setLong(1, id);
            ResultSet result = stmt.executeQuery();
        	
            if (result.next()) {
            	reserva = new Reservas();
            	reserva.setCliente(new Cliente());
            	reserva.setViagem(new Viagem());
            	
            	reserva.setId(result.getLong(1));
            	reserva.getViagem().setId(result.getLong(2));
            	reserva.getCliente().setId(result.getLong(3));
            	reserva.setStatus(result.getString(4));
            	reserva.setDataReserva(result.getDate(5));
            	
            	popularReservaComViagem(reserva);
            	popularReservaComCliente(reserva);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	return reserva;
    }
	
	//LISTAR RESERVAS
	public List<Reservas> findAll(){
    	
    	List<Reservas> reservas = new ArrayList<>();
    	String sql = "SELECT * FROM reservas";
    	
    	try {
    		Connection connection = DatabaseConnector.getConnection();
    		PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            while (result.next()) {

            	Reservas reserva = new Reservas();
            	reserva.setCliente(new Cliente());
            	reserva.setViagem(new Viagem());
            	
            	reserva.setId(result.getLong(1));
            	reserva.getViagem().setId(result.getLong(2));
            	reserva.getCliente().setId(result.getLong(3));
            	reserva.setStatus(result.getString(4));
            	reserva.setDataReserva(result.getDate(5));
            	
            	popularReservaComViagem(reserva);
            	popularReservaComCliente(reserva);
            	reservas.add(reserva);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	return reservas;
    }
	
	//DELETAR RESERVA
	public void deleteById (long id){
   	
    	String sql = "DELETE FROM reservas WHERE ID_reserva = ?";
    	
    	try {
    		Connection connection = DatabaseConnector.getConnection();
    		PreparedStatement stmt = connection.prepareStatement(sql);
    		
    		stmt.setLong(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
            	System.out.println("Reserva " + id + " Deletada");
            } else {
            	System.out.println("nenhuma reserva deletado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	//ATUALIZAR RESERVA
	public void updateReserva (Reservas reserva){

		Reservas reservaAlvo = findById(reserva.getId());
	    	
	    	if(reservaAlvo == null) {
	    		System.out.println("esta reserva não existe ");
	    		return;
	    	}
	    
	    	String sql = "UPDATE RESERVAS "
	    			+ "SET ID_VIAGEM = ?,  ID_CLIENTE = ?, STATUS_RESERVA = ?, DATA_RESERVA = ?"
	    			+ "WHERE id_RESERVA = ?";
	    	
	    	try {
	    		Connection connection = DatabaseConnector.getConnection();
	    		PreparedStatement stmt = connection.prepareStatement(sql);
	    		
	    		stmt.setLong(1, reserva.getViagem().getId());
	            stmt.setLong(2, reserva.getCliente().getId());
	            stmt.setString(3, reserva.getStatus());
	            stmt.setDate(4, reserva.getDataReserva());
	            stmt.setLong(5, reserva.getId());
	            int rowsAffected = stmt.executeUpdate();
	            
	            if (rowsAffected > 0) {
	            	System.out.println("Reserva " + reserva.getId() + " Alterada com sucesso!");
	            } else {
	            	System.out.println("Nenhuma atualização realizada");
	            }
	            
	            
	        } catch (SQLException e) {

	            e.printStackTrace();
	        }
	    }
	 
	 private void popularReservaComViagem(Reservas reserva){
		
		 long chaveEstrangeiraDaViagem = reserva.getViagem().getId();
		 Viagem reservaDaViagem = viagemDAO.findById(chaveEstrangeiraDaViagem);
		 reserva.setViagem(reservaDaViagem);
			
	 }
	 
	 private void popularReservaComCliente(Reservas reserva){
		 
		 long chaveEstrangeiraDoCliente = reserva.getCliente().getId();
		 Cliente clienteDaReserva = clienteDAO.findById(chaveEstrangeiraDoCliente);
		 reserva.setCliente(clienteDaReserva);
	 }
}
