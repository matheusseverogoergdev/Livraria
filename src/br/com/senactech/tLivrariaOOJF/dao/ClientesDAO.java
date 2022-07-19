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
import br.com.senactech.tLivrariaOOJF.model.Cliente;

/**
 *
 * @author USUARIO
 */
public class ClientesDAO {
    public void cadastrarCliente(Cliente cVO) throws SQLException {
        Connection con = Conexao.getConexao();
//        Statement stat = con.createStatement();
        
        try {
//            String sql;
//            sql = "INSERT INTO cliente VALUES (null,'" + cVO.getNomeCliente() + "',"
//                    + "'" + cVO.getCpf() + "', '" + cVO.getTelefone() + "',"
//                    + "'" + cVO.getEndereco() + "', '" + cVO.getCnpj() + "')";
//            stat.execute(sql);

            PreparedStatement pStat = con.prepareStatement("INSERT INTO cliente VALUES (null, ?, ?, ?, ?, ?)");
            pStat.setString(1, cVO.getNomeCliente());
            pStat.setString(2, cVO.getCpf());
            System.out.println(cVO.getTelefone());
            pStat.setString(3, cVO.getTelefone());
            pStat.setString(4, cVO.getEndereco());
            pStat.setString(5, cVO.getCnpj());
//            ResultSet rsPStat = pStat.executeQuery();
            pStat.executeUpdate();

        } catch(Exception e) {
            throw new SQLException("Erro ao inserir Cliente!\n" + e.getMessage());
        } finally {
            con.close();
        }
        
    }
    
    public ArrayList<Cliente> buscarClientes() throws SQLException {
        Connection con = Conexao.getConexao();
//        Statement stat = con.createStatement();
        
        try {
//            String sql;
//            sql = "SELECT * FROM cliente";
//            ResultSet rs = stat.executeQuery(sql);

            PreparedStatement pStat = con.prepareStatement("SELECT * FROM cliente");
            ResultSet rsPStat = pStat.executeQuery();

            ArrayList<Cliente> clientes = new ArrayList<>();
            while(rsPStat.next()) {
                Cliente c = new Cliente();
                c.setIdCliente(rsPStat.getInt("idCliente"));
                c.setNomeCliente(rsPStat.getString("nomeCliente"));
                c.setCpf(rsPStat.getString("cpf"));
                c.setTelefone(rsPStat.getString("telefone"));
                c.setEndereco(rsPStat.getString("endereco"));
                c.setCnpj(rsPStat.getString("cnpj"));
                clientes.add(c);
            }   
            return clientes;
        } catch(SQLException e) {
            throw new SQLException("Erro ao buscar clientes!\n"
            + e.getMessage());
        } finally {
//            stat.close();
            con.close();
        }
    }
    
    public boolean verCPF(String cpf) throws SQLException {
        Connection con = Conexao.getConexao();
        boolean verCPF = false;
        
        try {
            PreparedStatement sqlPS = con.prepareStatement("SELECT cpf FROM cliente WHERE cpf = ?");
            sqlPS.setString(1, cpf);
            ResultSet rsPS = sqlPS.executeQuery();
            while(rsPS.next()) {
                verCPF = !rsPS.wasNull();
            }
        } catch(SQLException e) {
            throw new SQLException("Pessoa com este CPF não existe!\n" +
                e.getMessage());
        } finally {
            con.close();
        }
        
        return verCPF;
    }
    
    public boolean verificaCliente(int idCliente) throws SQLException {
        Connection con = Conexao.getConexao();
//        Statement stat = con.createStatement();
        boolean verCliente = false;
        
        try {
//            String sql;
//            sql = "SELECT idCliente FROM cliente WHERE idCliente = " + 
//                    idCliente;
//            ResultSet rs = stat.executeQuery(sql);

            PreparedStatement pStat = con.prepareStatement("SELECT idCliente FROM cliente WHERE idCliente = ?");
            pStat.setInt(1, idCliente);
            ResultSet rs = pStat.executeQuery();

            while (rs.next()) {
                verCliente = !rs.wasNull();
            }
        } catch(Exception e) {
            throw new SQLException("Cliente com este id não existe!\n"
            + e.getMessage());
        } finally {
//            stat.close();
            con.close();
        }
        return verCliente;
    }
    
    public void deletarCliente(int id) throws SQLException {
        Connection con = Conexao.getConexao();
//        Statement stat = con.createStatement();
        
        try {
//            String sql;
//            sql = "DELETE FROM cliente WHERE idCliente = " + id;
//            stat.execute(sql);

            PreparedStatement pStat = con.prepareStatement("DELETE FROM cliente WHERE idCliente = ?");
            pStat.setInt(1, id);
            pStat.executeQuery();

        } catch(SQLException e) {
            throw new SQLException("Erro ao deletar Cliente. \n"
                + e.getMessage());
        } finally {
//            stat.close();
            con.close();
        }
    }
    
    public void atualizarCliente(Cliente cVO) throws SQLException {
        Connection con = Conexao.getConexao();
//        Statement stat = con.createStatement();
        
        try {
//            String sql;
//            sql = "UPDATE cliente SET "
//                    + "idCliente = " + cVO.getIdCliente() + ", "
//                    + "nomeCliente = '" + cVO.getNomeCliente() + "', "
//                    + "cpf = '" + cVO.getCpf() + "', "
//                    + "telefone = '" + cVO.getTelefone() + "', "
//                    + "endereco = '" + cVO.getEndereco() + "', "
//                    + "cnpj = '" + cVO.getCnpj() + "'";
//            stat.executeUpdate(sql);

            PreparedStatement pStat = con.prepareStatement("UPDATE cliente SET "
                    + "idCliente = ?," + " nomeCliente = ?," + " cpf = ?, "
                    + "telefone = ?," + " endereco = ?," + " cnpj = ?");
            pStat.setInt(1, cVO.getIdCliente());
            pStat.setString(2, cVO.getNomeCliente());
            pStat.setString(3, cVO.getCpf());
            pStat.setString(4, cVO.getTelefone());
            pStat.setString(5, cVO.getEndereco());
            pStat.setString(6, cVO.getCnpj());
            pStat.executeQuery();

        } catch(SQLException e) {
            throw new SQLException("Erro ao atualizar o Cliente. \n"
                + e.getMessage());
        } finally {
//            stat.close();
            con.close();
        }
        
    }
    
}
