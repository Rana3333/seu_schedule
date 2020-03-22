package com.example.seu_schedule;

public class course {
    private String crnTitle;
    private String courseDept;
    private String courseLocation;
    private String courseTime;

    public course(String crnTitle, String courseDept, String courseLocation, String courseTime) {
        this.crnTitle = crnTitle;
        this.courseDept = courseDept;
        this.courseLocation = courseLocation;
        this.courseTime = courseTime;
    }

    public String getCrnTitle() {
        return crnTitle;
    }

    public void setCrnTitle(String crnTitle) {
        this.crnTitle = crnTitle;
    }

    public String getCourseDept() {
        return courseDept;
    }

    public void setCourseDept(String courseDept) {
        this.courseDept = courseDept;
    }

    public String getCourseLocation() {
        return courseLocation;
    }

    public void setCourseLocation(String courseLocation) {
        this.courseLocation = courseLocation;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }
}
