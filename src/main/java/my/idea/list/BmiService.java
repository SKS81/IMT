package my.idea.list;

public class BmiService {

    public float calculate(float weight, float height) {

        float temp = (height * height);
        float imt = (weight / temp);
        return imt;

    }

}