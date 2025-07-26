package servlet;

import dao.JobDAO;
import model.Job;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/jobpost")
public class JobPostServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private JobDAO jobDAO;

    public void init() {
        jobDAO = new JobDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String company = request.getParameter("company");

        Job job = new Job();
        job.setTitle(title);
        job.setDescription(description);
        job.setCompany(company);

        jobDAO.createJob(job);
        response.sendRedirect("jobs.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("job_post.jsp").forward(request, response);
    }
}