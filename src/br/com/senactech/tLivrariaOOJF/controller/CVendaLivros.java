/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senactech.tLivrariaOOJF.controller;

import java.util.ArrayList;
import br.com.senactech.tLivrariaOOJF.model.VendaLivro;

/**
 *
 * @author jairb
 */
public class CVendaLivros {
    ArrayList<VendaLivro> vendaLivros = new ArrayList<>();
    
    public void addVendaLivro(VendaLivro vl){
        vendaLivros.add(vl);
    }

    public ArrayList<VendaLivro> getVendaLivros() {
        return vendaLivros;
    }    
    
}
