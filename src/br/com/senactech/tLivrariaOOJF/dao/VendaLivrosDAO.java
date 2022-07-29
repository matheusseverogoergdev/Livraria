/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senactech.tLivrariaOOJF.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import br.com.senactech.tLivrariaOOJF.conexao.Conexao;
import br.com.senactech.tLivrariaOOJF.model.VendaLivro;

/**
 *
 * @author USUARIO
 */
public class VendaLivrosDAO {
    public void cadastrarVenda(VendaLivro vlLO) throws SQLException {
        Connection con = Conexao.getConexao();
        
        try {
            PreparedStatement pStat = con.prepareStatement("INSERT INTO compra VALUES"
                    + " (null, ?, ?, ?, ?, ?)");
            
            java.util.Date data = vlLO.getDataVenda();  
            java.sql.Date dataSql = new java.sql.Date(data.getTime());
            
            pStat.setDate(1, dataSql);
            pStat.setInt(2, vlLO.getQtd());
            pStat.setFloat(3, vlLO.getSubTotal());
            pStat.setFloat(4, vlLO.getIdCliente());
            pStat.setFloat(5, vlLO.getIdLivro());
            pStat.executeUpdate();
        } catch(SQLException ex) {
            throw new SQLException("Erro ao inserir a compra do livro!\n" + ex.getMessage());
        } finally {
            con.close();
        }   
    }
    
    public ArrayList<VendaLivro> buscarVendas() throws SQLException {
        Connection con = Conexao.getConexao();
        
        try {
            PreparedStatement pStat = con.prepareStatement("SELECT * FROM compra");
            ResultSet rsPStat = pStat.executeQuery();
            
            ArrayList<VendaLivro> vendas = new ArrayList<>();
            while(rsPStat.next()) {
                VendaLivro v = new VendaLivro();
                
                java.sql.Date dataSql = rsPStat.getDate("dataCompra");
                java.util.Date data =  new java.util.Date(dataSql);
                
                v.setDataVenda(rsPStat.getDate());
            }
        } catch() {
        
        } finally {
        
        }
        
    }
    
    public void atualizarEstoque(VendaLivro vlVO, int quantidadeEstoque) throws SQLException {
        Connection con = Conexao.getConexao();
        
        try {
            PreparedStatement pStat = con.prepareStatement("UPDATE compra SET "
                    + "dataCompra = ?, quantidadeCompra = ?, subTotal");
        } catch(SQLException e) {
            throw new SQLException("Erro ao atualizar as Compras. \n"
                + e.getMessage());
        } finally {
            con.close();
        }
    }
}
