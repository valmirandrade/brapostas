/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.braposta.DAO;

import br.com.brapostas.trasnfer.ApostaT;
import br.com.brapostas.trasnfer.PalpiteT;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author valmi
 */
public class ApostaDAO {
   
     private Connection con;

     
    public ApostaDAO(Connection con) {
        this.con = con;
    }
    
    
   public void insert(ApostaT apostaT,List<PalpiteT> palpiteT) throws Exception{
       
        Statement ps = null;
        PreparedStatement rs = null;
        try {
              String sql = "select cad_aposta("+apostaT.getMat()+","+apostaT.getN_apostador()+","+apostaT.getVl_aposta()+");";
              rs= con.prepareStatement(sql);
              //a função execulta no banco e retorna o numero da aposta que foi criado
              ResultSet ex = rs.executeQuery();
              ex.next();
               int aposta = ex.getInt(1);
              String sql2= "INSERT INTO public.palpites( cod_aposta,"
                      + " id_tipo_cota, cod_confronto)"
                      + "VALUES (?, ?, ?);";   
              for(int count=0;count<=palpiteT.size();count++ ){
              rs.clearParameters();
              rs=con.prepareStatement(sql2);
              //extrai o objeto da lista e em seguida seu valor
              rs.setInt(1,aposta);
              rs.setInt(2, palpiteT.get(count).getCotacao());
              rs.setInt(3, palpiteT.get(count).getCod_confronto());
              rs.execute();
              }
   
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } 
        // encerando o Statment/PreparedStatment e a conexão.
        finally {
          
            try {
                ps.close();
                rs.close();
            } catch (Exception e) {
                  e.printStackTrace();
              throw e;
            }
            try {
                con.close();
            } catch (Exception e) {
                 e.printStackTrace();
              throw e;
            }
        } 
     
   }
   
       private List<ApostaT> rsToList(ResultSet rs) throws Exception {
        List<ApostaT> list = new ArrayList<ApostaT>();
        while (rs.next()) {
            ApostaT apostaT = new ApostaT();
            apostaT.setCod(rs.getInt("cod_aposta"));
            apostaT.setValida(rs.getBoolean("valida"));
            apostaT.setMat(rs.getInt("matricula_vend"));
            apostaT.setN_apostador(rs.getString("nome_cliente"));
            apostaT.setVl_aposta(rs.getDouble("vl_aposta"));
            apostaT.setVl_premio(rs.getInt("proprietario"));
            list.add(apostaT);
        }
        return list;
    }

      
    public List<ApostaT> getAll() throws Exception {
        String sql = "select * from aposta;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            return rsToList(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
            }
            try {
                ps.close();
            } catch (Exception e) {
            }
        }
    }
     
   
    
}
