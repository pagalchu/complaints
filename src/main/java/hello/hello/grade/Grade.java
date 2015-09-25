package hello.hello.grade;

/**
 * Created by vle on 9/24/2015.
 */
public class Grade {
    private double testAverage;
    private double homeworkAverage;
    private double extraCredit;
    private double midtermAverage;
    private double finalExamAverage;

    public double getTestAverage() {
        return testAverage;
    }

    public void setTestAverage(double testAverage) {
        this.testAverage = testAverage;
    }

    public double getHomeworkAverage() {
        return homeworkAverage;
    }

    public void setHomeworkAverage(double homeworkAverage) {
        this.homeworkAverage = homeworkAverage;
    }

    public double getExtraCredit() {
        return extraCredit;
    }

    public void setExtraCredit(double extraCredit) {
        this.extraCredit = extraCredit;
    }

    public double getMidtermAverage() {
        return midtermAverage;
    }

    public void setMidtermAverage(double midtermAverage) {
        this.midtermAverage = midtermAverage;
    }

    public double getFinalExamAverage() {
        return finalExamAverage;
    }

    public void setFinalExamAverage(double finalExamAverage) {
        this.finalExamAverage = finalExamAverage;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "testAverage=" + testAverage +
                ", homeworkAverage=" + homeworkAverage +
                ", extraCredit=" + extraCredit +
                ", midtermAverage=" + midtermAverage +
                ", finalExamAverage=" + finalExamAverage +
                '}';
    }
}
