package ee.bcs.valiit;

import ee.bcs.valiit.tasks.Lesson1MathUtil;
import ee.bcs.valiit.tasks.solution.SolutionLesson1MathUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Lesson1MathUtilTest {
    @Test
    public void test (){
        int result = Lesson1MathUtil.min(3, 4);
        Assertions.assertEquals( 3, result);
    }
    @Test
    void min(){
        Assertions.assertEquals( 3, Lesson1MathUtil.min(3, 5));
        Assertions.assertEquals( -5, Lesson1MathUtil.min( 3, -5));

    }
    @Test
    void max(){
        Assertions.assertEquals( 3, Lesson1MathUtil.max(1, 3));
        Assertions.assertEquals( 7, Lesson1MathUtil.max(7, 5));
    }
    @Test
    void abs(){
        Assertions.assertEquals( 4, Lesson1MathUtil.abs(-4));
        Assertions.assertEquals( 2, Lesson1MathUtil.abs(2));

    }
    @Test
    void isEven(){
        Assertions.assertTrue( Lesson1MathUtil.isEven(2));
        Assertions.assertFalse( Lesson1MathUtil.isEven( 3));
    }
    @Test
    void min2(){
        Assertions.assertEquals( 1, Lesson1MathUtil.min(1,2,3));
        Assertions.assertEquals(2, Lesson1MathUtil.min(4,2,6));
        Assertions.assertEquals( 3, Lesson1MathUtil.min(5,7,3));
    }
    @Test
    void max2(){
        Assertions.assertEquals( 9, Lesson1MathUtil.max(9,3,5));
        Assertions.assertEquals(7, Lesson1MathUtil.max(3, 7, 4));
        Assertions.assertEquals(8, Lesson1MathUtil.max(1, 4, 8));
    }
}

