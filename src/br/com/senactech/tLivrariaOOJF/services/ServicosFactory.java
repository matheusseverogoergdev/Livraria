/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senactech.tLivrariaOOJF.services;

/**
 *
 * @author USUARIO
 */
public class ServicosFactory {
    private static ClienteServicos clienteServicos = new ClienteServicos();
    private static EditoraServicos editoraServicos = new EditoraServicos();
    private static LivroServicos livroServicos = new LivroServicos();
    
    public static ClienteServicos getClienteServicos() {
        return clienteServicos;
    }
    
    public static EditoraServicos getEditoraServicos() {
        return editoraServicos;
    }
    
    public static LivroServicos getLivroServicos() {
        return livroServicos;
    }
    
}
