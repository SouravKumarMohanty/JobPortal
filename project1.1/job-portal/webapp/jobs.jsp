<%@ page import="java.util.List" %>
<%@ page import="model.Job" %>
<%@ page import="dao.JobDAO" %>
<%@ page import="dao.DBConnection" %>
<%
    List<Job> jobList = null;
    JobDAO jobDAO = new JobDAO(DBConnection.getConnection());
    
    try {
        jobList = jobDAO.getAllJobs();
    } catch (Exception e) {
        e.printStackTrace();
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Job Listings</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h1>Job Listings</h1>
    <table>
        <thead>
            <tr>
                <th>Job Title</th>
                <th>Company</th>
                <th>Description</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <%
                if (jobList != null && !jobList.isEmpty()) {
                    for (Job job : jobList) {
            %>
            <tr>
                <td><%= job.getTitle() %></td>
                <td><%= job.getCompany() %></td>
                <td><%= job.getDescription() %></td>
                <td><a href="job_apply.jsp?jobId=<%= job.getJobId() %>">Apply</a></td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="4">No jobs available.</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
    <a href="job_post.jsp">Post a Job</a>
    <a href="index.html">Home</a>
</body>
</html>