import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        BmiService service = new BmiService();
        System.out.println("Программа расчёта индекса массы.");
        System.out.println();
        System.out.println("Если числа дробные, используйте запятую.");
        System.out.println("Укажите Ваш вес в килограммах:");
        float weight = console.nextFloat();
        System.out.println("Укажите Ваш рост в метрах:");
        float height = console.nextFloat();
        float indmt = service.calculate(weight, height);
        System.out.println("Ваш индекс массы тела = " + indmt);
        if (indmt <= 18) {
            System.out.println("У Вас недостаток веса");
            System.exit(0);
        } if (indmt <= 25) {
            System.out.println("У Вас нормальный вес");
            System.exit(0);
        } if (indmt <= 30) {
            System.out.println("У Вас избыточный вес");
            System.exit(0);
        } else {
            System.out.println("У Вас ожирение");
        }
    }

}