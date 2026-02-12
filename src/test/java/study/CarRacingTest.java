package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarRacingTest {
    static int INIT_NUMBER = 0;
    Cars cars;
    CarRacing racing;

    @BeforeEach
    public void setUp() {
        List<Car> carList = new ArrayList<>();
        cars = new Cars(carList);
        racing = new CarRacing(cars);
    }

    @DisplayName("5자 이하의 올바른 이름을 입력했는지 확인한다.")
    @Test
    public void nameTest() {
        String name = "apple,eddy,mico";

        String[] names = racing.validCarName(name);

        assertThat(names).isEqualTo(new String[]{"apple","eddy","mico"});
    }

    @DisplayName("5자 이상의 이름을 입력했을 때 이름 입력이 공란인지 확인한다.")
    @Test
    public void nameTestInValid() {
        String name = "ppppppp";

        String[] names = racing.validCarName(name);

        assertThat(names).isEqualTo(new String[INIT_NUMBER]);
    }

    @DisplayName("자동차 객체의 이름 변수에 접근할 수 있는지 확인한다.")
    @Test
    public void nameCheck() {
        String name = "mice";

        cars.addCar(new String[]{"mice"},INIT_NUMBER);
        String result = cars.lookUpName(0);

        assertThat(name).isEqualTo(result);
    }

    @DisplayName("자동차 객체의 거리 변수에 접근할 수 있는지 확인한다.")
    @Test
    public void locationCheck() {
        int location = 0;

        cars.addCar(new String[]{"mice"},INIT_NUMBER);
        int result = cars.lookUpLocation(0);

        assertThat(location).isEqualTo(result);
    }

    @DisplayName("자동차들이 간 거리 중 최대 거리가 제대로 구해졌는지 확인한다.")
    @Test
    public void maxValueCheck() {
        int carLength = 3;
        int expected = 5;

        cars.addCar(new String[]{"mice"},2); // 원래는 한꺼번에 추가하기 위해 문자열 배열을 쓰지만
        cars.addCar(new String[]{"frog"},3); // 서로 다른 로케이션 값을 추가하기 위해 따로 작성한다.
        cars.addCar(new String[]{"front"},5);
        int result = cars.maxLocation(carLength);

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("자동차들이 간 거리 중 최대 거리가 제대로 구해졌는지 확인한다.")
    @Test
    public void sizeCheck() {
        int expected = 3;

        cars.addCar(new String[]{"mice"},2); // 원래는 한꺼번에 추가하기 위해 문자열 배열을 쓰지만
        cars.addCar(new String[]{"frog"},3); // 서로 다른 로케이션 값을 추가하기 위해 따로 작성한다.
        cars.addCar(new String[]{"front"},5);
        int result = cars.lookUpLength();

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("자동차 객체에 저장된 거리 변수만큼 문자열이 출력되는지 확인한다.")
    @Test
    public void printLocationCheck() {
        String locate = "--";

        Car car = new Car(2,"mice");
        StringBuilder result = car.printLocation();

        assertThat(locate).isEqualTo(result.toString());
    }

    @DisplayName("최대 거리를 간 자동차들이 제대로 기록되었는지 확인한다.")
    @Test
    public void maxValueCarListCheck() {
        List<String> expected = List.of(new String[]{"frog", "front"});

        cars.addCar(new String[]{"mice"},2); // 원래는 한꺼번에 추가하기 위해 문자열 배열을 쓰지만
        cars.addCar(new String[]{"frog"},5); // 다른 로케이션 값을 추가하기 위해 따로 작성한다.
        cars.addCar(new String[]{"front"},5);

        List<String> result = racing.searchWinner(5);

        assertThat(expected).isEqualTo(result);
    }

    @DisplayName("특정 입력값을 주었을 때 자동차가 전진하여 거리가 늘어나는지 확인한다.")
    @Test
    public void forwardCheck() {
        int before = 2;
        int threshold = 4;
        int expected = 3;

        Car car = new Car(before,"mice");
        car.forward(threshold);

        assertThat(expected).isEqualTo(car.getLocation());
    }
}
