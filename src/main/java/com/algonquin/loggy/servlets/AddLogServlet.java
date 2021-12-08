package com.algonquin.loggy.servlets;

import com.algonquin.loggy.beans.Log;
import com.algonquin.loggy.beans.LogBuilder;
import com.algonquin.loggy.dao.ApplicationDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

@WebServlet(name = "AddLogServlet", value = "/AddLogServlet")
public class AddLogServlet extends HttpServlet {
    ApplicationDao applicationDao;

    public AddLogServlet(){}

    @Override
    public void init(){
        applicationDao = new ApplicationDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user-page-logger.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String Title = request.getParameter("Title");
        String Content = request.getParameter("Content");
        String Filetype = request.getParameter("FileType");
        int size = Title.length();
        if (Filetype.equals(".mp3") || Filetype.equals(".txt") || Filetype.equals(".mp4")){
            String nameWithType = Title.substring(0,size)+Filetype;
            String dummyUUID = UUID.randomUUID().toString();
            String time = new Date().toString();
            Log log = new LogBuilder().setDummyUuid(dummyUUID).setTitle(Title).setContent(Content).setCreateTimestamp(time).setFileType(nameWithType).createLog();
            try {
                applicationDao.addLog(log);
                response.sendRedirect("user-page-logger.jsp");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            Filetype = "No File Uploaded";
            String dummyUUID = UUID.randomUUID().toString();
            String time = new Date().toString();
            Log log = new LogBuilder().setDummyUuid(dummyUUID).setTitle(Title).setContent(Content).setCreateTimestamp(time).setFileType(Filetype).createLog();
            try {
                applicationDao.addLog(log);
                response.sendRedirect("user-page-logger.jsp");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
