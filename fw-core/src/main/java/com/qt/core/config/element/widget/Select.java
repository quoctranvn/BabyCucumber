package com.qt.core.config.element.widget;

import com.qt.core.config.element.Element;
import com.qt.core.config.element.factory.internal.ImplementedBy;
import org.openqa.selenium.WebElement;

import java.util.List;

@ImplementedBy(SelectImpl.class)
interface Select extends Element {

    boolean isMultiple();

    void deselectByIndex(int index);

    void selectByValue(String value);

    WebElement getFirstSelectedOption();

    void selectByVisibleText(String text);

    void deselectByValue(String value);

    void deselectAll();

    List<WebElement> getAllSelectedOptions();

    List<WebElement> getOptions();

    void deselectByVisibleText(String text);

    void selectByIndex(int index);

}
