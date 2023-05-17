package sky.pro.calculator.service;

import org.springframework.stereotype.Service;
import sky.pro.calculator.exception.DivByZeroException;

@Service
public class CalculatorService {

    public int calculatorPlus(int numFirst, int numTwo) {

        int sum = numFirst + numTwo;
        return sum;
    }

    public int calculatorMinus(int numFirst, int numTwo) {

        int min = numFirst - numTwo;
        return min;
    }

    public int calculatorMultiply(int numFirst, int numTwo) {

        int mult = (numFirst*numTwo);
        return mult;
    }

    public int calculatorDivide(int numFirst, int numTwo) {

        if (numTwo == 0) {
            throw new DivByZeroException();
        }
        return numFirst/numTwo;
    }
}
