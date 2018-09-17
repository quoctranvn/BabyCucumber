package com.qt.core.config.element.widget;

import com.qt.core.config.element.ElementImpl;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SelectImpl extends ElementImpl implements Select {
    private final org.openqa.selenium.support.ui.Select select;

    public SelectImpl(WebElement webElement) {
        super(webElement);
        this.select = new org.openqa.selenium.support.ui.Select(webElement);
    }

    @Override
    public boolean isMultiple() {
        return select.isMultiple();
    }

    @Override
    public void deselectByIndex(int index) {
        select.deselectByIndex(index);
    }

    @Override
    public void selectByValue(String value) {
        select.selectByValue(value);
    }

    @Override
    public WebElement getFirstSelectedOption() {
        return select.getFirstSelectedOption();
    }

    @Override
    public void selectByVisibleText(String text) {
        select.selectByVisibleText(text);
    }

    @Override
    public void deselectByValue(String value) {
        select.deselectByValue(value);
    }

    @Override
    public void deselectAll() {
        select.deselectAll();
    }

    @Override
    public List<WebElement> getAllSelectedOptions() {
        return select.getAllSelectedOptions();
    }

    @Override
    public List<WebElement> getOptions() {
        return select.getOptions();
    }

    @Override
    public void deselectByVisibleText(String text) {
        select.deselectByVisibleText(text);
    }

    @Override
    public void selectByIndex(int index) {
        select.selectByIndex(index);
    }
}
