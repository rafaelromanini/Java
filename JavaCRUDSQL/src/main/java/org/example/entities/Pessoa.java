package org.example.entities;

import java.io.IOException;

public class Pessoa {

    private Long id;
    private String name;
    private int idade;

    public Pessoa(Long id, String name, int idade) {
        this.id = id;
        this.name = name;
        setIdade(idade);
    }

    private boolean isMaiorIdade(int idade) {
        return idade >= 18;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if(isMaiorIdade(idade)){
            this.idade = idade;
        } else {
            throw new RuntimeException();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idade=" + idade +
                '}';
    }
}
