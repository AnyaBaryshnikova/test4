package org.example.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MortagePage extends BasePage {

    // Заголовок
    @FindBy(xpath = "//h1")
    WebElement title;

    @FindBy(xpath = "//iframe[@id='iFrameResizer0']")
    WebElement frame;

    // Стоимость недвижимости
    @FindBy(xpath = "//div[contains(text(), 'Стоимость недвижимости')]/../input")
    WebElement estatePrice;

    //Первоначальный взнос
    @FindBy(xpath = "//div[contains(text(), 'Первоначальный взнос')]/../input")
    WebElement initialFee;

    // Срок кредита
    @FindBy(xpath = "//div[contains(text(), 'Срок кредита')]/../input")
    WebElement creditTerm;

    //Страхование жизни
    @FindBy(xpath = "//span[text() = 'Страхование жизни и здоровья']/../..//input")
    WebElement lifeInsurance;

    // Молодая семья
    @FindBy(xpath = "//span[text() = 'Молодая семья']/../..//input")
    WebElement newFamily;

    //Сумма кредита
    @FindBy(xpath = "//div[@data-test-id='main-results-block']//span[text() = 'Сумма кредита']/../span/span")
    WebElement creditSum;

    //Ежемесячный платеж
    @FindBy(xpath = "//div[@data-test-id='main-results-block']//span[text() = 'Ежемесячный платеж']/../span/span")
    WebElement mounthlyPayment;

    //Необходимы доход
    @FindBy(xpath = "//div[@data-test-id='main-results-block']//span[text() = 'Необходимый доход']/../span/span")
    WebElement incomeRequired;

    //Процентная ставка
    @FindBy(xpath = "//div[@data-test-id='main-results-block']//span[text() = 'Процентная ставка']/../span/span")
    WebElement inrestRate;

    private String payment = "";


    /**
     * Проверка открытия странички ипотеки на вторичное жилье
     *
     * @return возвращаем ту же страничку
     */
    public MortagePage checkOpenMortagePage() {

        //waitUtilElementToBeVisible(title);
        wait.until(ExpectedConditions.attributeContains(title, "class", "kit-heading kit-heading_l product-teaser-full-width__header"));
        return this;
    }

    //заполняем поля

    /**
     * Заполнение полей
     *
     * @param name  название поля
     * @param value значение
     * @return
     */
    public MortagePage fillSliderInput(String name, String value) {
        switchToFrame();
        payment = mounthlyPayment.getText();

        switch (name) {
            case "Стоимость жилья":
                fillSlider(estatePrice, value);
                wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(mounthlyPayment, payment)));
                break;
            case "Первоначальный взнос":
                fillSlider(initialFee, value);
                wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(mounthlyPayment, payment)));
                break;
            case "Срок кредита":
                fillSlider(creditTerm, value);
                wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(mounthlyPayment, payment)));
                break;

            default:
                Assert.fail("Поле с наименованием '" + name + "' отсутствует на странице");
        }

        return this;
    }


    /**
     * Заполнение радоибатонов
     *
     * @param name  название
     * @param value должна ли кнопка быть нажата
     * @return
     */
    public MortagePage fillRaioBtns(String name, String value) {
        switchToFrame();
        payment = mounthlyPayment.getText();

        boolean bool = Boolean.parseBoolean(value);
        switch (name) {
            case "Молодая семья":
                fillRadios(newFamily, bool);
                //wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(mounthlyPayment, payment)));
                break;
            case "Страхование жизни":
                fillRadios(lifeInsurance, bool);
                //wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(mounthlyPayment, payment)));
                break;

            default:
                Assert.fail("Поле с наименованием '" + name + "' отсутствует на странице");
        }

        return this;
    }


    //проверяем значения

    public MortagePage checkFields(String name, String value) {
        switchToFrame();
        double val = Double.parseDouble(value);
        switch (name) {
            case "Сумма кредита":
                checkFields(creditSum, (int) val);
                break;
            case "Ежемесячный платеж":
                checkFields(mounthlyPayment, (int) val);
                break;
            case "Необходимый доход":
                checkFields(incomeRequired, (int) val);
                break;
            case "Процентная ставка":
                checkFields(inrestRate, val);
                break;
            default:
                Assert.fail("Поле с наименованием '" + name + "' отсутствует на странице");
        }

        return this;
    }

    private void switchToFrame() {
        if (!frameFlag) {
            driverManager.getDriver().switchTo().frame(frame);
            frameFlag = true;
        }
    }

}


