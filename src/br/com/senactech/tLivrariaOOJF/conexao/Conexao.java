/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senactech.tLivrariaOOJF.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author USUARIO
 */
public class Conexao {
    // cria uma constante com o endereço do DB e schema
    private static String url = "jdbc:mysql://localhost:3306/livrariajf";
    
    // cria uma constante com o user do DB
    private static String user = "root";
    
    // cria uma constante com a senha de acesso do DB
    private static String pass = "";
    
    public static Connection getConexao() throws SQLException{
        // iniciar conexão nula, ainda não estabelecida
        Connection c = null;
        try {
            c = DriverManager.getConnection(url, user, pass);
        // Caso haja falha na conexão gera uma Exceção
        } catch (Exception e) {
            throw new SQLException("Erro ao conectar! \n" + e.getMessage());
        }
        return c;
    }    
    
}
