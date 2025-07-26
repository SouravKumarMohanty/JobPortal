package model;

public class Job {
    private int jobId;
    private String title;
    private String description;
    private String company;

    public Job() {
    }

    public Job(int jobId, String title, String description, String company) {
        this.jobId = jobId;
        this.title = title;
        this.description = description;
        this.company = company;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}