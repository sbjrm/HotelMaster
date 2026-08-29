package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestExample {
    @Test
    public void onePlusTwoShouldBeThree() {
        int a = 1;
        int b = 2;

        int c = a + b;

        Assertions.assertEquals(3, c);
    }
}
