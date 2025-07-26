package servlet;

import dao.JobDAO;
import model.Job;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/applyJob")
public class JobApplicationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private JobDAO jobDAO;

    public void init() {
        jobDAO = new JobDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jobIdStr = request.getParameter("jobId");
        String userIdStr = request.getParameter("userId");
        String resume = request.getParameter("resume");

        if (jobIdStr != null && userIdStr != null && resume != null) {
            int jobId = Integer.parseInt(jobIdStr);
            int userId = Integer.parseInt(userIdStr);

            Job job = jobDAO.getJobById(jobId);
            if (job != null) {
                // Here you would typically save the application to the database
                // For simplicity, we are just forwarding to a success page
                request.setAttribute("message", "Application submitted successfully for job: " + job.getTitle());
                request.getRequestDispatcher("success.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Job not found.");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error", "Invalid application data.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}