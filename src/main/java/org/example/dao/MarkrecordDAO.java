package org.example.dao;

import org.example.Conections.ConnectionMySQL;
import org.example.Domain.MarkRecord;
import org.example.Domain.Swimmer;
import org.example.Domain.TrialSwimmer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MarkrecordDAO implements DAO<MarkRecord> {

    private final static String FINDALL ="SELECT * from MarkRecord";
    private final static String FINDBYID ="SELECT * from MarkRecord WHERE ID_MarkRecord=?";
    private final static String INSERT ="INSERT INTO MarkRecord (ID_MarkRecord,Id,Cod_Swimmer,Date,Time) VALUES (?,?,?,?,?)";
    private final static String UPDATE ="UPDATE MarkRecord SET ID_Markrecord=?, ID=?, dni_autor=?, Cod_Swimmer=?, Date_of_realization=?, Time=? WHERE ID_MarkRecord=?";

    private final static String FINDBYAUTOR ="SELECT * from Markrecord WHERE ID_Markrecord=?";
    private final static String DELETE ="DELETE from Markrecord WHERE ID_Markrecord=?";

    private Connection conn;
    public MarkrecordDAO(Connection conn) {
        this.conn = conn;
    }
    public MarkrecordDAO() {
        this.conn=ConnectionMySQL.getConnect();
    }


    @Override
    public List<MarkRecord> findAll() throws SQLException {
        List<MarkRecord> result = new ArrayList();
        try(PreparedStatement pst=this.conn.prepareStatement(FINDALL)){
            try(ResultSet res = pst.executeQuery()){
                while(res.next()) {
                    MarkRecord M = new MarkRecord();
                    M.getCod_Swimmer();
                    M.getTime();



                }
            }
        }
        return result;

    }

    @Override
    public MarkRecord findById(int Cod_Swimmer) throws SQLException {
        return null;
    }

    @Override
    public MarkRecord save(MarkRecord entity) throws SQLException {
        if (entity != null) {
            // INSERT
            try (PreparedStatement pst = this.conn.prepareStatement(INSERT)) {
                pst.setInt(1, entity.getID_Marckrecord());
                pst.setInt(2, entity.getId().getId());
                pst.setInt(3, entity.getCod_Swimmer().getCod_Swimmer());
                pst.setDate(4, java.sql.Date.valueOf(entity.getDate())); // Convertir LocalDate a java.sql.Date
                pst.setString(5, entity.getTime());
                pst.executeUpdate();
            }
        } else {
            // UPDATE
            try (PreparedStatement pst = this.conn.prepareStatement(UPDATE)) {
                pst.setInt(1, entity.getID_Marckrecord());
                pst.setInt(2, entity.getId().getId());
                pst.setInt(3, entity.getCod_Swimmer().getCod_Swimmer());
                pst.setDate(4, java.sql.Date.valueOf(entity.getDate())); // Convertir LocalDate a java.sql.Date
                pst.setString(5, entity.getTime());
                pst.setInt(6, entity.getID_Marckrecord());
                pst.executeUpdate();
            }
        }
        return entity;
    }


    @Override
    public void delete(MarkRecord entity) throws SQLException {

    }

    @Override
    public Swimmer update(Swimmer entity) throws SQLException {
        return null;
    }

    @Override
    public TrialSwimmer update(TrialSwimmer entity) throws SQLException {
        return null;
    }

    @Override
    public void close() throws Exception {

    }
}
