package sky.pro.calculator.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import sky.pro.calculator.exception.DivByZeroException;

import java.util.stream.Stream;

public class CalculatorServiceParametrTest {


    private final CalculatorService calculatorService = new CalculatorService();

    public static Stream<Arguments> plusParams() {

        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(2, 2, 4)
        );
    }

    public static Stream<Arguments> divideNegativeParams() {

        return Stream.of(
                Arguments.of(1, 0),
                Arguments.of(-1, 0)
        );
    }

    public static Stream<Arguments> divideParams() {

        return Stream.of(
                Arguments.of(6, 2, 3),
                Arguments.of(2, 2, 1)
        );
    }

    public static Stream<Arguments> multiplyParams() {

        return Stream.of(
                Arguments.of(1, 2, 2),
                Arguments.of(2, 2, 4)
        );
    }


    public static Stream<Arguments> minusParams() {

        return Stream.of(
                Arguments.of(1, 2, -1),
                Arguments.of(2, 2, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("plusParams")
    public void plusTest(int a, int b, int expected) {

        Assertions.assertThat(calculatorService.calculatorPlus(a, b)).isEqualTo(expected);

    }


    @ParameterizedTest
    @MethodSource("minusParams")
    public void minusTest(int a, int b, int expected) {

        Assertions.assertThat(calculatorService.calculatorMinus(a, b)).isEqualTo(expected);

    }

    @ParameterizedTest
    @MethodSource("multiplyParams")
    public void multiplyTest(int a, int b, int expected) {

        Assertions.assertThat(calculatorService.calculatorMultiply(a, b)).isEqualTo(expected);

    }

    @ParameterizedTest
    @MethodSource("divideParams")
    public void divideTest(int a, int b, int expected) {

        Assertions.assertThat(calculatorService.calculatorDivide(a, b)).isEqualTo(expected);


    }

    @ParameterizedTest
    @MethodSource("divideNegativeParams")
    public void divideNegativeTest(int a, int b) {

        Assertions.assertThatExceptionOfType(DivByZeroException.class).isThrownBy(() -> calculatorService.calculatorDivide(a, b));


    }

}
