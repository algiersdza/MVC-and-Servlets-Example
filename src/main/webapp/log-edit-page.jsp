<%@ page import="com.algonquin.loggy.dao.ApplicationDao" %>
<%@ page import="com.algonquin.loggy.beans.Log" %><%--
  Created by IntelliJ IDEA.
  User: Ibrahim Hermouche
  Date: 12/8/2021
  Time: 1:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String uid = request.getParameter("id");
    ApplicationDao usID = new ApplicationDao();
    Log record = usID.getSingleLog(uid);
    request.setAttribute("edit_log", record);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <title>Edit User Data</title>
    <style>
        .inner{
            position: relative;
            margin: 0 auto;
            width: 650px;
            display: block;
            padding: 50px 0;
        }
        h3{
            text-align: center;
            border-bottom: 2px solid midnightblue;
            margin-bottom: 20px;
        }
        nav li a{
            font-size: 25px;
            font-weight: 500;
        }
        a{
            color: #fff;
            text-decoration: none;
        }
    </style>
</head>
<body>
<div class="inner">
    <div class=" container">
        <div class="row">
            <div class="col-sm-10">
                <h3>
                    Edit Log Details </h3>
                <form action="UpdateLogServlet" method="post">
                    <div class="form-group">
                        <label>Title</label>
                        <input class="form-control" maxlength="60" name="Title" value="${edit_log.title }" required>
                    </div>
                    <div class="form-group">
                        <label>Content</label>
                        <textarea class="form-control"maxlength="120" rows="2" name="Content" required>${edit_log.content}</textarea>
                    </div>
                    <div class="form-group">
                        <label>UUID:</label>
                        <input name="UUID" class="form-control" value="${edit_log.uuid}" readonly>
                        <label>that was created on:</label>
                        <input class="form-control" name ="Time" value="${edit_log.createTimestamp}" readonly>
                        <label>and file attached: </label>
                        <input class="form-control" name ="FileType" value="${edit_log.fileType}" readonly>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                    <button class="btn btn-primary"><a href="user-page-logger.jsp">Cancel</a></button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
