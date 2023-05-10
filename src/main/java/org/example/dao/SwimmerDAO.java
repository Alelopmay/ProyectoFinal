package org.example.dao;

import org.example.Conections.ConnectionMySQL;
import org.example.Domain.SEX;
import org.example.Domain.swimmer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class SwimmerDAO implements DAO<swimmer> {

    private final static String FINDALL = "SELECT * from Swimmer";
    private final static String FINBYID = "SELECT * from Swimmer WHERE Cod_Swimmer=?";
    private final static String INSERT = "INSERT INTO swimmer (Cod_Swimmer,Last_Name,Name,Category,Age,Sex) VALUES (?,?,?,?,?,?)";
    private final static String UPDATE = "UPDATE Swimmer SET Name=?, Last_Name=?, Category=?, Age=?, Sex=? WHERE Cod_Swimmer=?";
    private final static String DELETE = "DELETE FROM Swimmer WHERE Cod_Swimmer = ?";


    public static Connection conn;

    public SwimmerDAO() {
        this.conn = ConnectionMySQL.getConnect();
        if (this.conn == null) {
            throw new RuntimeException("Unable to establish connection to the database.");
        }
    }




    @Override
    public List<swimmer> findAll() throws SQLException {
        List<swimmer> result =new ArrayList<>();
        try(PreparedStatement pst= this.conn.prepareStatement(FINDALL);){
            try(ResultSet res = pst.executeQuery();){
                while(res.next()){
                    swimmer S =new swimmer();
                    S.setCod_Swimmer(res.getInt("Cod_Swimmer"));
                    S.setCategory(res.getString("Category"));
                    S.setAge(res.getInt("Age"));
                    S.setName(res.getString("Name"));
                    S.setLast_Name(res.getString("Last_Name"));
                    S.setSex(SEX.valueOf(res.getString("Sex").toUpperCase()));

                }
            }
        }
        return result;
    }

    @Override
    public swimmer findById(int Cod_Swimmer) throws SQLException {
        swimmer result =new swimmer();
        try {
            if (conn != null) { // verifica si la conexión no es nula
                try(PreparedStatement pst= this.conn.prepareStatement(FINBYID);){
                    pst.setInt(1,Cod_Swimmer);
                    try(ResultSet res = pst.executeQuery();){
                        if(res.next()){
                            result = new swimmer();
                            result.setName(res.getString("Name"));
                            result.setAge(res.getInt(("Age")));
                            result.setCategory(res.getString("Category"));
                            result.setLast_Name(res.getString("Last_Name"));
                            result.setCod_Swimmer(res.getInt("Cod_Swimmer"));
                            result.getSex();
                        }
                    }
                }
            } else {
                throw new SQLException("La conexión a la base de datos es nula.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }



    @Override
    public swimmer save(swimmer entity) throws SQLException {

        swimmer result=new swimmer();
        if(entity!=null){
                    //INSERT
                    try(PreparedStatement pst= this.conn.prepareStatement(INSERT)){
                        pst.setInt(1, entity.getCod_Swimmer());
                        pst.setString(2, entity.getLast_Name());
                        pst.setString(3, entity.getName());
                        pst.setString(4, entity.getCategory());
                        pst.setInt(5, entity.getAge());
                        pst.setString(6, String.valueOf(entity.getSex()).toString());

                        pst.executeUpdate();
                    }
                }else{
                    try(PreparedStatement pst= this.conn.prepareStatement(UPDATE);){
                        pst.setInt(1, entity.getCod_Swimmer());
                        pst.setString(2, entity.getLast_Name());
                        pst.setString(3, entity.getName());
                        pst.setString(4, entity.getCategory());
                        pst.setInt(5, entity.getAge());
                        pst.setString(6, String.valueOf(entity.getSex()).toString());
                        pst.executeUpdate();
                    }
                }
        return entity;

        }




    @Override
    public void delete(swimmer entity) throws SQLException {
        if(entity!=null){
            try(PreparedStatement pst=this.conn.prepareStatement(DELETE)){
                pst.setInt(1,entity.getCod_Swimmer());
                pst.executeUpdate();
            }
        }
    }


    @Override
    public void close() throws Exception {

    }
}

