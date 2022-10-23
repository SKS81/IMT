public class Main {

    public static void main(String[] args) {
        BmiService service = new BmiService();
        double weight = 88.6; // вес в килограммах
        double height = 1.79; // рост в метрах
        double indmt = service.calculate(weight, height);
        System.out.println("Ваш индекс массы тела = " + indmt);
        if (indmt < 18) {
            System.out.println("У Вас недостаток веса");
        } else if (indmt < 25) {
            System.out.println("У Вас нормальный вес");
        } else if (indmt < 30) {
            System.out.println("У Вас избыточный вес");
        } else {
            System.out.println("У Вас ожирение");
        }

    }
}