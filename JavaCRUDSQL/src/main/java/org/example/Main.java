package org.example;

import org.example.config.DatabaseConfig;
import org.example.dao.PessoaDao;
import org.example.dao.PessoaDaoImpl;
import org.example.entities.Pessoa;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DatabaseConfig dbConfig = new DatabaseConfig("x", "x", "x");

        try (Connection connection = dbConfig.getConnection()) {
            PessoaDao pessoaDao = new PessoaDaoImpl(connection);

            // 1. Criar uma nova pessoa
            Pessoa novaPessoa = new Pessoa(1L, "Ana", 20);
            pessoaDao.create(novaPessoa);
            System.out.println("Pessoa criada: " + novaPessoa);

            // 2. Ler todas as pessoas
            List<Pessoa> pessoas = pessoaDao.readAll();
            System.out.println("Pessoas cadastradas: " + pessoas);

            // 3. Atualizar a pessoa
            novaPessoa.setName("Ana Maria");
            pessoaDao.update(novaPessoa);
            System.out.println("Pessoa atualizada: " + novaPessoa);

            // 4. Ler todas as pessoas após a atualização
            pessoas = pessoaDao.readAll();
            System.out.println("Pessoas após atualização: " + pessoas);

            // 5. Deletar a pessoa
            pessoaDao.delete(novaPessoa.getId());
            System.out.println("Pessoa deletada: " + novaPessoa.getId());

            // 6. Ler todas as pessoas após a exclusão
            pessoas = pessoaDao.readAll();
            System.out.println("Pessoas após exclusão: " + pessoas);

        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        } catch (RuntimeException e) {
            System.err.println("Erro na operação: " + e.getMessage());
        }
    }
}
