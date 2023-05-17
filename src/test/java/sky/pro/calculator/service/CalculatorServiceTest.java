package sky.pro.calculator.service;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sky.pro.calculator.exception.DivByZeroException;
import sky.pro.calculator.service.CalculatorService;

import java.security.DigestException;


public class CalculatorServiceTest {


    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    public void plusTest() {

        Number actual = calculatorService.calculatorPlus(1, 2);
        Number expected = 3;

        Assertions.assertEquals(expected, actual);
        actual = calculatorService.calculatorPlus(4, 2);
        expected = 6;

        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void minusTest() {

        Number actual = calculatorService.calculatorMinus(1, 2);
        Number expected = -1;

        Assertions.assertEquals(expected, actual);
        actual = calculatorService.calculatorMinus(4, 2);
        expected = 2;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void multiplyTest() {
        Number actual = calculatorService.calculatorMultiply(1, 2);
        Number expected = 2;

        Assertions.assertEquals(expected, actual);
        actual = calculatorService.calculatorMultiply(4, 2);
        expected = 8;

        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void divideTest() {

        Number actual = calculatorService.calculatorDivide(6, 2);
        Number expected = 3;

        Assertions.assertEquals(expected, actual);
        actual = calculatorService.calculatorDivide(4, 2);
        expected = 2;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void NegativeDivideTest() {

        Assertions.assertThrows(DivByZeroException.class, () -> calculatorService.calculatorDivide(1, 0));
        Assertions.assertThrows(DivByZeroException.class, () -> calculatorService.calculatorDivide(-1, 0));


    }


}
