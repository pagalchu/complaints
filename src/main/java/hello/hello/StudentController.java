package hello.hello;

import hello.hello.exception.ProjectException;
import hello.hello.grade.CalculateGrade;
import hello.hello.grade.Grade;
import hello.hello.grade.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vle on 9/24/2015.
 */
@RestController
@RequestMapping("api/student")
public class StudentController {
    @RequestMapping("/letterGrade")
    public char getLetterGrade(){
        Student st = new Student();
        st.setFirstName("John");
        st.setLastName("Doe");
        st.setGradeLvl("Junior");

        Grade grade = new Grade();
        grade.setExtraCredit(90);
        grade.setFinalExamAverage(85);
        grade.setHomeworkAverage(75);
        grade.setMidtermAverage(80);
        grade.setTestAverage(85);

        st.setGrade(grade);
        char letterGrade = 'F';
        try {
            CalculateGrade calculateGrade = new CalculateGrade(st, grade);
            double average = calculateGrade.getGradeAverage();
            letterGrade = calculateGrade.getGradeLetter(average);
        } catch (ProjectException pe){
           letterGrade = 'U';
        } finally {
            return letterGrade;
        }
    }

    @RequestMapping("/gpa")
    public double getGPA(){
        Student st = new Student();
        st.setFirstName("John");
        st.setLastName("Doe");
        st.setGradeLvl("Junior");

        Grade grade = new Grade();
        grade.setExtraCredit(89);
        grade.setFinalExamAverage(85);
        grade.setHomeworkAverage(77);
        grade.setMidtermAverage(91);
        grade.setTestAverage(88);

        st.setGrade(grade);
        double gpa = 0.00;
        try {
            CalculateGrade calculateGrade = new CalculateGrade(st, grade);
            double average = calculateGrade.getGradeAverage();
            char letterGrade = calculateGrade.getGradeLetter(average);
            gpa = calculateGrade.getGPA(letterGrade);
        } catch (ProjectException pe){
            return gpa;
        } finally {
            return gpa;
        }
    }
}
