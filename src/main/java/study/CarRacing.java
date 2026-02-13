package study;

import java.util.List;
import java.util.ArrayList;

public class CarRacing {
    private static final int INIT_NUMBER = 0;
    private final Cars cars;

    public CarRacing(Cars cars) {
        this.cars = cars;
    }

    public int makeCarObject() {
        String[] names = InputView.makeCarName();
        int tryNumber = InputView.inputTryNumber();
        cars.addCar(names, INIT_NUMBER);
        return tryNumber;
    }

    public void playCarRacing() {
        int tryNumber = makeCarObject();
        System.out.println("실행 결과");
        OutputView.printCarRacing(tryNumber, cars);
        int maxValue = cars.maxLocation(cars.lookUpLength());
        List<String> winners = searchWinner(maxValue);
        OutputView.printWinners(winners);
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
