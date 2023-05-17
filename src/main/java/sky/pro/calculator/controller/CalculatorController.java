package sky.pro.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sky.pro.calculator.service.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    private final String localEmpty = "Не должно быть пустых значений";


    public CalculatorController(CalculatorService calculatorService) {

        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String hello() {

        return "Главная страница";
    }

    @GetMapping(path = "/calculator")
    public String calculatorHello() {

        return "Добро пожаловать в калькулятор";
    }

    @GetMapping(path = "/plus")
    public String calculatorPlus(@RequestParam("num1") String numFirst, @RequestParam("num2") String numTwo) {
        if (numFirst.isEmpty() || numTwo.isEmpty()) {

            return localEmpty;
        }
        return numFirst + " + " + numTwo + " = " + calculatorService.calculatorPlus(Integer.parseInt(numFirst), Integer.parseInt(numTwo));
    }

    @GetMapping(path = "/minus")
    public String calculatorMinus(@RequestParam("num1") String numFirst, @RequestParam("num2") String numTwo) {
        if (numFirst.isEmpty() || numTwo.isEmpty()) {

            return localEmpty;
        }
        return numFirst + " - " + numTwo + " = " + calculatorService.calculatorMinus(Integer.parseInt(numFirst), Integer.parseInt(numTwo));
    }

    @GetMapping(path = "/multiply")
    public String calculatorMultiply(@RequestParam("num1") String numFirst, @RequestParam("num2") String numTwo) {
        if (numFirst.isEmpty() || numTwo.isEmpty()) {

            return localEmpty;
        }
        return numFirst + " * " + numTwo + " = " + calculatorService.calculatorMultiply(Integer.parseInt(numFirst), Integer.parseInt(numTwo));
    }


    @GetMapping(path = "/divide")
    public String calculatorDivide(@RequestParam("num1") String numFirst, @RequestParam("num2") String numTwo) {
        if (numFirst.isEmpty() || numTwo.isEmpty()) {

            return localEmpty;
        }
        return numFirst + " / " + numTwo + " = " + calculatorService.calculatorDivide(Integer.parseInt(numFirst), Integer.parseInt(numTwo));
    }


}
