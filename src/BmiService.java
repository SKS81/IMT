public class BmiService {

    public double calculate(double weight, double height) {

        double temp = (height * height); // рост в квадрате
        double imt = (weight / temp); // расчёт ИМТ
        return imt; // вывод результата

    }

}