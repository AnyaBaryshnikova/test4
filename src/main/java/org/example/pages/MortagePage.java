package org.example.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MortagePage extends BasePage {

    // Заголовок
    @FindBy(xpath = "//h1")
    WebElement title;

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


    /**
     * Проверка открытия странички ипотеки на вторичное жилье
     *
     * @return возвращаем ту же страничку
     */
    @Step("Проверям, что открылась страница с ипотекой на вторичное жилье")
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
    @Step("Заполняем поле {name} значением {value}")
    public MortagePage fillSliderInput(String name, String value) {
        switch (name) {
            case "Стоимость жилья":
                fillSlider(estatePrice, value);
                break;
            case "Первоначальный взнос":
                fillSlider(initialFee, value);
                break;
            case "Срок кредита":
                fillSlider(creditTerm, value);
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
    @Step("Отмечаем кнопку {name} значением {value}")
    public MortagePage fillRaioBtns(String name, String value) {
        boolean bool = Boolean.parseBoolean(value);
        switch (name) {
            case "Молодая семья":
                fillRadios(newFamily, bool);
                break;
            case "Страхование жизни":
                fillRadios(lifeInsurance, bool);
                break;

            default:
                Assert.fail("Поле с наименованием '" + name + "' отсутствует на странице");
        }

        return this;
    }


    //проверяем значения

    @Step("Проверяем значение поля {name} на соответствие сумме {value}")
    public MortagePage checkFields(String name, String value) {
        double val = Double.parseDouble(value);
        switch (name) {
            case "Сумма кредита":
                checkFields(creditSum, (int)val);
                break;
            case "Ежемесячный платеж":
                checkFields(mounthlyPayment, (int)val);
                break;
            case "Необходимый доход":
                checkFields(incomeRequired, (int)val);
                break;
            case "Процентная ставка":
                checkFields(inrestRate, val);
                break;
            default:
                Assert.fail("Поле с наименованием '" + name + "' отсутствует на странице");
        }

        return this;
    }

}
