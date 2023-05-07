package org.example.gradecalculator;

import java.util.List;

public class Courses {
    private List<Course> courses;

    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    public double multiplyCreditAndCourseGrade() {
        double multipliedCreditAndGrade = 0;
        for (Course course : courses) {
            multipliedCreditAndGrade += course.multiplyCreditAndCourse();
        }
        return multipliedCreditAndGrade;
    }

    public int calculateToTotalCompletedCredit() {
        return courses.stream()
                .mapToInt(Course::getCredit)
                .sum();
    }
}
