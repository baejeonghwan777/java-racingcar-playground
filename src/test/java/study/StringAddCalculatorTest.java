package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    StringAddCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new StringAddCalculator();
    }

    @DisplayName("빈 문자 혹은 널이 왔을 때 제대로 0이 반환되는지 확인한다.")
    @Test
    public void nullAndEmptyTest() {
        int expected = 0; // give

        int result = calculator.splitAndSum(null); // when

        assertThat(result).isEqualTo(expected); // then


        result = calculator.splitAndSum(""); // when

        assertThat(result).isEqualTo(expected); // then
    }

    @DisplayName("숫자 하나만 입력되었을 때 제대로 반환되는지 확인한다.")
    @Test
    public void oneNumberTest() {
        int expected = 1; // give

        int result = calculator.splitAndSum("1"); // when

        assertThat(result).isEqualTo(expected); // then
    }

    @DisplayName("숫자 그리고 쉼표 구분자가 입력되었을 때 제대로 반환되는지 확인한다.")
    @Test
    public void restDelimiterTest() {
        int expected = 3; // give

        int result = calculator.splitAndSum("1,2"); // when

        assertThat(result).isEqualTo(expected); // then
    }

    @DisplayName("숫자 그리고 콜론 구분자가 입력되었을 때 제대로 반환되는지 확인한다.")
    @Test
    public void colonDelimiterTest() {
        int expected = 3; // give

        int result = calculator.splitAndSum("1:2"); // when

        assertThat(result).isEqualTo(expected); // then
    }

    @DisplayName("숫자 그리고 쉼표, 콜론 구분자가 입력되었을 때 제대로 반환되는지 확인한다.")
    @Test
    public void complexDelimiterTest() {
        int expected = 6; // give

        int result = calculator.splitAndSum("1,2:3"); // when

        assertThat(result).isEqualTo(expected); // then
    }

    @DisplayName("숫자 그리고 커스텀 구분자가 입력되었을 때 제대로 반환되는지 확인한다.")
    @Test
    public void customDelimiterTest() {
        int expected = 6; // give

        int result = calculator.splitAndSum("//;\n1;2;3"); // when

        assertThat(result).isEqualTo(expected); // then
    }

    @DisplayName("음수 값이 들어갔을 때 런타임 오류를 반환하는지 확인한다.")
    @Test
    public void negativeRuntimeTest() {
        assertThatThrownBy(() -> calculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

}
