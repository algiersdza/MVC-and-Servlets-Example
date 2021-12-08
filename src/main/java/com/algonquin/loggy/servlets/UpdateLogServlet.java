package com.algonquin.loggy.servlets;

import com.algonquin.loggy.beans.Log;
import com.algonquin.loggy.beans.LogBuilder;
import com.algonquin.loggy.dao.ApplicationDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UpdateLogServlet", value = "/UpdateLogServlet")
public class UpdateLogServlet extends HttpServlet {
    ApplicationDao applicationDao;
    Log log;
    public UpdateLogServlet(){}

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

        String title = request.getParameter("Title");
        String content = request.getParameter("Content");
        String id = request.getParameter("UUID");
        String time = request.getParameter("Time");
        String file = request.getParameter("FileType");
        log = new LogBuilder().setDummyUuid(id).setTitle(title).setContent(content).setCreateTimestamp(time).setFileType(file).createLog();

        try {
            applicationDao.updateLog(log);
            response.sendRedirect("user-page-logger.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
