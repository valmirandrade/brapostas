/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.braposta.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mayara
 */
public class CampeonatoDAO {
    ResultSet rs;
    PreparedStatement ps;
   
    private HashMap<String, Integer> rsToHash(ResultSet rs) throws Exception {
        HashMap<String, Integer> map = new HashMap<>();
        while (rs.next()) {
            map.put(rs.getString("nome_campeonato"), rs.getInt("cod_campeonato"));
        }
        return map;
    }
    
    public HashMap<String, Integer> consultarTodos () throws Exception{
        String sql ="select nome_campeonato, cod_campeonato from campeonatos";
          BusinessBase b = new BusinessBase();
           Connection con= b.getConnection();
        try {
            ps = con.prepareStatement(sql);
             rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(CampeonatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rsToHash(rs);
}
}