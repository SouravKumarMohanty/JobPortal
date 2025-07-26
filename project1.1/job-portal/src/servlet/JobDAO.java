package servlet;

import model.Job;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobDAO {
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/jobportal", "root", "");
    }

    public List<Job> getAllJobs() {
        List<Job> jobs = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM jobs")) {
            while (rs.next()) {
                Job job = new Job();
                job.setJobId(rs.getInt("id"));
                job.setTitle(rs.getString("title"));
                job.setDescription(rs.getString("description"));
                job.setCompany(rs.getString("company"));
                jobs.add(job);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jobs;
    }

    public void deleteJob(int jobId) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM jobs WHERE id = ?")) {
            stmt.setInt(1, jobId);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
