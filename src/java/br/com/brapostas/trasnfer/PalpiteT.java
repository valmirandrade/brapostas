/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.brapostas.trasnfer;

/**
 *
 * @author valmir
 */
public class PalpiteT {
    int cod_confronto, cod,cotacao,cod_aposta;
    boolean valido;

    public boolean isValido() {
        return valido;
    }
    
    public int getCod_confronto() {
        return cod_confronto;
    }

    public void setCod_confronto(int cod_confronto) {
        this.cod_confronto = cod_confronto;
    }

    public int getCod() {
        return cod;
    }


    public int getCotacao() {
        return cotacao;
    }

    public void setCotacao(int cotacao) {
        this.cotacao = cotacao;
    }

    public int getCod_aposta() {
        return cod_aposta;
    }

    public void setCod_aposta(int cod_aposta) {
        this.cod_aposta = cod_aposta;
    }
 
}
