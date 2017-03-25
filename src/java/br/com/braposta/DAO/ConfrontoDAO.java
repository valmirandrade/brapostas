/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.braposta.DAO;


import br.com.brapostas.trasnfer.ConfrontoT;
import br.com.brapostas.trasnfer.CotacaoT;
import br.com.brapostas.trasnfer.TipoCotacaoT;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author valmir
 */
public class ConfrontoDAO {

    private Connection con;

    public ConfrontoDAO(Connection con) {
        this.con = con;
    }

    public void insert(ConfrontoT confrontoT) throws Exception {

        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO public.confrontos(cod_confronto, cod_camp, cod_time_casa, cod_time_fora,data_inicio) values"
                    + "(?, ?, ?, ?, ?, ?, ?, ?, ?);";
            ps.clearParameters();
            ps = con.prepareStatement(sql);
            //extrai o objeto da lista e em seguida seu valor
            ps.setInt(1, confrontoT.getCod_confronto());
            ps.setInt(2, confrontoT.getCod_camp());
            ps.setInt(3, confrontoT.getTime_casa());
            ps.setInt(4, confrontoT.getTime_fora());
            ps.setDate(5, confrontoT.getInicio());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } // encerando o PreparedStatment e a conexão.
        finally {

            try {
                ps.close();
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

    public void update() {

    }

    public void delete() {

    }

    private List<ConfrontoT> rsToList(ResultSet rs) throws Exception {
        List<ConfrontoT> list = new ArrayList<>();
        List<CotacaoT> cotacoes = new ArrayList<>();
        while (rs.next()) {
            ConfrontoT confrontoT = new ConfrontoT();
            confrontoT.setCod_confronto(rs.getInt("cod_confronto"));
            confrontoT.setCod_camp(rs.getInt("cod_camp"));
            confrontoT.setTime_casa(rs.getInt("cod_time_casa"));
            confrontoT.setGol_fora(rs.getInt("cod_time_fora"));
            confrontoT.setGol_casa(rs.getInt("gol_casa"));
            confrontoT.setTime_fora(rs.getInt("gol_fora"));
            confrontoT.setValido(rs.getBoolean("valido"));
            confrontoT.setFim(rs.getBoolean("fim"));
            confrontoT.setInicio(rs.getDate("data_inicio"));
            confrontoT.setNm_time_casa(getNomeTime(rs.getInt("cod_time_casa")));
            confrontoT.setNm_time_fora(getNomeTime(rs.getInt("cod_time_fora")));
            cotacoes = getAllCotacoes(rs.getInt("cod_confronto"));
            confrontoT.setCotacoes(cotacoes);
            list.add(confrontoT);
        }
        return list;
    }

    public List<ConfrontoT> getAll() throws Exception {
        String sql = "select * from confrontos";
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

    private List<CotacaoT> rsToListCotacoes(ResultSet rs) throws Exception {
        List<CotacaoT> list = new ArrayList<CotacaoT>();
        while (rs.next()) {
            CotacaoT cotacaoT = new CotacaoT();
            cotacaoT.setId_confronto(rs.getInt("cod_confronto_fk"));
            cotacaoT.setId_tipoCot(rs.getInt("id_tipo_cota_fk"));
            cotacaoT.setValor(rs.getDouble("valor"));
            list.add(cotacaoT);
        }
        return list;
    }

    public List<CotacaoT> getAllCotacoes(int cod_confronto) throws Exception {
        String sql = "select * from cotacao where cod_confronto_fk=?";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.clearParameters();
            //extrai o objeto da lista e em seguida seu valor
            ps.setInt(1, cod_confronto);
            rs = ps.executeQuery();
            return rsToListCotacoes(rs);
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
    
    private TipoCotacaoT getTipoCotacao(int codTipo) throws Exception{
        TipoCotacaoT tipoCotacaoT = new TipoCotacaoT();
        String sql = "select * from tipo_cotacoes where id_tipo_cota=?";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, codTipo);
            rs = ps.executeQuery();
            if(rs.next()){
                tipoCotacaoT.setId_tipoCot(rs.getInt("id_tipo_cota"));
                tipoCotacaoT.setNome(rs.getString("nome"));
                tipoCotacaoT.setDescricao(rs.getString("descricao"));
            }
            return tipoCotacaoT;
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
    
    private String getNomeTime(int codTime) throws Exception{
        String nome = "";
        String sql = "select * from times where cod_time=?";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, codTime);
            rs = ps.executeQuery();
            if(rs.next()){
                nome = rs.getString("nome");
            }
            return nome;
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

    public double pegarCotacaoString(String cotacao, int cod) throws Exception{
        double cot = 0;
        String sql = "select * from cotacao c, tipo_cotacoes t where c.cod_confronto_fk=? and t.nome=? and c.id_tipo_cota_fk=t.id_tipo_cota";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cod);
            ps.setString(2, cotacao);
            rs = ps.executeQuery();
            if(rs.next()){
                cot = rs.getDouble("valor");
            }
            return cot;
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

    public String descricaoCotacao(CotacaoT cotacao) throws Exception {
        String descricao = "";
        String sql = "select * from tipo_cotacoes where id_tipo_cota=? ";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cotacao.getId_tipoCot());
            rs = ps.executeQuery();
            if(rs.next()){
                descricao = rs.getString("nome");
            }
            return descricao;
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
