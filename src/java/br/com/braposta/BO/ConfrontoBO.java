/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.braposta.BO;

import br.com.braposta.DAO.BusinessBase;
import br.com.braposta.DAO.ConfrontoDAO;
import br.com.brapostas.trasnfer.ConfrontoT;
import br.com.brapostas.trasnfer.CotacaoT;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author valmi
 */
public class ConfrontoBO extends BusinessBase{
    private Connection con;
       public List<ConfrontoT> consultarTodos() throws Exception {
           con=getConnection();
          return new ConfrontoDAO(con).getAll();
    }
       
       public void cadastrar(ConfrontoT confrontoT) throws Exception {
        Connection con;
        try {
            con = getConnection();
            ConfrontoDAO apostaDAO = new ConfrontoDAO(con);
            apostaDAO.insert(confrontoT);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<ConfrontoT> getAll() {
        Connection con;
        List<ConfrontoT> confrontos = new ArrayList<>();
        try {
            BusinessBase bs = new BusinessBase();
            con = bs.getConnection();
            ConfrontoDAO confrontoDAO = new ConfrontoDAO(con);
            confrontos = confrontoDAO.getAll();
            return confrontos;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return confrontos;
    }

    public double pegarCotacaoString(String cotacao, int cod_confronto) {
        Connection con;
        double cot = 0;
        try {
            BusinessBase bs = new BusinessBase();
            con = bs.getConnection();
            ConfrontoDAO confrontoDAO = new ConfrontoDAO(con);
            cot = confrontoDAO.pegarCotacaoString(cotacao, cod_confronto);
            return cot;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return cot;
    }

    public String descricaoCotacao(CotacaoT cotacao) {
        Connection con;
        String descricao = "";
        try {
            BusinessBase bs = new BusinessBase();
            con = bs.getConnection();
            ConfrontoDAO confrontoDAO = new ConfrontoDAO(con);
            descricao = confrontoDAO.descricaoCotacao(cotacao);
            return descricao;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return descricao;
    }
}