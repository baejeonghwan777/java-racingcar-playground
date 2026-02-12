package study;

import java.util.*;
import java.util.regex.PatternSyntaxException;

public class CarRacing {
    static final int INIT_NUMBER = 0;
    static Scanner scanner = new Scanner(System.in);
    static String[] names;
    Cars cars;

    public CarRacing(Cars cars) {
        this.cars = cars;
    }

    public String[] makeCarName() {
        String input;
        do {
            System.out.println("경주할 자동차 이름을 입력하세요(5자 이내, 이름은 쉼표(,)를 기준으로 구분).");
            input = scanner.nextLine();
        } while (Arrays.equals(validCarName(input), new String[INIT_NUMBER]));
        return validCarName(input);
    }

    public int inputTryNumber() {
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

    public String[] validCarName(String input) {
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

    public int makeCarObject() {
        names = makeCarName();
        int tryNumber = inputTryNumber();
        cars.addCar(names, INIT_NUMBER);
        return tryNumber;
    }

    public void playCarRacing() {
        int tryNumber = makeCarObject();
        System.out.println("실행 결과");
        printCarRacing(tryNumber);
        int maxValue = cars.maxLocation(cars.lookUpLength());
        List<String> winners = searchWinner(maxValue);
        printWinners(winners);
    }

    public void printCarRacing(int tryNumber) {
        for (int i = 0; i < tryNumber; i++) {
            for (int j = 0; j < cars.lookUpLength(); j++) {
                System.out.println(cars.lookUpName(j) + " : " + cars.forwardCar(j));
            }
            System.out.println();
        }
    }

    public void printWinners(List<String> winners) {
        String result = String.join(",", winners);
        System.out.println(result + "가 최종 우승했습니다.");
    }

    public List<String> searchWinner(int maxValue) {
        List<String> winners = new ArrayList<>();
        for (int i = 0; i < cars.lookUpLength(); i++) {
            if (cars.lookUpLocation(i) == maxValue)
                winners.add(cars.lookUpName(i));
        }
        return winners;
    }
}
