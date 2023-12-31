package mainDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Main.Cliente;
import Main.EmpresaViagem;

public class EmpresaViagemDAO {
	//CRIAR
	public void createEmpresa(EmpresaViagem empresa){

        String sql = "INSERT INTO empresa_viagem "
        		+ "(NOME_EMPRESA_VIAGEM, CNPJ, TIPO, ENDERECO_EMPRESA_VIAGEM, TELEFONE_EMPRESA_VIAGEM, EMAIL_EMPRESA_VIAGEM, STATUS_EMPRESA )"
        		+ " VALUES (?, ?, ?, ? ,? , ?, ?)";
        PreparedStatement stmt = null;
        
        try{
        	Connection connection = DatabaseConnector.getConnection();
    		stmt = connection.prepareStatement(sql);
        	
        	stmt.setString(1, empresa.getNome());
        	stmt.setLong(2, empresa.getCnpj());
        	stmt.setString(3, empresa.getTipo());
        	stmt.setString(4, empresa.getEndereco());
        	stmt.setLong(5, empresa.getTelefone());
            stmt.setString(6, empresa.getEmail());
            stmt.setString(7, empresa.getStatus());
            
            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	//PROCURAR
	 public EmpresaViagem findById(long id){
     	
	    	EmpresaViagem empresa = null;
	    	String sql = "SELECT * FROM EMPRESA_VIAGEM WHERE ID_EMPRESA_VIAGEM = ?";
	    	
	    	try {
	    		Connection connection = DatabaseConnector.getConnection();
	    		PreparedStatement stmt = connection.prepareStatement(sql);
	    		
	        	stmt.setLong(1, id);
	            ResultSet result = stmt.executeQuery();
	            if (result.next()) {
	            	empresa = new EmpresaViagem();
	            	empresa.setId(result.getLong(1));
	            	empresa.setNome(result.getString(2));
	            	empresa.setCnpj(result.getLong(3));
	            	empresa.setTipo(result.getString(4));
	            	empresa.setEndereco(result.getString(5));
	            	empresa.setTelefone(result.getLong(6));
	            	empresa.setEmail(result.getString(7));
	            	empresa.setStatus(result.getString(8));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    	return empresa;
	    }
	 
	//LISTAR
	  	public List<EmpresaViagem> findAll() {
	      	
	      	
	      	List<EmpresaViagem> empresas = new ArrayList<>();
	      	String sql = "SELECT * FROM EMPRESA_VIAGEM";
	      	
	      	try {
	      	
	      		Connection connection = DatabaseConnector.getConnection();
	      		PreparedStatement stmt = connection.prepareStatement(sql);
	      		ResultSet result = stmt.executeQuery();

	            while (result.next()) {

	            	EmpresaViagem empresa = new EmpresaViagem();
	            	empresa = new EmpresaViagem();
	            	empresa.setId(result.getLong(1));
	            	empresa.setNome(result.getString(2));
	            	empresa.setCnpj(result.getLong(3));
	            	empresa.setTipo(result.getString(4));
	            	empresa.setEndereco(result.getString(5));
	            	empresa.setTelefone(result.getLong(6));
	            	empresa.setEmail(result.getString(7));
	            	empresa.setStatus(result.getString(8));
	            	empresas.add(empresa);
	              }
	          } catch (SQLException e) {
	              e.printStackTrace();
	          }
	      	return empresas;
	      }
	 
	 //DELETE
	 public void deleteById (long id){
	    	
	    	
	    	String sql = "DELETE FROM EMPRESA_VIAGEM WHERE ID_EMPRESA_VIAGEM = ?";
	    	
	    	try {
	    		
	    		Connection connection = DatabaseConnector.getConnection();
	    		PreparedStatement stmt = connection.prepareStatement(sql);
	    		
	    		stmt.setLong(1, id);
	            int rowsAffected = stmt.executeUpdate();
	            if (rowsAffected > 0) {
	            	System.out.println("Cadastro de empresa n°" + id + " deletado com sucesso");
	            } else {
	            	System.out.println("ERRO, nenhum dado localizado.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 //UPDATE
	 public void updateEmpresa (EmpresaViagem empresa){
	    	
	    	EmpresaViagem empresaAlvo = findById(empresa.getId());
	    	
	    	if(empresaAlvo == null) {
	    		System.out.println("Empresa não existe ");
	    		return;
	    	}

	    	String sql = "UPDATE EMPRESA_VIAGEM "
	    			+ "SET NOME_EMPRESA_VIAGEM = ?,  CNPJ = ?, TIPO = ?, ENDERECO_EMPRESA_VIAGEM = ?, TELEFONE_EMPRESA_VIAGEM = ?, EMAIL_EMPRESA_VIAGEM = ?,STATUS_EMPRESA = ?  "
	    			+ "WHERE ID_EMPRESA_VIAGEM = ?";
	    	
	 
	    	
	    	try {
	    		Connection connection = DatabaseConnector.getConnection();
	    		PreparedStatement stmt = connection.prepareStatement(sql);
	    		
	    		stmt.setString(1, empresa.getNome());
	    		stmt.setLong(2, empresa.getCnpj());
	    		stmt.setString(3, empresa.getTipo());
	    		stmt.setString(4, empresa.getEndereco());
	    		stmt.setLong(5, empresa.getTelefone());
	    		stmt.setString(6, empresa.getEmail());
	    		stmt.setString(7, empresa.getStatus());
	            stmt.setLong(8, empresa.getId());
	            int rowsAffected = stmt.executeUpdate();
	            
	            if (rowsAffected > 0) {
	            	System.out.println("Alteração na empresa " + empresa.getId() + " realizada com sucesso");
	            } else {
	            	System.out.println("Nenhuma atualização realizada");
	            }
	            
	        } catch (SQLException e) {

	            e.printStackTrace();

	        }
	    }
}
