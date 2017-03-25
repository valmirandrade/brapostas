/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.brapostas.trasnfer;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author valmir
 */
public class ConfrontoT {
    int cod_confronto, time_casa, time_fora,gol_casa, gol_fora, cod_camp;
    boolean valido,fim;
    String nome_time_casa, nome_time_fora;
    Date inicio;
    List<CotacaoT> cotacoes;
    
    double valor;

    public String getNome_time_casa() {
        return nome_time_casa;
    }

    public void setNome_time_casa(String nome_time_casa) {
        this.nome_time_casa = nome_time_casa;
    }

    public String getNome_time_fora() {
        return nome_time_fora;
    }

    public void setNome_time_fora(String nome_time_fora) {
        this.nome_time_fora = nome_time_fora;
    }
    

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    

    public List<CotacaoT> getCotacoes() {
        return cotacoes;
    }

    public void setCotacoes(List<CotacaoT> cotacoes) {
        this.cotacoes = cotacoes;
    }

    

    public int getCod_camp() {
        return cod_camp;
    }

    public void setCod_camp(int cod_camp) {
        this.cod_camp = cod_camp;
    }
    
    public int getCod_confronto() {
        return cod_confronto;
    }

    public void setCod_confronto(int cod_confronto) {
        this.cod_confronto = cod_confronto;
    }

    public int getTime_casa() {
        return time_casa;
    }

    public void setTime_casa(int time_casa) {
        this.time_casa = time_casa;
    }

    public int getTime_fora() {
        return time_fora;
    }

    public void setTime_fora(int time_fora) {
        this.time_fora = time_fora;
    }

    public int getGol_casa() {
        return gol_casa;
    }

    public void setGol_casa(int gol_casa) {
        this.gol_casa = gol_casa;
    }

    public int getGol_fora() {
        return gol_fora;
    }

    public void setGol_fora(int gol_fora) {
        this.gol_fora = gol_fora;
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    public boolean isFim() {
        return fim;
    }

    public void setFim(boolean fim) {
        this.fim = fim;
    }
    
    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }
}
