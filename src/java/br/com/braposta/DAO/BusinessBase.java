package br.com.braposta.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ERICA
 */
public class BusinessBase {

    private String dsName = "jdbc/brbanco";
    private Connection con;

    public Connection getConnection() {
        InitialContext ctx;
        try {
            ctx = new InitialContext();
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/brbanco");
            con = ds.getConnection();

        } catch (NamingException ex) {
            Logger.getLogger(BusinessBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BusinessBase.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con;
    }

    public void closeCon() {
        try {
            con.close();
        } catch (Exception e) {
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
        closeCon();
    }

}
