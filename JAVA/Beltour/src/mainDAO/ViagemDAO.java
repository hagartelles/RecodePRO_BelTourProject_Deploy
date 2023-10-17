package mainDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Main.EmpresaViagem;
import Main.Viagem;

public class ViagemDAO {
	
	private EmpresaViagemDAO empresaViagemDAO = new EmpresaViagemDAO();
	//CADASTRAR VIAGEM
	public void createViagem(Viagem viagem){

        String sql = "INSERT INTO VIAGEM "
        		+ "(STATUS_VIAGEM, DESTINO, DATA_SAIDA, DATA_RETORNO, ID_EMPRESA_VIAGEM)"
        		+ " VALUES (?, ?, ?, ? ,? )";
        PreparedStatement stmt = null;
        
        try{
        	Connection connection = DatabaseConnector.getConnection();
    		stmt = connection.prepareStatement(sql);        	
        	
        	stmt.setString(1, viagem.getStatus());
        	stmt.setString(2, viagem.getDestino());
        	stmt.setDate(3, viagem.getDataSaida());
        	stmt.setDate(4, viagem.getDataRetorno());
        	stmt.setLong(5, viagem.getEmpresaViagem().getId());
            
        	stmt.executeUpdate();
            stmt.close();;

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public Viagem findById(long id) throws SQLException {
    	
    	Connection connection = DatabaseConnector.getConnection();
    	Viagem viagem = null;
    	String sql = "SELECT * FROM VIAGEM WHERE ID_VIAGEM = ?";
    	
    	try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        
        	stmt.setLong(1, id);
            ResultSet result = stmt.executeQuery();

            if (result.next()) {
            	viagem = new Viagem();
            	viagem.setEmpresaViagem(new EmpresaViagem());
            	
            	viagem.setId(result.getLong(1));
            	viagem.setStatus(result.getString(2));
            	viagem.setDestino(result.getString(3));
            	viagem.setDataSaida(result.getDate(4));
            	viagem.setDataRetorno(result.getDate(5));
            	viagem.getEmpresaViagem().setId(result.getLong(6));
            	popularEmpresaViagem(viagem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	return viagem;
    }
	
	public List<Viagem> findAll() throws SQLException {
    	
    	Connection connection = DatabaseConnector.getConnection();
    	List<Viagem> viagens = new ArrayList<>();
    	String sql = "SELECT * FROM VIAGEM";
    	
    	try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
            	Viagem viagem = new Viagem();
            	viagem.setEmpresaViagem(new EmpresaViagem());
            	viagem.setId(result.getLong(1));
            	viagem.setStatus(result.getString(2));
            	viagem.setDestino(result.getString(3));
            	viagem.setDataSaida(result.getDate(4));
            	viagem.setDataRetorno(result.getDate(5));
            	viagem.getEmpresaViagem().setId(result.getLong(6));
            	popularEmpresaViagem(viagem);
            	viagens.add(viagem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	return viagens;
    }
	
	public void deleteById (long id) throws SQLException {
   	
    	Connection connection = DatabaseConnector.getConnection();
    	String sql = "DELETE FROM viagem WHERE ID_VIAGEM = ?";
    	
    	try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        	
    		stmt.setLong(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
            	System.out.println("Viagem " + id + " Deletada");
            } else {
            	System.out.println("nenhum cadastro deletado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	
	 public void updateViagem (Viagem viagem) throws SQLException {
	    	Connection connection = DatabaseConnector.getConnection();
	    	Viagem viagemAlvo = findById(viagem.getId());
	    	
	    	if(viagemAlvo == null) {
	    		System.out.println("esta Viagem não existe ");
	    		return;
	    	}

	    	String sql = "UPDATE VIAGEM "
	    			+ "SET status_VIAGEM = ?,  DESTINO = ?, DATA_SAIDA = ?, DATA_RETORNO = ?, ID_EMPRESA_VIAGEM = ?"
	    			+ "WHERE id_VIAGEM = ?";
	    	
	 
	    	
	    	try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	        	
	    		stmt.setString(1, viagem.getStatus());
	            stmt.setString(2, viagem.getDestino());
	            stmt.setDate(3, viagem.getDataSaida());
	            stmt.setDate(4, viagem.getDataRetorno());
	            stmt.setLong(5, viagem.getEmpresaViagem().getId());
	            stmt.setLong(6, viagem.getId());
	            int rowsAffected = stmt.executeUpdate();
	            
	            if (rowsAffected > 0) {
	            	System.out.println("Viagem " + viagem.getId() + " Alterada com sucesso!");
	            } else {
	            	System.out.println("Nenhuma atualização realizada");
	            }
	            
	            
	        } catch (SQLException e) {

	            e.printStackTrace();
	        }
	    }
	 
	 private void popularEmpresaViagem(Viagem viagem) throws SQLException {
		
		 long chaveEstrangeiraDaViagem = viagem.getEmpresaViagem().getId();
		 
		 EmpresaViagem empresaViagemDaViagem = empresaViagemDAO.findById(chaveEstrangeiraDaViagem);
		 viagem.setEmpresaViagem(empresaViagemDaViagem);
			
	 }

}
