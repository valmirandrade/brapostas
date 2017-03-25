/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.braposta.MB;

import br.com.braposta.BO.ConfrontoBO;
import br.com.braposta.DAO.CampeonatoDAO;
import br.com.brapostas.trasnfer.ConfrontoT;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.context.RequestContext;

/**
 * @author valmir
 */
@ManagedBean
@RequestScoped
public class AlterarCotasMB extends ManagedBase {
    private List<ConfrontoT> list;
    private List<ConfrontoT> campeonatos;
    private Map<String, Integer> filtros;
    String fil1;
    boolean fil2;
    String campeonato;
    
    /**
     * Creates a new instance of AlterarCotas
     */
    private ConfrontoT confrontoT = new ConfrontoT();

    @PostConstruct
    public void pageLoad() {
        filtros = new HashMap<String, Integer>();
        try {
            list = new ConfrontoBO().consultarTodos();
            filtros = new CampeonatoDAO().consultarTodos();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AlterarCotasMB() {

    }

    public String voltarAction() {
        return "administracao";
    }

    public ConfrontoT getConfrontoT() {
        return confrontoT;
    }

    public void setConfrontoT(ConfrontoT confrontoT) {
        this.confrontoT = confrontoT;
    }

    public List<ConfrontoT> getList() {
        return list;
    }

    public void setList(List<ConfrontoT> list) {
        this.list = list;
    }

    public Object rec() {
        getRequest().getAttribute("confronto");
        return getRequest().getAttribute("confronto");
    }

    public String alterar() {
        RequestContext.getCurrentInstance().openDialog("EditarCotacoes", null, null);
        return "EditarCotacoes";
    }

    public Map<String, Integer> getFiltros() {
        return filtros;
    }

    public void setFiltros(Map<String, Integer> filtros) {
        this.filtros = filtros;
    }

    public List<ConfrontoT> getCampeonatos() {
        return campeonatos;
    }

    

    public boolean isFil2() {
        return fil2;
    }

    public void setFil2(boolean fil2) {
        this.fil2 = fil2;
    }

    public String getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(String campeonato) {
        this.campeonato = campeonato;
    }

    public String getFil1() {
        return fil1;
    }

    public void setFil1(String fil1) {
        this.fil1 = fil1;
    }
    
    public void busca(){
        
    }
}
