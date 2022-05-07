package ap.chapter3.questions;

/**
 * @author lei
 * @date 12/18/2021 11:48 AM
 *
 *  q19
 */
public class Temperature {
    private double degree;
    private String scale;

    public Temperature(double degree, String scale){
        this.degree = degree;
        this.scale = scale;
    }

    public Temperature inFahrenheit() {
        Temperature result;
        result = new Temperature(degree*1.8+32, "F");
        return result;
    }

    public static boolean isValidTemp(double degree, String scale) {
        // make some judgments
        return true;
    }

    public static void doSomething(double degree, String scale) {
        if (isValidTemp(degree, scale)) {
            // TODO
        }

        if (Temperature.isValidTemp(degree, scale)) {
            // TODO
        }
    }
}
