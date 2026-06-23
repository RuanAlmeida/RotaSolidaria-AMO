/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import model.Pessoa;
import util.Conexao;

/**
 *
 * @author User
 */
public class PessoaDao {
    public void inserir (Pessoa pessoa) {
        String sql = "INSERT INTO pessoa (nome, sobrenome, nacionalidade) VALUES (?, ?, ?)";
        
        try (Connection conn  = Conexao.getConnection();
                PreparedStatement stmt = conn.prepareStatement (sql)){
            
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getSobrenome());
            stmt.setString(3, pessoa.getNacionalidade());
            
            stmt.executeUpdate();
            
        } catch (SQLException e){
            throw new RuntimeException("Erro ao cadastrar pessoa", e);
        }        
                
    }

    public List<Pessoa> listar(){
        List<Pessoa> lista = new ArrayList<>();
        String sql = "SELECT * FROM pessoa";
        
        try(Connection conn = Conexao.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()){
            
            while(rs.next()){
                Pessoa pessoa = new Pessoa(
                      rs.getInt("id"),
                      rs.getString("nome"),
                      rs.getString("sobrenome"),
                      rs.getString("nacionalidade")
              );
                lista.add(pessoa);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar pessoas", e);
            
        }
        return lista;
    }   
    

    
    public void atualizar(Pessoa pessoa){
        String sql = "UPDATE pessoa SET nome=?, sobrenome=?, nacionalidade=? WHERE id=?";
        
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getSobrenome());
            stmt.setString(3, pessoa.getNacionalidade());
            stmt.setInt(4, pessoa.getId());
            
            stmt.executeUpdate();
            
        } catch(SQLException e){
            throw new RuntimeException("Erro ao atualizar os dados da pessoa", e);
            
        }
    }
    
    public void excluir(int id){
        String sql = "DELETE FROM pessoa WHERE id=?";
        
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            
            stmt.setInt(1, id);
            stmt.executeUpdate();
            
        } catch (SQLException e){
            throw new RuntimeException("Erro ao excluir pessoa", e);
            
        }
        
    }
}
