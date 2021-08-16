package org.example.managers;

import org.example.pages.MainPage;
import org.example.pages.MortagePage;

public class PageManager {
    /**
     * Менеджер страничек
     */
    private static PageManager pageManager;

    /**
     * Стартовая страничка
     */
    private MainPage mainPage;

    /**
     * Страничка вторичного жилья
     */
    private MortagePage mortagePage;

    /**
     * Конструктор специально был объявлен как private (singleton паттерн)
     */
    private PageManager() {
    }

    /**
     * Ленивая инициализация PageManager
     *
     * @return PageManager
     */
    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    /**
     * Ленивая инициализация {@link MainPage}
     *
     * @return StartPage
     */
    public MainPage getMainPage() {
        if (mainPage == null) {
            mainPage = new MainPage();
        }
        return mainPage;
    }

    /**
     * Ленивая инициализация {@link MortagePage}
     *
     * @return InsurancePage
     */
    public MortagePage getMortagePage() {
        if (mortagePage == null) {
            mortagePage = new MortagePage();
        }
        return mortagePage;
    }
}
