<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="src.dao.JobDAO" %>
<%@ page import="src.model.Job" %>
<%@ page import="src.util.DBConnection" %>

<%
    String jobId = request.getParameter("jobId");
    JobDAO jobDAO = new JobDAO();
    Job job = jobDAO.getJobById(Integer.parseInt(jobId));
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <title>Apply for Job</title>
</head>
<body>
    <div class="container">
        <h2>Apply for Job: <%= job.getTitle() %></h2>
        <form action="JobApplicationServlet" method="post">
            <input type="hidden" name="jobId" value="<%= job.getJobId() %>">
            <div>
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div>
                <label for="resume">Resume (URL):</label>
                <input type="text" id="resume" name="resume" required>
            </div>
            <div>
                <input type="submit" value="Submit Application">
            </div>
        </form>
        <a href="jobs.jsp">Back to Job Listings</a>
    </div>
</body>
</html>