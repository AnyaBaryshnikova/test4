package org.example.steps;

import org.example.managers.PageManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.И;

public class MortagePageStep {

    private final PageManager pageManager = PageManager.getPageManager();


    @И("^Проверяем что открылась страница 'Ипотеки на вторичное жилье'$")
    public void checkOpenMortagePage() {
        pageManager.getMortagePage().checkOpenMortagePage();
    }

    @И("^Заполняем поля со слайдером:$")
    public void fillSliderFields(DataTable mapFieldsAndValue) {
        mapFieldsAndValue.asMap(String.class, String.class).forEach((key, value) ->
                pageManager.getMortagePage().fillSliderInput((String) key, (String) value));
    }

    @И("^Заполняем поля с радиобатоном:$")
    public void fillRadioFields(DataTable mapFieldsAndValue) {
        mapFieldsAndValue.asMap(String.class, String.class).forEach((key, value) ->
                pageManager.getMortagePage().fillRaioBtns((String) key, (String) value));
    }

    @И("^Проверяем значение полей:$")
    public void fillFields(DataTable mapFieldsAndValue) {
        mapFieldsAndValue.asMap(String.class, String.class).forEach((key, value) ->
                pageManager.getMortagePage().checkFields((String) key, (String) value));


    }
}