/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.braposta.BO;

import br.com.braposta.DAO.ApostaDAO;
import br.com.braposta.DAO.BusinessBase;
import br.com.brapostas.trasnfer.ApostaT;
import br.com.brapostas.trasnfer.PalpiteT;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author valmir
 */
public class ApostaBO  extends BusinessBase{
   
    
//metodo cadastrar deve ser passado um objeto aposta e uma lista de objetos palpite
    public void cadastrar(ApostaT apostaT, List<PalpiteT> palpites) throws Exception{
      //algumas validações dos dados
        //se o bilhete esta sem nome
        if(apostaT.getN_apostador()!=null){
            //se não existem palpites
        if(palpites.isEmpty()){
           //retornar uma msg solicitando inclusão de palpites
       }else
            //se existe mais de um registro de palpite
        if(palpites.get(2)==null){
            // solicitar incusão de pelomenos dois palpites
        }else{  
          // se as situações anteriores não ocorreram então pega uma conexão e passa o objeto para o DAO
        Connection con;
        try {  
            con = getConnection();
            ApostaDAO apostaDAO = new  ApostaDAO(con);
            apostaDAO.insert(apostaT,palpites);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            closeCon(); // encerra a conexão mesmo que ocorra algum problema no DAO
        }  
        }
    }else{
          
          //solicitar nome do cliente                                                                                                                                                                                                                                                                                                                                                                                                 
      }
    
    }
}
