package org.example.gradecalculator;

import java.util.List;

public class GradeCalculator {
    private final List<Course> courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = courses;
    }

    public double calculateGrade() {
        // 현재 구조는 course에 있는 학점을 getter로 가져와, 학점 계산기에서 직접 계산을 해주고 있음.
        // 만약, 학점 계산을 여러군데서 사용한다면, 아래 로직이 바뀐다면 모두 변경해주어야함 = 응집도가 낮다.
        // 본인의 값을 가진 Course에서 직접 계산을 하는 것이 좋음. 기본적으로 해당 데이터를 가지고 있는 객체가 처리하도록 하는 것이 좋음.

        // 학점 수 * 교과목 평점의 합계
        double multipliedCreditAndGrade = 0;
        for (Course course : courses) {
            multipliedCreditAndGrade += course.multiplyCreditAndCourse();
        }

        //수강신청 총 학점 수
        int totalCompletedCredit = courses.stream()
                .mapToInt(Course::getCredit)
                .sum();

        return multipliedCreditAndGrade / totalCompletedCredit;
    }
}
