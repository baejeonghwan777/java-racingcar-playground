package study;

import java.util.ArrayList;
import java.util.List;

public class CarRacingMain {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        CarRacing racing = new CarRacing(new Cars(cars));
        racing.playCarRacing();
    }
}
