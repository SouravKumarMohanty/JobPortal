<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Job" %>
<%@ page import="dao.JobDAO" %>
<%@ page import="util.DBConnection" %>
<%
    String message = "";
    if (request.getParameter("submit") != null) {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String company = request.getParameter("company");

        Job job = new Job();
        job.setTitle(title);
        job.setDescription(description);
        job.setCompany(company);

        JobDAO jobDAO = new JobDAO(DBConnection.getConnection());
        boolean isSuccess = jobDAO.createJob(job);
        
        if (isSuccess) {
            message = "Job posted successfully!";
        } else {
            message = "Failed to post job. Please try again.";
        }
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <title>Post Job</title>
</head>
<body>
    <h1>Post a New Job</h1>
    <form action="job_post.jsp" method="post">
        <label for="title">Job Title:</label>
        <input type="text" id="title" name="title" required><br><br>
        
        <label for="description">Job Description:</label>
        <textarea id="description" name="description" required></textarea><br><br>
        
        <label for="company">Company Name:</label>
        <input type="text" id="company" name="company" required><br><br>
        
        <input type="submit" name="submit" value="Post Job">
    </form>
    <p><%= message %></p>
</body>
</html>