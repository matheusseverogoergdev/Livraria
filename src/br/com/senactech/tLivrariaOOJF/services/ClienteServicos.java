/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senactech.tLivrariaOOJF.services;

import br.com.senactech.tLivrariaOOJF.dao.ClientesDAO;
import br.com.senactech.tLivrariaOOJF.dao.DAOFactory;
import br.com.senactech.tLivrariaOOJF.model.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class ClienteServicos {
    public void cadCliente(Cliente cVO) throws SQLException {
        ClientesDAO cDAO = DAOFactory.getClienteDAO();
        cDAO.cadastrarCliente(cVO);
    }
    
    public ArrayList<Cliente> getClientes() throws SQLException {
        ClientesDAO cDAO = DAOFactory.getClienteDAO();
        return cDAO.buscarClientes();
    }
    
    public boolean verificaCliente(int id) throws SQLException {
        ClientesDAO cDAO = DAOFactory.getClienteDAO();
        return cDAO.verificaCliente(id);
    }
    
    public void deletarCliente(int id) throws SQLException {
        ClientesDAO cDAO = DAOFactory.getClienteDAO();
        cDAO.deletarCliente(id);
    }
    
    public void atualizarCliente(Cliente cVO) throws SQLException {
        ClientesDAO cDAO = DAOFactory.getClienteDAO();
        cDAO.atualizarCliente(cVO);
    }
}
