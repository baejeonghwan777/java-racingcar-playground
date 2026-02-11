package study;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    static Scanner scanner = new Scanner(System.in);
    static final int INIT_NUMBER = 0;

    public int run() {
        String input = inputNumber();
        return splitAndSum(input);
    }

    public String inputNumber() {
        System.out.print("숫자를 입력하세요. : ");
        return scanner.nextLine();
    }

    public int splitAndSum(String input) {
        if(input == null || input.isEmpty()) return 0;
        if(input.contains("-")) throw new RuntimeException();
        if(input.length() == 1) return Integer.parseInt(input);
        if(input.contains("\\n")) input = input.replace("\\n","\n"); // \n을 치면 개행 문자로 인식하게끔 하였다.
        if(input.contains("//") && input.contains("\n")) return patternMatch(input);
        if(input.contains(",") || input.contains(":")) return splitNumber(input);
        throw new RuntimeException();
    }

    public int splitNumber(String input) {
        String[] inputs = input.split(",|:");
        return sumNumber(inputs);
    }

    public int patternMatch(String input) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        String[] inputs;
        if(matcher.find()) {
            String customDelimiter = matcher.group(1);
            inputs = matcher.group(2).split(customDelimiter);
            return sumNumber(inputs);
        }
        return sumNumber(new String[INIT_NUMBER]);
    }

    public int sumNumber(String[] inputs) {
        try {
            int sum = 0;
            int[] intInputs = new int[inputs.length];
            for(int i = 0; i < inputs.length; i++) {
                intInputs[i] = Integer.parseInt(inputs[i]);
                sum += intInputs[i];
            }
            return sum;
        } catch (Exception e) { throw new RuntimeException(e); }
    }
}
