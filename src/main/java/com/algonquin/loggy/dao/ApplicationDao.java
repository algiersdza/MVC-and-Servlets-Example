package com.algonquin.loggy.dao;

import com.algonquin.loggy.beans.Log;
import com.algonquin.loggy.beans.LogBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationDao {
    private final static String SELECT_ALL_SQL = "SELECT * FROM loggy.log;";
    private final static String SELECT_BY_ID_SQL = "SELECT UuID,Title,Content,CreateTimestamp,FileType FROM loggy.log WHERE UuID = ?;";
    private final static String INSERT_INTO_SQL = "INSERT INTO loggy.log (UuID, Title, Content, CreateTimestamp,FileType)" +
            "VALUES (?, ?, ?, ?,?);";
    private final static String INSERT_INTO_BY_ID_SQL = "UPDATE loggy.log SET Title = ?, Content = ? WHERE UuID = ?;";
    private final static String DELETE_WHERE_ID_SQL = "DELETE FROM loggy.log WHERE UuID = ?;";


    //methods for servlets to pass info into and out of DB

    public List<Log> selectAllLogs() {
        List<Log> logs = new ArrayList<>();
        try (Connection singleCon = DBConnection.getSingleCon();
             PreparedStatement preparedStatement = singleCon.prepareStatement(SELECT_ALL_SQL)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String id = rs.getString("UuID");
                String title = rs.getString("Title");
                String content = rs.getString("Content");
                String createTimestamp = rs.getString("CreateTimestamp");
                String file = rs.getString("FileType");
                logs.add(new LogBuilder().setDummyUuid(id).setTitle(title).setContent(content).setCreateTimestamp(createTimestamp).setFileType(file).createLog());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return logs;
    }

    public Log getSingleLog(String uid) {
        Log record = null;
        try (Connection singleCon = DBConnection.getSingleCon();
             PreparedStatement preparedStatement = singleCon.prepareStatement(SELECT_BY_ID_SQL)) {
            preparedStatement.setString(1, uid);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String id = rs.getString("UuID");
                String title = rs.getString("Title");
                String content = rs.getString("Content");
                String time = rs.getString("CreateTimestamp");
                String file = rs.getString("FileType");
                record = new LogBuilder().setDummyUuid(id).setTitle(title).setContent(content).setCreateTimestamp(time).setFileType(file).createLog();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return record;
    }


    public int addLog(Log log) throws SQLException {
        int result = 0;
        try (Connection singleCon = DBConnection.getSingleCon();
             PreparedStatement preparedStatement = singleCon.prepareStatement(INSERT_INTO_SQL)) {
            preparedStatement.setString(1, log.getUuid());
            preparedStatement.setString(2, log.getTitle());
            preparedStatement.setString(3, log.getContent());
            preparedStatement.setString(4, log.getCreateTimestamp());
            preparedStatement.setString(5,log.getFileType());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void updateLog(Log log) throws SQLException {
        try (Connection singleCon = DBConnection.getSingleCon();
             PreparedStatement preparedStatement = singleCon.prepareStatement(INSERT_INTO_BY_ID_SQL)) {
//            System.out.println("*TEST* updated log:"+log.getUuid()+" "+log.getTitle()+" "+log.getCreateTimestamp());
            preparedStatement.setString(1, log.getTitle());
            preparedStatement.setString(2, log.getContent());
            preparedStatement.setString(3, log.getUuid());
            preparedStatement.executeUpdate();
        }
    }

    public void deleteLog(String uid) throws SQLException {
        try (Connection singleCon = DBConnection.getSingleCon();
             PreparedStatement preparedStatement = singleCon.prepareStatement(DELETE_WHERE_ID_SQL)) {
            preparedStatement.setString(1, uid);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}