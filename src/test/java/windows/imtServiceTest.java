package windows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

public class imtServiceTest {

    imtService service = new imtService();

    @ParameterizedTest
    @DisplayName("CSV на значения")
    @CsvFileSource(files="src/test/resources/dataImt.csv")
    public void imtParamCSVFile(float expected, float a, float b) {
        float actual = service.getImt(a, b);
        Assertions.assertEquals(expected, actual);
        System.out.println("Ожидаем " + expected + " = Получаем " + actual);
    }

    @ParameterizedTest
    @DisplayName("CSV на комментарии")
    @CsvFileSource(files="src/test/resources/dataComm.csv")
    public void commParamCSVFile(String expected, int indmt) {
        String actual = service.getComm(indmt);
        Assertions.assertEquals(expected, actual);
        System.out.println("Ожидаем: '" + expected + "'" + " = " + indmt + " = Получаем: '" + actual + "'");
    }

    @ParameterizedTest
    @DisplayName("Параметризованный на значения")
    @CsvSource({
            "20,66,1.79",
            "80,20,0.5",
            "20,5,0.5",
    })
    public void imtParam(float expected, float a, float b) {
        float actual = service.getImt(a, b);
        Assertions.assertEquals(expected, actual);
        System.out.println("Ожидаем " + expected + " = Получаем " + actual);
    }

    @ParameterizedTest
    @DisplayName("Параметризованный на комментарии")
    @CsvSource({
            "У Вас недостаток веса,5",
            "У Вас нормальный вес,22",
            "У Вас избыточный вес,26",
            "У Вас ожирение,33",
    })
    public void commParam(String expected, int indmt) {
        String actual = service.getComm(indmt);
        Assertions.assertEquals(expected, actual);
        System.out.println("Ожидаем: '" + expected + "'" + " = " + indmt + " = Получаем: '" + actual + "'");
    }

    @Test
    @DisplayName("На Недостаток веса")
    public void imtComm1() {
        float expected1 = 15;
        String expected2 = "У Вас недостаток веса";
        float actual1 = service.getImt(52F, 1.85F);
        String actual2 = service.getComm((int) expected1);
        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);
        System.out.println("Ожидаем " + expected1 + " = Получаем " + actual1);
        System.out.println("Ожидаем: '" + expected2 + "' = Получаем: '" + actual2 + "'");
    }

    @Test
    @DisplayName("На Нормальный вес")
    public void imtComm2() {
        float expected1 = 21;
        String expected2 = "У Вас нормальный вес";
        float actual1 = service.getImt(43F, 1.4F);
        String actual2 = service.getComm((int) expected1);
        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);
        System.out.println("Ожидаем " + expected1 + " = Получаем " + actual1);
        System.out.println("Ожидаем: '" + expected2 + "' = Получаем: '" + actual2 + "'");
    }

    @Test
    @DisplayName("На Избыточный вес")
    public void imtComm3() {
        float expected1 = 29;
        String expected2 = "У Вас избыточный вес";
        float actual1 = service.getImt(95.05F, 1.785F);
        String actual2 = service.getComm((int) expected1);
        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);
        System.out.println("Ожидаем " + expected1 + " = Получаем " + actual1);
        System.out.println("Ожидаем: '" + expected2 + "' = Получаем: '" + actual2 + "'");
    }

    @Test
    @DisplayName("На Ожирение")
    public void imtComm4() {
        float expected1 = 39;
        String expected2 = "У Вас ожирение";
        float actual1 = service.getImt(98.75F, 1.59F);
        String actual2 = service.getComm((int) expected1);
        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);
        System.out.println("Ожидаем " + expected1 + " = Получаем " + actual1);
        System.out.println("Ожидаем: '" + expected2 + "' = Получаем: '" + actual2 + "'");
    }

    @Test
    @DisplayName("Граничные значения")
    public void commBorders() {
        String expected1 = "У Вас недостаток веса";
        String expected2 = "У Вас нормальный вес";
        String expected3 = "У Вас избыточный вес";
        String expected4 = "У Вас ожирение";
        String actual11 = service.getComm(17);
        String actual12 = service.getComm(18);
        String actual21 = service.getComm(19);
        String actual22 = service.getComm(24);
        String actual23 = service.getComm(25);
        String actual31 = service.getComm(26);
        String actual32 = service.getComm(29);
        String actual33 = service.getComm(30);
        String actual4 = service.getComm(31);
        Assertions.assertEquals(expected1, actual11);
        Assertions.assertEquals(expected1, actual12);
        Assertions.assertEquals(expected2, actual21);
        Assertions.assertEquals(expected2, actual22);
        Assertions.assertEquals(expected2, actual23);
        Assertions.assertEquals(expected3, actual31);
        Assertions.assertEquals(expected3, actual32);
        Assertions.assertEquals(expected3, actual33);
        Assertions.assertEquals(expected4, actual4);
        System.out.println("Ожидаем: '" + expected1 + "'" + " = " + 17 + " = Получаем: '" + actual11 + "'");
        System.out.println("Ожидаем: '" + expected1 + "'" + " = " + 18 + " = Получаем: '" + actual12 + "'");
        System.out.println("Ожидаем: '" + expected2 + "'" + " = " + 19 + " = Получаем: '" + actual21 + "'");
        System.out.println("Ожидаем: '" + expected2 + "'" + " = " + 24 + " = Получаем: '" + actual22 + "'");
        System.out.println("Ожидаем: '" + expected2 + "'" + " = " + 25 + " = Получаем: '" + actual23 + "'");
        System.out.println("Ожидаем: '" + expected3 + "'" + " = " + 26 + " = Получаем: '" + actual31 + "'");
        System.out.println("Ожидаем: '" + expected3 + "'" + " = " + 29 + " = Получаем: '" + actual32 + "'");
        System.out.println("Ожидаем: '" + expected3 + "'" + " = " + 30 + " = Получаем: '" + actual33 + "'");
        System.out.println("Ожидаем: '" + expected4 + "'" + " = " + 31 + " = Получаем: '" + actual4 + "'");
    }
}