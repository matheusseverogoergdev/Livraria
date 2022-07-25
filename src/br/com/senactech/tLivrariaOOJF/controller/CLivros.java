/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senactech.tLivrariaOOJF.controller;

import java.util.ArrayList;
import br.com.senactech.tLivrariaOOJF.model.Livro;

/**
 *
 * @author jairb
 */
public class CLivros {

    ArrayList<Livro> livros = new ArrayList<>();
    int idLiv = 1;
    
    public int addIdLiv(){
        return this.idLiv++;
    }

    public void addLivro(Livro l) {
        this.livros.add(l);
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public Boolean verificaLivro(int idLivro) {
        boolean verLivro = false;
        for (Livro livro1 : livros) {
            if (livro1.getIdLivro() == idLivro) {
                verLivro = true;
                System.out.println("Livro: " + livro1.getTitulo());
            }
        }
        return verLivro;
    }

    public Boolean verEstoqueLivro(int idLivro, int qtd) {
        boolean verEstoqueLivro = false;
        for (Livro Estoqueliv : livros) {
            if (Estoqueliv.getIdLivro() == idLivro && Estoqueliv.getEstoque() >= qtd) {
                verEstoqueLivro = true;
            } else if (Estoqueliv.getIdLivro() == idLivro) {
                System.out.println("Estoque atual: " + Estoqueliv.getEstoque());
            }
        }
        return verEstoqueLivro;
    }

    public void atualizaEstoqueLivro(int idLivro, int qtd) {
        for (Livro upEstoqueLivro : livros) {
            if (upEstoqueLivro.getIdLivro() == idLivro) {
                int upEstoque = upEstoqueLivro.getEstoque() - qtd;
                upEstoqueLivro.setEstoque(upEstoque);
                System.out.println("Estoque novo: " + upEstoqueLivro.getEstoque());
            }
        }
    }

    public float verPrecoLivro(int idLivro) {
        float preco = 0;
        for (Livro prLivro : livros) {
            if (prLivro.getIdLivro() == idLivro) {
                preco = prLivro.getPreco();
            }
        }
        return preco;
    }

    public int verEstoque(int idLivro) {
        int estoqueAtual = 0;
        for (Livro prLivro : livros) {
            if (prLivro.getIdLivro() == idLivro) {
                estoqueAtual = prLivro.getEstoque();
            }
        }
        return estoqueAtual;
    }

}
