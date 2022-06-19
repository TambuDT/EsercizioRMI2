package com.company;

import java.io.Serializable;

public class Contatto implements Serializable {
    private int numero;
    private String nome=new String();

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    public Contatto(int numero, String nome){
        this.numero=numero;
        this.nome=nome;
    }
}
