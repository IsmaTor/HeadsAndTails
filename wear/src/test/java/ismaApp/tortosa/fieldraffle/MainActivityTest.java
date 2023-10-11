package ismaApp.tortosa.fieldraffle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class MainActivityTest {

    @Test
    public void test(){
        int num1 = 1;
        int num2 = 1;
        int num3 = 0;
        int num4 = 1;

        assertEquals(num1, num2);
        assertEquals(num1, num4);

        assertNotEquals(num1, num3);
    }

}





