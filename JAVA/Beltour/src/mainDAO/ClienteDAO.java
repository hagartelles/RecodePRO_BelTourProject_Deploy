package mainDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Main.Cliente;
import Main.Reservas;
import Main.Viagem;


public class ClienteDAO {
	
	//CRIAR CLIENTE
    public void createCliente(Cliente cliente) {
    	
    	String sql = "INSERT INTO cliente (status_cliente, nome_cliente, cpf, telefone, endereco, email ) VALUES (?, ?, ?, ? ,? , ?)";
    	PreparedStatement stmt = null;
    	
    	try {
    		Connection connection = DatabaseConnector.getConnection();
    		stmt = connection.prepareStatement(sql);
        	
        	stmt.setString(1, cliente.getStatus());
        	stmt.setString(2, cliente.getNome());
        	stmt.setLong(3, cliente.getCpf());
        	stmt.setLong(4, cliente.getTelefone());
        	stmt.setString(5, cliente.getEndereco());
            stmt.setString(6, cliente.getEmail());
            
            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Cliente findById(long id){
    	
    	String sql = "SELECT * FROM cliente WHERE ID_CLIENTE = ?";
    	Cliente cliente = null;
    	
    	try {
    		Connection connection = DatabaseConnector.getConnection();
    		PreparedStatement stmt = connection.prepareStatement(sql);
    		
        	
        	stmt.setLong(1, id);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
            	cliente = new Cliente();
            	cliente.setId(result.getLong(1));
            	cliente.setStatus(result.getString(2));
            	cliente.setNome(result.getString(3));
            	cliente.setCpf(result.getLong(4));
            	cliente.setTelefone(result.getLong(5));
            	cliente.setEndereco(result.getString(6));
            	cliente.setEmail(result.getString(7));
            	
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	return cliente;
    }
    
    public void deleteById (long id){
    	
    	
    	String sql = "DELETE FROM cliente WHERE ID_CLIENTE = ?";
    	
    	try {
    		
    		Connection connection = DatabaseConnector.getConnection();
    		PreparedStatement stmt = connection.prepareStatement(sql);
    		stmt.setLong(1, id);
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected > 0) {
            	System.out.println("Record " + id + " delete successfully");
            } else {
            	System.out.println("No records deleted");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
  //LISTAR RESERVAS
  	public List<Cliente> findAll() {
      	
      	
      	List<Cliente> clientes = new ArrayList<>();
      	String sql = "SELECT * FROM cliente";
      	
      	try {
      	
      		Connection connection = DatabaseConnector.getConnection();
      		PreparedStatement stmt = connection.prepareStatement(sql);
      		ResultSet result = stmt.executeQuery();

            while (result.next()) {

            	Cliente cliente = new Cliente();
            	cliente = new Cliente();
            	cliente.setId(result.getLong(1));
            	cliente.setStatus(result.getString(2));
            	cliente.setNome(result.getString(3));
            	cliente.setCpf(result.getLong(4));
            	cliente.setTelefone(result.getLong(5));
            	cliente.setEndereco(result.getString(6));
            	cliente.setEmail(result.getString(7));
            	clientes.add(cliente);
              }
          } catch (SQLException e) {
              e.printStackTrace();
          }
      	return clientes;
      }
    
    public void updateCliente (Cliente cliente){
    	
    	Cliente currentClient = findById(cliente.getId());
    	
    	if(currentClient == null) {
    		System.out.println("Client does not exist ");
    		return;
    	}
    	String sql = "UPDATE CLIENTE "
    			+ "SET status_cliente = ?,  nome_cliente = ?, cpf = ?, telefone = ?, endereco = ?, email = ? "
    			+ "WHERE id_cliente = ?";
    	
 
    	
    	try{
    		
    		Connection connection = DatabaseConnector.getConnection();
    		PreparedStatement stmt = connection.prepareStatement(sql);
        	
    		stmt.setString(1, cliente.getStatus());
            stmt.setString(2, cliente.getNome());
            stmt.setLong(3, cliente.getCpf());
            stmt.setLong(4, cliente.getTelefone());
            stmt.setString(5, cliente.getEndereco());
            stmt.setString(6, cliente.getEmail());
            stmt.setLong(7, cliente.getId());
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected > 0) {
            	System.out.println("Record " + cliente.getId() + " updated successfully");
            } else {
            	System.out.println("No records updated");
            }
            
            
        } catch (SQLException e) {

            e.printStackTrace();

        }
    	
    	
    }
}


