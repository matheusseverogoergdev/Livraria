/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senactech.tLivrariaOOJF.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import br.com.senactech.tLivrariaOOJF.conexao.Conexao;
import br.com.senactech.tLivrariaOOJF.model.Livro;

/**
 *
 * @author USUARIO
 */
public class LivrosDAO {
    public void cadastrarLivro(Livro lVO) throws SQLException {
        Connection con = Conexao.getConexao();
        
        try {
            PreparedStatement pStat = con.prepareStatement("INSERT INTO livro VALUES"
                    + " (null, ?, ?, ?, ?, ?, ?, ?)");
            pStat.setString(1, lVO.getTitulo());
            pStat.setString(2, lVO.getAutor());
            pStat.setString(3, lVO.getAssunto());
            pStat.setString(4, lVO.getIsbn());
            pStat.setInt(5, lVO.getEstoque());
            pStat.setFloat(6, lVO.getPreco());
            pStat.setInt(7, lVO.getIdEditora());
            pStat.executeUpdate();
        } catch(SQLException e) {
            throw new SQLException("Erro ao inserir o Livro!\n" + e.getMessage());
        } finally {
            con.close();
        }
        
    }
    
    public ArrayList<Livro> buscarLivros() throws SQLException {
        Connection con = Conexao.getConexao();
        
        try {
            PreparedStatement pStat = con.prepareStatement("SELECT * FROM livro");
            ResultSet rsPStat = pStat.executeQuery();
            
            ArrayList<Livro> livros = new ArrayList<>();
            while(rsPStat.next()) {
                Livro l = new Livro();
                l.setIdLivro(rsPStat.getInt("idLivro"));
                l.setTitulo(rsPStat.getString("titulo"));
                l.setAutor(rsPStat.getString("autor"));
                l.setAssunto(rsPStat.getString("assunto"));
                l.setIsbn(rsPStat.getString("isbn"));
                l.setEstoque(rsPStat.getInt("estoque"));
                l.setPreco(rsPStat.getFloat("preco"));
                l.setIdEditora(rsPStat.getInt("idEditora"));
                livros.add(l);
            }
            return livros;
        } catch(SQLException e) {
            throw new SQLException("Erro ao buscar livros!\n"
            + e.getMessage());
        } finally {
            con.close();
        }
    }
    
    public boolean verificaLivro(String isbn) throws SQLException {
        Connection con = Conexao.getConexao();
        boolean verLivro = false;
        
        try {
            PreparedStatement pStat = con.prepareStatement("SELECT idLivro FROM livro WHERE isbn = ?");
            pStat.setString(1, isbn);
            ResultSet rs = pStat.executeQuery();
            
            while (rs.next()) {
                verLivro = !rs.wasNull();
            }
            
        } catch(SQLException e) {
            throw new SQLException("Livro com este ISBN não existe!\n"
            + e.getMessage());
        } finally {
            con.close();
        }
        return verLivro;
    }
    
    public Livro getByDoc(String isbn) throws SQLException {
        // Busca conexão com o BD
        Connection con = Conexao.getConexao();
        Livro l = new Livro();
        
        System.out.println("isbn: " + isbn);
        
        try {
            PreparedStatement sqlPS = con.prepareStatement("SELECT * FROM livro"
                    + " WHERE isbn = '" + isbn + "'");
            ResultSet rsPS = sqlPS.executeQuery();
            
            while (rsPS.next()) {
                System.out.println("idEditora: " + rsPS.getInt("idEditora"));
                
                l.setIdLivro(rsPS.getInt("idLivro"));
                l.setTitulo(rsPS.getString("titulo"));
                l.setAutor(rsPS.getString("autor"));
                l.setAssunto(rsPS.getString("assunto"));
                l.setIsbn(rsPS.getString("isbn"));
                l.setEstoque(rsPS.getInt("estoque"));
                l.setPreco(rsPS.getFloat("preco"));
                l.setIdEditora(rsPS.getInt("idEditora"));
            }
        } catch(SQLException ex) {
            throw new SQLException("Livro com este ISBN não existe!\n"
            + ex.getMessage());
        } finally {
            con.close();
        }
        
        return l;
    }
    
    public void deletarLivro(int id) throws SQLException {
        Connection con = Conexao.getConexao();
        
        try {
            PreparedStatement pStat = con.prepareStatement("DELETE FROM livro "
                    + "WHERE idLivro = ?");
            pStat.setInt(1, id);
            pStat.executeUpdate();
        } catch(SQLException e) {
            throw new SQLException("Erro ao deletar Livro. \n"
                + e.getMessage());
        } finally {
            con.close();
        }
        
    }
    
    public void atualizarLivro(Livro lVO) throws SQLException {
        Connection con = Conexao.getConexao();
        System.out.println("Con: " + con);
        try {
            PreparedStatement pStat = con.prepareStatement("UPDATE livro SET "
                        + "titulo = ?, autor = ?, assunto = ?, "
                        + "isbn = ?, estoque = ?, preco = ?, idEditora = ? "
                        + "WHERE idLivro = " + lVO.getIdLivro());
//            pStat.setInt(1, lVO.getIdLivro());

            pStat.setString(1, lVO.getTitulo());
            pStat.setString(2, lVO.getAutor());
            pStat.setString(3, lVO.getAssunto());
            pStat.setString(4, lVO.getIsbn());
            pStat.setInt(5, lVO.getEstoque());
            pStat.setFloat(6, lVO.getPreco());
            pStat.setInt(7, lVO.getIdEditora());
            
            System.out.println(pStat);
            
            pStat.executeUpdate();
        } catch(SQLException e) {
            throw new SQLException("Erro ao atualizar o Cliente. \n"
                + e.getMessage());
        } finally {
            con.close();
        }
    }
    
}
