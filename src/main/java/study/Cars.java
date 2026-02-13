package study;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    static final int RAND_MAX = 9;
    static final int RAND_MIN = 0;
    private final List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void addCar(String[] names, int value) {
        for (String name : names) {
            cars.add(new Car(value, name));
        }
    }

    public String lookUpName(int index) {
        Car car = cars.get(index);
        return car.getName();
    }

    public int lookUpLocation(int index) {
        Car car = cars.get(index);
        return car.getLocation();
    }

    public int lookUpLength() {
        return cars.size();
    }

    public int maxLocation(int length) {
        int max = 0;
        for (int i = 0; i < length; i++) {
            Car car = cars.get(i);
            if (max < car.getLocation()) max = car.getLocation();
        }
        return max;
    }

    public StringBuilder forwardCar(int index) {
        Car car = cars.get(index);
        return car.forward((int) (Math.random() * RAND_MAX) + RAND_MIN);
    }
}
