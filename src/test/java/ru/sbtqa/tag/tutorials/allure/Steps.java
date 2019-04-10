package ru.sbtqa.tag.tutorials.allure;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Steps {
//    private static final Logger logger = LogManager.getLogger(Steps.class);
    static final Logger logger = LogManager.getLogger(Steps.class.getName());

    @Step
    public static void checkSumStep(int num1, int num2, int expectedSum) {
        Assert.assertTrue("Сумма слагаемых не соответствует ожидаемому значению", num1 + num2 == expectedSum);
    }

    @Step(value = "Проверка суммы числа {num1} и числа {num2}")
    public static void checkSummationStep(int num1, int num2, int expectedSum) {
        Assert.assertTrue("Сумма слагаемых не соответствует ожидаемому значению", num1 + num2 == expectedSum);
    }

    @Step(value = "Проверка разности числа {num1} и числа {num2}")
    public static void checkSubtractionStep(int num1, int num2, int expectedResult) {
        Assert.assertTrue("Результат вычитания не соответствует ожидаемому значению", num1 - num2 == expectedResult);
    }

    @Step(value = "Проверка синуса числа {num}")
    public static void checkSinStep(int num, double expectedResult) {
        Assert.assertTrue("Результат выражения не соответствует ожидаемому значению", Math.sin(num) == expectedResult);
    }


    @Step("{log}")
    public static void logToAllure(String log) {
        logger.debug("Logged to allure: " + log);
        logger.debug("Logged to allure: "  +  log);
    }
}
