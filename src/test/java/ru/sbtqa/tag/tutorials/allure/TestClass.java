package ru.sbtqa.tag.tutorials.allure;

import io.qameta.allure.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class TestClass {
    private static final Logger LOG = Logger.getLogger("TestClass");
    private static final org.slf4j.Logger logger1 = LoggerFactory.getLogger(TestClass.class);


    @Before
    public void beforeTest() {
        LOG.info("Logged to allure: " + "AZAZA");
    }

    @After
    public void afterTest() {
        LOG.info("Тест завершен!");
    }


    @Step(value = "Проверка суммы числа {num1} и числа {num2}")
    public static void checkSummationStep123(int num1, int num2, int expectedSum) {
        Assert.assertTrue("Сумма слагаемых не соответствует ожидаемому значению", num1 + num2 == expectedSum);
    }

    @Test
    public void testDemoConnectionSuccess() {
        Steps.checkSumStep(3, 2, 5);
        logger1.info("ARTEM");
        LOG.warning("DADADADA2");
        Steps.logToAllure("BUGAGA");
        Assert.assertTrue("Сумма слагаемых не соответствует ожидаемому значению", 1 + 3== 4);
        Steps.logToAllure("BUGAGA123123");
        logger1.debug("123123123");
        Steps.logToAllure("BUGAGA123123");
        logger1.info("Logged to allure: " + "AZAZA");
        Assert.assertTrue(true);

    }

    @Test
    public void testDemoSteps1() {
        Steps.checkSumStep(3, 2, 5);
        Steps.checkSumStep(5, 4, 9);
    }

    @Test
    public void testDemoSteps2() {
        Steps.checkSubtractionStep(10, 8, 2);
    }

    @Test
    public void testDemoAttachments1() throws IOException {
        CommonFunctions.getBytes("picture.jpg");
        CommonFunctions.getBytes("text.txt");
        Assert.assertTrue(true);
    }

    @Test
    public void testDemoAttachments2() throws IOException {
        CommonFunctions.getBytesAnnotationWithArgs("json.json");
        Assert.assertTrue(true);
    }

    @Test
    public void testDemoAttachments3() {
        Allure.addAttachment("Ссылка", "text/plain", "http://sberbank.ru");
        Assert.assertTrue(true);
    }

    /**
     * Simple test for @Description illustration
     */
    @Test
    @Description(useJavaDoc = true)
    public void testDemoDescriptionAnnotation1() {
        Assert.assertTrue(1 == 1);
    }

    @Test
    @Description(value = "Тест проверяет эквивалентность единицы единице")
    public void testDemoDescriptionAnnotation2() {
        Assert.assertTrue(1 == 1);
    }

    @Epic(value = "Математика")
    @Feature(value = "Простые математические операции")
    @Story(value = "Сложение")
    @Test
    public void testDemoFunctionalAnnotations1() {
        Steps.checkSummationStep(5, 4, 9);
    }

    @Epic(value = "Математика")
    @Feature(value = "Простые математические операции")
    @Story(value = "Вычитание")
    @Test
    public void testDemoFunctionalAnnotations2() {
        Steps.checkSubtractionStep(8, 2, 6);
    }

    @Epics(value = {@Epic(value = "Математика"), @Epic(value = "Геометрия")})
    @Features(value = {@Feature(value = "Тригонометрия"), @Feature(value = "Простые математические операции")})
    @Stories(value = {@Story(value = "Синус"), @Story(value = "Синусоида")})
    @Test
    public void testDemoFunctionalAnnotations3() {
        Steps.checkSinStep(0, 0);
    }

    @Test
    @Flaky
    public void testDemoFlakyAnnotation() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 2);
        if (randomNum == 0) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @Test
    @Issue(value = "CQ-17197")
    public void testDemoIssueAnnotation() {
        Assert.assertTrue(1 + 2 == 4);
    }

    @Test
//    @TmsLink(value = "TL-678")
    @TmsLink(value = "1798")
    public void testDemoTmsLinkAnnotation() {
        Assert.assertTrue(1 == 1);
    }

    @Test
    @Link(name = "Ссылка", url = "http://yandex.ru")
    public void testDemoLinkAnnotation() {
        Steps.checkSubtractionStep(15, 5, 10);
    }

    @Test
    @Links(value = {@Link(name = "Ссылка1", url = "http://sberbank.ru"),
            @Link(name = "Ссылка2", url = "http://yandex.ru")})
    public void testDemoLinksAnnotation() {
        Steps.checkSubtractionStep(14, 5, 9);
    }

    //Демонстрация работы категорий. Product defects
    @Test
    public void testDemoCategories1() {
        //какие-то проверки, в результате которых тест может упасть
        Steps.checkSumStep(5, 6, 4);
    }

    //Демонстрация работы категорий. Test defects. traceRegex
    @Test
    public void testDemoCategories2() {
        //какие-то проверки, которые могут вызывать NullPointerException
        throw new NullPointerException();
    }

    //Демонстрация работы категорий. Test defects. messageRegex
    @Test
    public void testDemoCategories3() throws Exception {
        //какие-то проверки, которые могут вызывать Exception
        throw new Exception("что-то пошло не так");
    }

    @Test
    @Owner(value = "VAsilu")
    public void testDemoOwnerAnnotation() {
        Steps.checkSumStep(1, 2, 3);
    }

    @Test
    @Severity(value = SeverityLevel.BLOCKER)
    public void testDemoSeverityAnnotation() {
        Steps.checkSubtractionStep(6, 1, 5);
    }
}