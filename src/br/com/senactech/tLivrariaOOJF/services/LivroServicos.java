/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senactech.tLivrariaOOJF.services;

import br.com.senactech.tLivrariaOOJF.dao.LivrosDAO;
import br.com.senactech.tLivrariaOOJF.dao.DAOFactory;
import br.com.senactech.tLivrariaOOJF.model.Livro;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class LivroServicos {
    public void cadLivro(Livro lVO) throws SQLException {
        LivrosDAO lDAO = DAOFactory.getLivroDAO();
        lDAO.cadastrarLivro(lVO);
    }
    
    public ArrayList<Livro> getLivros() throws SQLException {
        LivrosDAO lDAO = DAOFactory.getLivroDAO();
        return lDAO.buscarLivros();
    }
    
    public boolean verificaLivro(String isbn) throws SQLException {
        LivrosDAO lDAO = DAOFactory.getLivroDAO();
        return lDAO.verificaLivro(isbn);
    }
    
    public Livro buscarLivroBD(String isbn) throws SQLException {
        LivrosDAO lDAO = DAOFactory.getLivroDAO();
        return lDAO.getByDoc(isbn);
    }
    
    public void deletarLivro(int id) throws SQLException {
        LivrosDAO lDAO = DAOFactory.getLivroDAO();
        lDAO.deletarLivro(id);
    }
    
    public void atualizarLivro(Livro lVO) throws SQLException {
        LivrosDAO lDAO = DAOFactory.getLivroDAO();
        lDAO.atualizarLivro(lVO);
    }
}
