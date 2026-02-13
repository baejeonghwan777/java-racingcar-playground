package study;

import java.util.List;

public class OutputView {
    public static void printCarRacing(int tryNumber, Cars cars) {
        for (int i = 0; i < tryNumber; i++) {
            for (int j = 0; j < cars.lookUpLength(); j++) {
                System.out.println(cars.lookUpName(j) + " : " + cars.forwardCar(j));
            }
            System.out.println();
        }
    }

    public static void printWinners(List<String> winners) {
        String result = String.join(",", winners);
        System.out.println(result + "가 최종 우승했습니다.");
    }
}
