package com.qt.core.config.element.widget;

import com.qt.core.config.element.ElementImpl;
import org.openqa.selenium.WebElement;

public class CheckBoxImpl extends ElementImpl implements CheckBox {
    private final WebElement webElement;

    public CheckBoxImpl(WebElement webElement) {
        super(webElement);
        this.webElement = getWrappedElement();
    }


    @Override
    public void toggle() {
        webElement.click();
    }

    @Override
    public void check() {
        if (!isChecked())
            toggle();
    }

    @Override
    public void uncheck() {
        if (isChecked())
            toggle();
    }

    @Override
    public boolean isChecked() {
        return webElement.isSelected();
    }
}
