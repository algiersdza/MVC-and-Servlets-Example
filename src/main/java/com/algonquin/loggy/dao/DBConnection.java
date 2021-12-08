package com.algonquin.loggy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // Database Schema
    // CREATE DATABASE loggy DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
    // CREATE TABLE logs (uuid CHAR(40) NOT NULL PRIMARY KEY, title CHAR(128),
    // content TEXT, createTimestamp Date);
    // content TEXT, createTimestamp Date);

//MYSQL dependent.
//user:root
//pass:CST2355Database
//CREATE SCHEMA if not exists loggy;
//    CREATE TABLE `log`(
//            `UuID` VARCHAR(40) COLLATE utf8_unicode_ci NOT NULL,
//    `Title` VARCHAR(60) COLLATE utf8_unicode_ci DEFAULT NULL,
//    `Content` VARCHAR (120) COLLATE utf8_unicode_ci,
//    `CreateTimestamp` VARCHAR(40) DEFAULT NULL,
//    `FileType` VARCHAR(64) DEFAULT NULL,
//    PRIMARY KEY (`UuID`))
//    ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
//
//    INSERT INTO loggy.log (UuID,Title,Content,CreateTimestamp,FileType)
//    VALUES ('aaaaaaaa-bbbb-cccc-dddd-111111111111', 'Initial submission','This is my first submission to the thread,
//    its a really nice assignment!',NULL,
//    'Initial Submission.txt');


    private static Connection singleCon = null;
    //    private static boolean initialized = false;
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/user?useSSL=false";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "CST2355Database";
    private DBConnection(){}


    public static Connection getSingleCon() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
//            initialized = true;
            singleCon = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return singleCon;
    }

}
