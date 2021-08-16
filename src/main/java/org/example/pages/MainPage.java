package org.example.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {

    // кнопка закрытия кукис
    @FindBy(xpath = "//button[@class='kitt-cookie-warning__close']")
    WebElement cookiesCloseBtn;

    // меню
    @FindBy(xpath = "//li[contains(@class,'kitt-top-menu__item_first')]/a[@role or @aria-expanded]")
    private List<WebElement> listMenu;

    // подменю
    @FindBy(xpath = "//a[@data-cga_click_top_menu]")
    private List<WebElement> listSubMenu;


    /**
     * Закрываем кукис
     *
     * @return возвращаем ту же страничку
     */
    public MainPage closeCookiesDialog() {
        waitUtilElementToBeClickable(cookiesCloseBtn).click();
        return this;
    }

    /**
     * Выбираем пунк меню
     *
     * @param nameMenu - название менб
     * @return возвращаем ту же страничку
     */
    public MainPage selectMenu(String nameMenu) {
        for (WebElement menuItem : listMenu) {
            if (menuItem.getText().trim().equalsIgnoreCase(nameMenu)) {
                waitUtilElementToBeClickable(menuItem).click();
                return this;
            }
        }
        Assert.fail("Меню '" + nameMenu + "' не было найдено на стартовой странице!");
        return this;
    }

    /**
     * Выбираем пункт подменю
     *
     * @param nameSubMenu - наименование подменю
     * @return переходим на страничку c ипотекой на вторичное жилье
     */
    public MortagePage selectSubMenu(String nameSubMenu) {
        for (WebElement menuItem : listSubMenu) {
            if (menuItem.getText().equalsIgnoreCase(nameSubMenu)) {
                waitUtilElementToBeClickable(menuItem).click();
                return pageManager.getMortagePage().checkOpenMortagePage();
            }
        }
        Assert.fail("Подменю '" + nameSubMenu + "' не было найдено на стартовой странице!");
        return pageManager.getMortagePage();
    }
}

