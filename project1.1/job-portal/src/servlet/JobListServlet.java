package servlet;

import dao.JobDAO;
import model.Job;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/joblist")
public class JobListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private JobDAO jobDAO;

    public void init() {
        jobDAO = new JobDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Job> jobList = jobDAO.getAllJobs();
        request.setAttribute("jobList", jobList);
        request.getRequestDispatcher("jobs.jsp").forward(request, response);
    }
}