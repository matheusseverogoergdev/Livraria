package br.com.senactech.tLivrariaOOJF.dao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import br.com.senactech.tLivrariaOOJF.conexao.Conexao;
import br.com.senactech.tLivrariaOOJF.model.Editora;

/**
 *
 * @author USUARIO
 */
public class EditorasDAO {
    public void cadastrarEditora(Editora eVO) throws SQLException {
        Connection con = Conexao.getConexao();
//        Statement stat = con.createStatement();
        
        try {
//            String sql;
//            sql = "INSERT INTO editora VALUES (null,'" + eVO.getNmEditora() + "',"
//                    + "'" + eVO.getEndereco() + "', '" + eVO.getTelefone() + "',"
//                    + "'" + eVO.getGerente() + "')";
//            stat.execute(sql);

            PreparedStatement pStat = con.prepareStatement("INSERT INTO editora VALUES "
                    + "(null, ?, ?, ?, ?)");
            pStat.setString(1, eVO.getNmEditora());
            pStat.setString(2, eVO.getEndereco());
            pStat.setString(3, eVO.getTelefone());
            pStat.setString(4, eVO.getGerente());
            pStat.executeQuery();

        } catch(Exception e) {
            throw new SQLException("Erro ao inserir Editora!\n" + e.getMessage());
        } finally {
//            stat.close();
            con.close();
        }
        
    }
    
    public ArrayList<Editora> buscarEditoras() throws SQLException {
        Connection con = Conexao.getConexao();
//        Statement stat = con.createStatement();
        
        try {
//            String sql;
//            sql = "SELECT * FROM editora";
//            ResultSet rs = stat.executeQuery(sql);

            PreparedStatement pStat = con.prepareStatement("SELECT * FROM editora");
            ResultSet rs = pStat.executeQuery();

            ArrayList<Editora> editoras = new ArrayList<>();
            while (rs.next()) {
                Editora e = new Editora();
                e.setIdEditora(rs.getInt("idEditora"));
                e.setNmEditora(rs.getString("nome"));
                e.setEndereco(rs.getString("endereco"));
                e.setTelefone(rs.getString("telefone"));
                e.setGerente(rs.getString("gerente"));
                editoras.add(e);
            }
            return editoras;
        } catch(SQLException e) {
            throw new SQLException("Erro ao buscar editoras!\n"
            + e.getMessage());
        } finally {
//            stat.close();
            con.close();
        }
        
    }
    
    public boolean verificaEditora(int id) throws SQLException {
        Connection con = Conexao.getConexao();
//        Statement stat = con.createStatement();
        boolean verificaEditora = false;
        
        try {
//            String sql;
//            sql = "SELECT idEditora FROM editoras WHERE idEditora = " +
//                    id;
//            ResultSet rs = stat.executeQuery(sql);

            PreparedStatement pStat = con.prepareStatement("SELECT idEditora"
                    + " FROM editora WHERE idEditora = ?");
            pStat.setInt(1, id);
            ResultSet rs = pStat.executeQuery();

            while(rs.next()) {
                verificaEditora = !rs.wasNull();
            }
        } catch(SQLException e) {
            throw new SQLException("Editora com este id não existe!\n"
            + e.getMessage());
        } finally {
//            stat.close();
            con.close();
        }
        return verificaEditora;
    }
    
    public void deletarEditora(int id) throws SQLException {
        Connection con = Conexao.getConexao();
//        Statement stat = con.createStatement();
        
        try {
//            String sql;
//            sql = "DELETE FROM editora WHERE idEditora = " + id;
//            stat.execute(sql);

            PreparedStatement pStat = con.prepareStatement("DELETE FROM editora "
                    + "WHERE idEditora = ?");
            pStat.setInt(1, id);
            pStat.executeQuery();

        } catch(SQLException e) {
            throw new SQLException("Erro ao deletar Editora. \n"
                + e.getMessage());
        } finally {
//            stat.close();
            con.close();
        }
    }
    
    public void atualizarEditora(Editora eVO) throws SQLException {
        Connection con = Conexao.getConexao();
//        Statement stat = con.createStatement();
        
        try {
//            String sql;
//            sql = "UPDATE editora SET "
//                    + "idEditora = " + eVO.getIdEditora() + ", "
//                    + "nome = '" + eVO.getNmEditora() + "', "
//                    + "endereco = '" + eVO.getEndereco() + "', "
//                    + "telefone = '" + eVO.getTelefone() + "', "
//                    + "gerente = '" + eVO.getGerente() + "'";
//            stat.executeUpdate(sql);

            PreparedStatement pStat = con.prepareStatement("UPDATE editora SET "
                    + "idEditora = ?, "
                    + "nome = ?, "
                    + "endereco = ?, "
                    + "telefone = ?, "
                    + "gerente = ? ");
            pStat.setInt(1, eVO.getIdEditora());
            pStat.setString(2, eVO.getNmEditora());
            pStat.setString(3, eVO.getEndereco());
            pStat.setString(4, eVO.getTelefone());
            pStat.setString(5, eVO.getGerente());
            pStat.executeQuery();

        } catch(SQLException e) {
            throw new SQLException("Erro ao atualizar a Editora. \n"
                + e.getMessage());
        } finally {
//            stat.close();
            con.close();
        }
    }
    
}
