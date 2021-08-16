package org.example.steps;

import io.cucumber.java.ru.И;
import org.example.managers.PageManager;

public class MainPageStep {

    private final PageManager pageManager = PageManager.getPageManager();

    @И("^Закрываем сообщения cookies$")
    public void closeCookiesDialog() {
        pageManager.getMainPage().closeCookiesDialog();
    }

    @И("^Выбираем \"(.+)\" в главном меню$")
    public void selectBaseMenu(String nameMenu) {
        pageManager.getMainPage().selectMenu(nameMenu);
    }

    @И("^Выбираем \"(.+)\" в подменю главного меню$")
    public void closeCookiesDialog(String nameSubMenu) {
        pageManager.getMainPage().selectSubMenu(nameSubMenu);
    }

}