package dao;

import model.Job;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobDAO {
    private Connection connection;

    public JobDAO() {
        connection = DBConnection.getConnection();
    }

    public void createJob(Job job) {
        String query = "INSERT INTO jobs (title, description, company) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, job.getTitle());
            pstmt.setString(2, job.getDescription());
            pstmt.setString(3, job.getCompany());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Job> getAllJobs() {
        List<Job> jobList = new ArrayList<>();
        String query = "SELECT * FROM jobs";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Job job = new Job();
                job.setJobId(rs.getInt("jobId"));
                job.setTitle(rs.getString("title"));
                job.setDescription(rs.getString("description"));
                job.setCompany(rs.getString("company"));
                jobList.add(job);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobList;
    }

    public Job getJobById(int jobId) {
        Job job = null;
        String query = "SELECT * FROM jobs WHERE jobId = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, jobId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                job = new Job();
                job.setJobId(rs.getInt("jobId"));
                job.setTitle(rs.getString("title"));
                job.setDescription(rs.getString("description"));
                job.setCompany(rs.getString("company"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return job;
    }

    public void deleteJob(int jobId) {
        String query = "DELETE FROM jobs WHERE jobId = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, jobId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}