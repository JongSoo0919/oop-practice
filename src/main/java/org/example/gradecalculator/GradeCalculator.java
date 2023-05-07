package org.example.gradecalculator;

import java.util.List;

public class GradeCalculator {
    private final List<Course> courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = courses;
    }

    public double calculateGrade() {
        // 학점 수 * 교과목 평점의 합계
        double multipliedCreditAndGrade = 0;
        for (Course course : courses) {
            multipliedCreditAndGrade += course.getCredit() * course.getGradeToNumber();
        }

        //수강신청 총 학점 수
        int totalCompletedCredit = courses.stream()
                .mapToInt(Course::getCredit)
                .sum();

        return multipliedCreditAndGrade / totalCompletedCredit;
    }
}
