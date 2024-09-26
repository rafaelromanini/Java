package org.example.dao;

import org.example.entities.Pessoa;

import java.sql.SQLException;
import java.util.List;

public interface PessoaDao {

    void create(Pessoa pessoa);

    List<Pessoa> readAll();

    void update(Pessoa pessoa);

    void delete(Long id);
}
