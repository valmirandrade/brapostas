/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.braposta.BO;

import br.com.braposta.DAO.BusinessBase;
import br.com.braposta.DAO.ConfrontoDAO;
import br.com.brapostas.trasnfer.ConfrontoT;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author valmi
 */
public class ConfrontoBO extends BusinessBase{
    private Connection con;
   public void cadastrar (ConfrontoT confrontoT) throws Exception{ 
    
        try {  
            con = getConnection();
            ConfrontoDAO apostaDAO = new  ConfrontoDAO(con);
            apostaDAO.insert(confrontoT);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

}
       public List<ConfrontoT> consultarTodos() throws Exception {
           con=getConnection();
          return new ConfrontoDAO(con).getAll();
    }
}