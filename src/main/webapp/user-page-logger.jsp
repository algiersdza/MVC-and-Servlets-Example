<%@ page import="com.algonquin.loggy.dao.ApplicationDao" %>
<%@ page import="com.algonquin.loggy.beans.Log" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Ibrahim Hermouche
  Date: 12/6/2021
  Time: 11:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
    ApplicationDao logData = new ApplicationDao();
    List<Log> logs = logData.selectAllLogs();
    request.setAttribute("listLog", logs);

%>


<!DOCTYPE html>
<html lang="en">
<meta charset="UTF-8">
<head>
    <title>Add A Log</title>
</head>
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous">
<body>

<!-- this contains the input-->
<div class="container">
    <div class="col-9">
        <form class="form-gourp" action="AddLogServlet" method="post">
            <div class="form-group">
                 <h6>Title</h6>
                <input type="text" class="form-control" name="Title" maxlength="60" placeholder="Type your title here.." required>
            </div>
            <div class="form-group">
                <h6>Your Story!</h6>
                <textarea class="form-control" name="Content" rows="3" maxlength="120" placeholder="120 characters max.." required rows = "2"></textarea>
            </div>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" name="FileType" for="inputGroupSelect01">Upload a file</label>
                </div>
                <select name="FileType" class="custom-select" id="inputGroupSelect01">
                    <option selected>Choose...</option>
                    <option value=".txt">text.txt</option>
                    <option value=".mp3">audio.mp3</option>
                    <option value=".mp4">video.mp4</option>
                    <option value="nofile">No file</option>
                </select>
            </div>




<%--            <div class="form-group">--%>
<%--                <h6>Upload your file</h6>--%>
<%--                <input type="file" class="form-control-file" disabled>--%>
<%--            </div>--%>
            <div class="form-gourp">
                <button class="btn btn-dark" type="submit" >Submit Log</button>
            </div>
        </form>

    </div>
</div>
<br>
<div class="container">
    <h3 class="text-center">List of logs</h3>
    <div class="row">
        <table class="table table-nonbordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Content</th>
                <th>Uploaded File</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="log" items="${listLog}">

            <tr>
                <td><c:out value="${log.uuid.substring(0,8)}"/></td>
                <td><c:out value="${log.title}"/></td>
                <td><c:out value="${log.content}"/></td>
                <td><c:out value="${log.fileType}"/></td>
                <td><a href="log-edit-page.jsp?id=${log.uuid}">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp; <a
                            href="DeleteLogsServlet?id=${log.uuid}">Delete</a></td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
