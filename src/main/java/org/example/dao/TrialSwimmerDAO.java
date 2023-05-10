package org.example.dao;

import org.example.Conections.ConnectionMySQL;
import org.example.Domain.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrialSwimmerDAO  implements DAO<trialSwimmer>{

    private final static String FINDALL ="SELECT * from trialswimmer";
    private final static String FINDBYID ="SELECT * from trialswimmer WHERE Id=?";
    private final static String INSERT ="INSERT INTO trialswimmer (Style,Id,Meters,Category,Pool_Type,Sex) VALUES (?,?,?,?,?,?)";
    private final static String UPDATE ="UPDATE trialswimmer SET Style=?, Id=?, Meters=?, Category=?, Pool_Type=?, Sex=? WHERE Id=?";

    private final static String DELETE ="DELETE from trialswimmer WHERE Id=?";

    private static Connection conn;

    public TrialSwimmerDAO() {
        this.conn= ConnectionMySQL.getConnect();
        if(this.conn==null){
            throw  new RuntimeException("Unable to establish connection to the database.");
        }
    }
    @Override
    public List<trialSwimmer> findAll() throws SQLException {
        List<trialSwimmer> result = new ArrayList();
        try(PreparedStatement pst=this.conn.prepareStatement(FINDALL)){
            try(ResultSet res = pst.executeQuery()){
                while(res.next()) {
                    trialSwimmer T = new trialSwimmer();
                    T.setStyle(style.valueOf(style.valueOf(res.getString("Style")).toString()));
                    T.setMeters(Meters.valueOf(res.getString("Meters").toString()));
                    T.setCategory(category.valueOf(category.valueOf(res.getString("Category")).toString()));
                    T.setSex(SEX.valueOf(SEX.valueOf(res.getString("sex")).toString()));
                    T.setId(res.getInt("Id"));
                    T.setPool_Type(pool_type.valueOf(pool_type.valueOf(res.getString("Pool_Type")).toString()));
                    result.add(T);
                }
            }
        }
        return result;
    }

    @Override
    public trialSwimmer findById(int Id) throws SQLException {
        trialSwimmer result = null;
        try(PreparedStatement pst=this.conn.prepareStatement(FINDBYID)){
            pst.setString(1, String.valueOf(Id));
            try(ResultSet res = pst.executeQuery()){
                if(res.next()) {
                    trialSwimmer T = new trialSwimmer();
                    T.setStyle(style.valueOf(res.getString("style").toString()));
                    T.setMeters(Meters.valueOf(res.getString("Meters").toString()));
                    T.setCategory(category.valueOf(res.getString("category").toString()));
                    T.setSex(SEX.valueOf(res.getString("SEX").toString()));
                    T.setId(res.getInt("Id"));
                    T.setPool_Type(pool_type.valueOf(res.getString("pool_type")));
                    result = T;
                }
            }
        }
        return result;
    }

    @Override
    public trialSwimmer save(trialSwimmer entity) throws SQLException {
        trialSwimmer result = new trialSwimmer();
        if(entity!=null) {


                try(PreparedStatement pst=this.conn.prepareStatement(INSERT)){
                    pst.setString(1, String.valueOf(entity.getStyle()).toString());
                    pst.setInt(2, entity.getId());
                    pst.setString(3, String.valueOf( entity.getMeters()).toString());
                    pst.setString(4, String.valueOf(entity.getCategory()).toString());
                    pst.setString(5, String.valueOf(entity.getPool_Type()).toString());
                    pst.setString(6,String.valueOf(entity.getSex()).toString());



                    pst.executeUpdate();
                }
            }else {
                //UPDATE

                try(PreparedStatement pst=this.conn.prepareStatement(UPDATE)){
                    pst.setString(1, String.valueOf(entity.getStyle()).toString());
                    pst.setInt(2, entity.getId());
                    pst.setString(3, String.valueOf( entity.getMeters()).toString());
                    pst.setString(4, String.valueOf(entity.getCategory()).toString());
                    pst.setString(5, String.valueOf(entity.getPool_Type()).toString());
                    pst.setString(6,String.valueOf(entity.getSex()).toString());
                    pst.executeUpdate();
                }

            result=entity;
        }
        return result;
    }

    @Override
    public void delete(trialSwimmer entity) throws SQLException {
        try (PreparedStatement pst = this.conn.prepareStatement(DELETE)) {
            pst.setInt(1, entity.getId());
            pst.executeUpdate();
        }
    }

    @Override
    public void close() throws Exception {

    }
}
