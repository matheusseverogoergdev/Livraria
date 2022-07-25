/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senactech.tLivrariaOOJF.controller;

import java.util.ArrayList;
import br.com.senactech.tLivrariaOOJF.model.Editora;

/**
 *
 * @author jairb
 */
public class CEditoras {

    ArrayList<Editora> editora = new ArrayList<>();
    int idEdt = 1;

    public int addIdEdt() {
        return this.idEdt++;
    }

    public void addEditora(Editora e) {
        this.editora.add(e);
    }

    public ArrayList<Editora> getEditora() {
        return editora;
    }

    public Boolean verficaEditora(int idEditora) {
        Boolean verEditora = false;
        for (Editora edt : editora) {
            if (edt.getIdEditora() == idEditora) {
                verEditora = true;
                System.out.println("Editora: " + edt.getNmEditora());
            }
        }
        return verEditora;
    }
    
    public String getNomeEdt(int idEditora) {
        String nome = "";
        for (Editora edt : editora) {
            if (edt.getIdEditora() == idEditora) {
                nome = edt.getNmEditora();
                System.out.println("Editora: " + edt.getNmEditora());
            }
        }
        return nome;
    }

    public int getIdEditora(String nome) {
        int idEditora = 0;
        for (Editora edt : editora) {
            if (edt.getNmEditora().equals(nome)) {
                idEditora = edt.getIdEditora();
                System.out.println("Editora: " + edt.getNmEditora());
            }
        }
        return idEditora;
    }
}
