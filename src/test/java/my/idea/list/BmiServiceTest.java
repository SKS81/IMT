package my.idea.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BmiServiceTest {

    @Test
    public void rez1() {
        BmiService service = new BmiService();
        float expected = 50;
        float actual = service.calculate(50, 1);
        Assertions.assertEquals(expected, actual);
        System.out.println("Ожидаемый результат > " + expected + " = " + actual + " < Фактический результат");
    }

}
