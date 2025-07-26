<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Job" %>
<%@ page import="dao.JobDAO" %>
<%@ page import="dao.UserDAO" %>
<%@ page import="model.User" %>
<%
    JobDAO jobDAO = new JobDAO();
    UserDAO userDAO = new UserDAO();
    List<Job> jobList = jobDAO.getAllJobs();
    List<User> userList = userDAO.getAllUsers();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <title>Admin Panel</title>
</head>
<body>
    <header>
        <h1>Admin Panel</h1>
        <nav>
            <a href="index.html">Home</a>
            <a href="jobs.jsp">View Jobs</a>
            <a href="job_post.jsp">Post Job</a>
            <a href="logout.jsp">Logout</a>
        </nav>
    </header>
    <main>
        <section>
            <h2>Manage Jobs</h2>
            <table>
                <thead>
                    <tr>
                        <th>Job ID</th>
                        <th>Title</th>
                        <th>Company</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (Job job : jobList) {
                    %>
                    <tr>
                        <td><%= job.getJobId() %></td>
                        <td><%= job.getTitle() %></td>
                        <td><%= job.getCompany() %></td>
                        <td>
                            <a href="edit_job.jsp?jobId=<%= job.getJobId() %>">Edit</a>
                            <a href="delete_job.jsp?jobId=<%= job.getJobId() %>">Delete</a>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </section>
        <section>
            <h2>Manage Users</h2>
            <table>
                <thead>
                    <tr>
                        <th>User ID</th>
                        <th>Username</th>
                        <th>Email</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (User user : userList) {
                    %>
                    <tr>
                        <td><%= user.getUserId() %></td>
                        <td><%= user.getUsername() %></td>
                        <td><%= user.getEmail() %></td>
                        <td>
                            <a href="edit_user.jsp?userId=<%= user.getUserId() %>">Edit</a>
                            <a href="delete_user.jsp?userId=<%= user.getUserId() %>">Delete</a>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </section>
    </main>
    <footer>
        <p>&copy; 2023 Job Portal. All rights reserved.</p>
    </footer>
</body>
</html>