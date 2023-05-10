package org.example.dao;

import org.example.Conections.ConnectionMySQL;
import org.example.Domain.MarkRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class markrecordDAO implements DAO<MarkRecord> {

    private final static String FINDALL ="SELECT * from MarkRecord";
    private final static String FINDBYID ="SELECT * from MarkRecord WHERE ID_MarkRecord=?";
    private final static String INSERT ="INSERT INTO MarkRecord (ID_MarkRecord,Id,Cod_Swimmer,Date_of_realization,Time) VALUES (?,?,?,?,?)";
    private final static String UPDATE ="UPDATE MarkRecord SET ID_Markrecord=?, ID=?, dni_autor=?, Cod_Swimmer=?, Date_of_realization=?, Time=? WHERE ID_MarkRecord=?";

    private final static String FINDBYAUTOR ="SELECT * from Markrecord WHERE ID_Markrecord=?";
    private final static String DELETE ="DELETE from Markrecord WHERE ID_Markrecord=?";

    private Connection conn;
    public markrecordDAO(Connection conn) {
        this.conn = conn;
    }
    public markrecordDAO() {
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
        return null;
    }

    @Override
    public void delete(MarkRecord entity) throws SQLException {

    }

    @Override
    public void close() throws Exception {

    }
}
