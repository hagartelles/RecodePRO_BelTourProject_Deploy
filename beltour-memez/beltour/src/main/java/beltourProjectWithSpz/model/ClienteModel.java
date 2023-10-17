package beltourProjectWithSpz.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="CLIENTE")
public class ClienteModel {

    @Column(name = "ID_CLIENTE")
    @Id
    private int id;

    @Column(name ="CPF")
    private int cpf;

    @Column(name = "TELEFONE")
    private int telefone;

    @Column(name= "NOME_CLIENTE")
    private String nome;

    @Column(name ="ENDERECO")
    private String endereco;

    @Column(name ="EMAIL")
    private String email;

    @Column(name = "STATUS_CLIENTE")
    private String status;
}


