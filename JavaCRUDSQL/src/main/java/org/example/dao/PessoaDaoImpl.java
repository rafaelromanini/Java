package org.example.dao;

import org.example.entities.Pessoa;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaDaoImpl implements PessoaDao {

    private final Connection connection;

    public PessoaDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Pessoa pessoa)  {
        String sql = "insert into pessoa_1tdspz(id,name,idade) values(?,?,?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, pessoa.getId());
            pstmt.setString(2, pessoa.getName());
            pstmt.setInt(3, pessoa.getIdade());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            //TODO
            e.printStackTrace();
            throw new RuntimeException("Não foi possível realizar essa operação");
        }
    }

    @Override
    public List<Pessoa> readAll(){
        List<Pessoa> result = new ArrayList<>();
        String sql = "select * from pessoa_1tdspz";
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                int idade = rs.getInt("idade");
                result.add(new Pessoa(id, name, idade));
            }
        } catch (SQLException e){
            //TODO
        }
        return result;
    }

    @Override
    public void update(Pessoa pessoa) {
        String sql = "update pessoa_1tdspz set name=?, idade=? where id=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, pessoa.getName());
            pstmt.setInt(2,pessoa.getIdade());
            pstmt.setLong(3,pessoa.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            //TODO
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "delete from pessoa_1tdspz where id=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1,id);
            pstmt.executeUpdate();
            dummyException();
        }  catch (IOException | SQLException e) {
            //TODO
        }
    }

    private void dummyException() throws IOException {
        throw new IOException();
    }

}
