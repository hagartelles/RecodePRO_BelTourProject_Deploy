package beltourProjectWithSpz.service;

import beltourProjectWithSpz.model.ClienteModel;
import beltourProjectWithSpz.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    public void save (ClienteModel clienteModel){
        clienteRepository.save(clienteModel);
    }
    public void update(ClienteModel clienteModel){
        clienteRepository.save(clienteModel);
    }

    public void deleteById(int id){
        clienteRepository.deleteById(id);
    }

    public ClienteModel getClientById(int id){
        return clienteRepository.findById(id).get();

    }

}

