package com.example.infs3605.database;
public class Details {
    private String username;
    private String faculty;
    private String coursea;
    private String courseb;
    private String coursec;

    public Details(String username, String faculty, String coursea, String courseb, String coursec) {
        this.username = username;
        this.faculty = faculty;
        this.coursea = coursea;
        this.courseb = courseb;
        this.coursec = coursec;
    }
    public String getUsername() {
        return username;
    }
    public String getFaculty() {
        return faculty;
    }
    public String getCoursea() {
        return coursea;
    }
    public String getCourseb() {
        return courseb;
    }
    public String getCoursec() {return coursec; }
}