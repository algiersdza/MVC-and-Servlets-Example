package com.algonquin.loggy.servlets;

import com.algonquin.loggy.dao.ApplicationDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteLogsServlet", value = "/DeleteLogsServlet")
public class DeleteLogsServlet extends HttpServlet {
    ApplicationDao applicationDao;

    public DeleteLogsServlet(){}

    @Override
    public void init(){
        applicationDao = new ApplicationDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uid = request.getParameter("id");
        try {
            applicationDao.deleteLog(uid);
            response.sendRedirect("user-page-logger.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
