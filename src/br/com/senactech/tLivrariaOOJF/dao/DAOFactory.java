/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senactech.tLivrariaOOJF.dao;

/**
 *
 * @author USUARIO
 */
public class DAOFactory {
    private static ClientesDAO clienteDAO = new ClientesDAO();
    private static EditorasDAO editoraDAO = new EditorasDAO();
    private static LivrosDAO livroDAO = new LivrosDAO();
    
    public static ClientesDAO getClienteDAO() {
        return clienteDAO;
    }
    
    public static EditorasDAO getEditoraDAO() {
        return editoraDAO;
    }
    
    public static LivrosDAO getLivroDAO() {
        return livroDAO;
    }
    
}
