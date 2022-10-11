package br.com.hector.gerenciador.modelo;

import java.util.Date;

public class Empresa {

    private Integer id;
    private String nome;
    private Date dataAbertura = new Date();

    public Integer getId() {
        return this.id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataAbertura() {
        return this.dataAbertura;
    }
}
