package hello.hello.grade;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * Created by vle on 9/24/2015.
 * http://www.mkyong.com/unittest/junit-4-tutorial-6-parameterized-test/
 */
@RunWith(value = Parameterized.class)
public class CalculateGradeTest extends TestCase {
    private char letter;
    private boolean expected;
    public CalculateGradeTest(char letter, boolean expected){
        this.letter = letter;
        this.expected = expected;
    }


    @Test
    public void testGetGradeAverage() throws Exception {
        assertTrue(true);
    }

    @Test
    public void testGetGradeLetter() throws Exception {
        CalculateGrade grade = new CalculateGrade(null,null);

        //assertEquals();
    }

    @Test
    public void testGetGPA() throws Exception {

    }
}