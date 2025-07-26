# Job Portal Web Application

## Overview
This project is a Job Portal web application built using Java Servlets and JSP for the backend, HTML and CSS for the frontend, and MySQL for the database. The application allows users to register, log in, view job listings, and apply for jobs. Employers can post job listings, and administrators can manage users and job postings.

## Features
1. **User Registration and Login**: Users can create accounts and log in to access job listings and apply for jobs.
2. **Job Posting**: Employers can post new job listings through an admin panel.
3. **Job Listings**: Users can view all available job postings.
4. **Job Application Submission**: Users can submit applications for specific job postings.
5. **Admin Panel**: An interface for administrators to manage job postings and user accounts.

## Technical Stack
- **Backend**: Java Servlets and JSP
- **Frontend**: HTML and CSS
- **Database**: MySQL
- **Database Connection**: JDBC
- **Folder Structure**: Organized into `src`, `webapp`, `WEB-INF`, and `db` directories.

## Project Structure
```
job-portal
├── src
│   ├── dao
│   │   ├── JobDAO.java
│   │   └── UserDAO.java
│   ├── model
│   │   ├── Job.java
│   │   └── User.java
│   ├── servlet
│   │   ├── AdminServlet.java
│   │   ├── JobApplicationServlet.java
│   │   ├── JobListServlet.java
│   │   ├── JobPostServlet.java
│   │   ├── LoginServlet.java
│   │   └── RegisterServlet.java
│   └── util
│       └── DBConnection.java
├── webapp
│   ├── css
│   │   └── style.css
│   ├── index.html
│   ├── login.jsp
│   ├── register.jsp
│   ├── jobs.jsp
│   ├── job_post.jsp
│   ├── job_apply.jsp
│   ├── admin_panel.jsp
│   └── error.jsp
├── WEB-INF
│   └── web.xml
├── db
│   └── jobportal.sql
└── README.md
```

## Setup Instructions
1. **Clone the Repository**: Clone this repository to your local machine.
2. **Database Setup**:
   - Ensure you have MySQL installed (can use XAMPP).
   - Create a new database for the job portal.
   - Run the SQL script located in `db/jobportal.sql` to create the necessary tables.
3. **Configure Database Connection**: Update the database connection details in `src/util/DBConnection.java` as per your MySQL setup.
4. **Run the Application**: Deploy the application on a servlet container (like Apache Tomcat) and access it through your web browser.

## Conclusion
This Job Portal web application provides a simple yet effective platform for job seekers and employers. It is built using standard Java technologies and follows a modular structure for easy maintenance and scalability.