/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.braposta.MB;

import br.com.braposta.BO.ConfrontoBO;
import br.com.brapostas.trasnfer.ConfrontoT;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author valmir
 */
@ManagedBean
@RequestScoped
public class AdministracaoMB extends ManagedBase {
    private List<ConfrontoT> list;
    private boolean verCadastro=false;
      private ConfrontoT confrontoT = new ConfrontoT();

    public ConfrontoT getConfrontoT() {
        return confrontoT;
    }

    public void setConfrontoT(ConfrontoT usuarioT) {
        this.confrontoT = usuarioT;
    }
    
    /**
     * Creates a new instance of consultarConfrontosMB
     */
    public AdministracaoMB() {
    }
    
    
    @PostConstruct
    public void pageLoad() {
        consultarTodos();
    } 

    public String novoAction() {
        verCadastro = true;
        return null;
    }
    
    public List<ConfrontoT> getList() {
        return list;
    }

    public void setList(List<ConfrontoT> list) {
        this.list = list;
    }
    
    
    public void consultarTodos() {
        try {
            list = new ConfrontoBO().consultarTodos();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String alterar(ConfrontoT confT){
        getRequest().setAttribute("confronto", confT);
        return "alterarCotas";

    }
    
   
    
    public boolean isVerCadastro() {
        return verCadastro;
    }  
    
    
      public void chooseCar() {
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", false);
        options.put("draggable", false);
        options.put("modal", true);
        RequestContext.getCurrentInstance().openDialog("alterarCotas", options, null);
    }
     
    public void onCarChosen(SelectEvent event) {
        ConfrontoT car = (ConfrontoT) event.getObject();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Car Selected", "Id:" + car.getTime_casa());
         
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
      public void viewCars(ConfrontoT confT) {
        getRequest().setAttribute("confronto", confT);
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", false);
        RequestContext.getCurrentInstance().openDialog("alterarCotas", options, null);
    } 
}
