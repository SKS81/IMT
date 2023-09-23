package windows;

public class imtService {

    public float getImt(float weight, float height) {
        float temp = (height * height);
        int indmt = (int) (weight / temp);
        return indmt;
    }

    public String getComm(int indmt) {
        String answer2;
        if (indmt <= 18) {
            answer2 = ("У Вас недостаток веса");
        } else if (indmt > 18 && indmt <= 25) {
            answer2 = ("У Вас нормальный вес");
        } else if (indmt > 25 && indmt <= 30) {
            answer2 = ("У Вас избыточный вес");
        } else {
            answer2 = ("У Вас ожирение");
        }
        return answer2;
    }
}