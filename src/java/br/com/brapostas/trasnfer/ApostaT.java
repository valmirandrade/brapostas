/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.brapostas.trasnfer;


/**
 *
 * @author valmi
 */
public class ApostaT {
   private int mat, cod;
   private double vl_aposta, vl_premio;
  private String n_apostador;
  boolean valida;

    public boolean isValida() {
        return valida;
    }

    public void setValida(boolean valida) {
        this.valida = valida;
    }
  
  

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
 
    public int getMat() {
        return mat;
    }

    public void setMat(int mat) {
        this.mat = mat;
    }

    public double getVl_aposta() {
        return vl_aposta;
    }

    public void setVl_aposta(double vl_aposta) {
        this.vl_aposta = vl_aposta;
    }

    public String getN_apostador() {
        return n_apostador;
    }

    public void setN_apostador(String n_apostador) {
        this.n_apostador = n_apostador;
    }

    public double getVl_premio() {
        return vl_premio;
    }  
    
    public void setVl_premio(double vl_premio){
        this.vl_premio= vl_premio;
    }
    
}
