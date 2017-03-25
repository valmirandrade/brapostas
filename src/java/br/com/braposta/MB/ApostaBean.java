/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.braposta.MB;

import br.com.braposta.BO.ConfrontoBO;
import br.com.brapostas.trasnfer.ConfrontoT;
import br.com.brapostas.trasnfer.CotacaoT;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Leo Souza
 */
@ManagedBean
@SessionScoped
public class ApostaBean implements Serializable{
    
    List<ConfrontoT> confrontos;
    List<ConfrontoT> aposta;
    List<CotacaoT> cots;

    public List<ConfrontoT> getAposta() {
        return aposta;
    }

    public void setAposta(List<ConfrontoT> aposta) {
        this.aposta = aposta;
    }

    public List<CotacaoT> getCots() {
        return cots;
    }

    public void setCots(List<CotacaoT> cots) {
        this.cots = cots;
    }
    
    public List<ConfrontoT> getConfrontos() {
        return confrontos;
    }

    public void setConfrontos(List<ConfrontoT> confrontos) {
        this.confrontos = confrontos;
    }
    
    public ApostaBean(){
        confrontos = new ArrayList<>();
        System.out.println("Entrou");
        ConfrontoBO confrontoBO = new ConfrontoBO();
        confrontos = confrontoBO.getAll();
        aposta = new ArrayList<>();
    }
    
    public List<CotacaoT> pegarCotacoes(ConfrontoT confronto){
        List<CotacaoT> lista = confronto.getCotacoes();
        return lista;
    }
    public double pegarCotacao(int tipoCota, int cod_confronto){
        double cot=0;
        ConfrontoT confronto = new ConfrontoT();
        for(ConfrontoT c : confrontos){
            if(cod_confronto == c.getCod_confronto()){
                confronto = c;
                break;
            }
        }
        //CotacaoT cotacao = new CotacaoT();
        for(CotacaoT ct : confronto.getCotacoes()){
            if(tipoCota == ct.getId_tipoCot()){
                cot = ct.getValor();
                break;
            }
        }
        return cot;
    }
    
    public void cotacoesModal(ConfrontoT confronto){
        cots = new ArrayList<>();
        for(CotacaoT c : pegarCotacoes(confronto)){
            if(c.getId_tipoCot() > 5){
                cots.add(c);
            }
        }
    }
    
    public String descricaoCotacao(CotacaoT cotacao){
        String descricao;
        ConfrontoBO confrontoBO = new ConfrontoBO();
        descricao = confrontoBO.descricaoCotacao(cotacao);
        return descricao;
    }
    
    public void adicionarPalpiteAposta(ConfrontoT confronto, double valor){
        System.out.println("Valor: "+valor);
        confronto.setValor(valor);
        aposta.add(confronto);
    }
    
    public void adicionarPalpiteModal(CotacaoT cotacao){
        ConfrontoT confronto = new ConfrontoT();
        System.out.println("ValorM: "+cotacao.getValor());
        for(ConfrontoT c : confrontos){
            if(cotacao.getId_confronto() == c.getCod_confronto()){
                confronto = c;
                break;
            }
        }
        confronto.setValor(cotacao.getValor());
        aposta.add(confronto);
    }
    
    public void removerPalpiteAposta(ConfrontoT confronto){
        aposta.remove(confronto);
    }
//    public double pegarCotacaoStringSQL(String cotacao, int cod_confronto){
//        double cot=0;
//        ConfrontoBO confrontoBO = new ConfrontoBO();
//        cot = confrontoBO.pegarCotacaoString(cotacao, cod_confronto);
//        return cot;
//    }
    
}
