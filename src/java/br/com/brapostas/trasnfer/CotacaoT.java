/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.brapostas.trasnfer;

/**
 *
 * @author Leo Souza
 */
public class CotacaoT {
    String nome, descricao;
    int id_tipoCot;
    int id_confronto;
    double valor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
    public int getId_tipoCot() {
        return id_tipoCot;
    }

    public void setId_tipoCot(int id_tipoCot) {
        this.id_tipoCot = id_tipoCot;
    }

    public int getId_confronto() {
        return id_confronto;
    }

    public void setId_confronto(int id_confronto) {
        this.id_confronto = id_confronto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
