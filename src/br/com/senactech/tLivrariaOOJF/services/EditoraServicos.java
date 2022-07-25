/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senactech.tLivrariaOOJF.services;

import br.com.senactech.tLivrariaOOJF.dao.EditorasDAO;
import br.com.senactech.tLivrariaOOJF.dao.DAOFactory;
import br.com.senactech.tLivrariaOOJF.model.Editora;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class EditoraServicos {
    public void cadEditora(Editora eVO) throws SQLException {
        EditorasDAO eDAO = DAOFactory.getEditoraDAO();
        eDAO.cadastrarEditora(eVO);
    }
    
    public ArrayList<Editora> getEditoras() throws SQLException {
        EditorasDAO eDAO = DAOFactory.getEditoraDAO();
        return eDAO.buscarEditoras();
    }
    
//    public Editora buscarEditora(int id) throws SQLException {
//        EditorasDAO eDAO = DAOFactory.getEditoraDAO();
//        return eDAO.buscarEditora(id);
//    }
    
    public Editora buscarEditora(String nome) throws SQLException {
        EditorasDAO eDAO = DAOFactory.getEditoraDAO();
        return eDAO.buscarEditora(nome);
    }
    
    public boolean verificaEditora(int id) throws SQLException {
        EditorasDAO eDAO = DAOFactory.getEditoraDAO();
        return eDAO.verificaEditora(id);
    }
    
    public void deletarEditora(int id) throws SQLException {
        EditorasDAO eDAO = DAOFactory.getEditoraDAO();
        eDAO.deletarEditora(id);
    }
    
    public void atualizarEditora(Editora eVO) throws SQLException {
        EditorasDAO eDAO = DAOFactory.getEditoraDAO();
        eDAO.atualizarEditora(eVO);
    }
    
    public String getNomeEditora(int id) throws SQLException {
        EditorasDAO eDAO = DAOFactory.getEditoraDAO();
        return eDAO.getNomeEditora(id);
    }
}
