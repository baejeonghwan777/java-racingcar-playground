package study;

public class CalculatorMain {
    public static void main(String[] args) {
        StringAddCalculator calculator = new StringAddCalculator();
        int result = calculator.run();
        System.out.println(result);
    }
}
