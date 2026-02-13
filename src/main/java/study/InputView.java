package study;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class InputView {
    static Scanner scanner = new Scanner(System.in);
    private static final int INIT_NUMBER = 0;

    public static String[] makeCarName() {
        String input;
        do {
            System.out.println("경주할 자동차 이름을 입력하세요(5자 이내, 이름은 쉼표(,)를 기준으로 구분).");
            input = scanner.nextLine();
        } while (Arrays.equals(validCarName(input), new String[INIT_NUMBER]));
        return validCarName(input);
    }

    public static int inputTryNumber() {
        int tryNumber = 0;
        do {
            System.out.println("시도할 횟수는 몇회인가요?");
            try {
                tryNumber = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("올바른 숫자를 입력하세요.");
                scanner.nextLine();
            }
        } while (tryNumber <= 0);
        return tryNumber;
    }

    public static String[] validCarName(String input) {
        String[] output;
        try {
            output = input.split(",");
            for (String string : output) {
                if (string.length() > 5) return new String[INIT_NUMBER];
            }
        } catch (PatternSyntaxException e) {
            return new String[INIT_NUMBER];
        }
        return output;
    }
}
