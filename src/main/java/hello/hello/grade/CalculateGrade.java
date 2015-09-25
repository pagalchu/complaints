package hello.hello.grade;

import hello.hello.exception.ProjectException;

/**
 * Created by vle on 9/24/2015.
 */
public class CalculateGrade {
    private Student student;
    private Grade grade;

    public CalculateGrade(Student student, Grade grade){
        this.student = student;
        this.grade = grade;
    }

    public double getGradeAverage() throws ProjectException{
        if(this.student != null){
            double average = 0.00;
            StringBuilder builder = new StringBuilder();
            builder.append(student.getFirstName());
            builder.append(student.getLastName());
            double test = student.getGrade().getTestAverage();
            double extraCredit = student.getGrade().getExtraCredit();
            double finalExam = student.getGrade().getFinalExamAverage();
            double homework = student.getGrade().getHomeworkAverage();
            double midterm = student.getGrade().getMidtermAverage();
            average = ((test + extraCredit + finalExam + homework + midterm)/5);
            return average;
        } else {
            throw new ProjectException("student is null");
        }
    }

    public char getGradeLetter(double average){
        char gradeLetter;
        if(average >= 90){
            gradeLetter = 'A';
        } else if(average >= 80 && average <= 89){
            gradeLetter = 'B';
        } else if(average >= 70 && average <= 79){
            gradeLetter = 'C';
        } else {
            gradeLetter = 'F';
        }
        return gradeLetter;
    }

    public double getGPA(char letterGrade) throws ProjectException{
        double gpa = 0.00;
        if(Character.isLetter(letterGrade)) {

            if(letterGrade == 'A'){
                gpa = 4.00;
            } else if(letterGrade == 'B'){
                gpa = 3.50;
            } else if(letterGrade == 'C'){
                gpa = 2.50;
            } else if(letterGrade == 'F'){
                gpa = 1.00;
            }
        } else {
            throw new ProjectException("letter grade is not a letter");
        }
        return gpa;
    }
}
