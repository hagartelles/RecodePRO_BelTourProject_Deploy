package beltourProjectWithSpz.controller;

import beltourProjectWithSpz.model.ClienteModel;
import beltourProjectWithSpz.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/save")
    public void save(@RequestBody ClienteModel clienteModel){
        clienteService.save(clienteModel);
    }

    @PatchMapping("/update")
    public void update(@RequestBody ClienteModel clienteModel){
        clienteService.update(clienteModel);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable(value = "id") int id){
        clienteService.deleteById(id);
    }

    @GetMapping("/find/{id}")
    public ClienteModel getClientById(@PathVariable(value = "id") int id){
        return clienteService.getClientById(id);
    }




}
