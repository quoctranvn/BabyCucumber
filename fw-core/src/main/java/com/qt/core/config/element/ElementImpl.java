package com.qt.core.config.element;

import com.qt.core.config.logger.LoggerFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;

import java.util.List;

public class ElementImpl implements Element {
    Logger log = LoggerFactory.getInstance().getLogger(getClass());

    private final WebElement webElement;

    public ElementImpl(final WebElement webElement) {
        this.webElement = webElement;
    }

    @Override
    public void click() {
        webElement.click();
    }

    @Override
    public void submit() {
        webElement.submit();
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        webElement.sendKeys(charSequences);
    }

    @Override
    public void clear() {
        webElement.clear();
    }

    @Override
    public String getTagName() {
        return webElement.getTagName();
    }

    @Override
    public String getAttribute(String s) {
        return webElement.getAttribute(s);
    }

    @Override
    public boolean isSelected() {
        return webElement.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return webElement.isEnabled();
    }

    @Override
    public String getText() {
        return webElement.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return webElement.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return webElement.findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return webElement.getLocation();
    }

    @Override
    public Dimension getSize() {
        return webElement.getSize();
    }

    @Override
    public Rectangle getRect() {
        return webElement.getRect();
    }

    @Override
    public String getCssValue(String s) {
        return webElement.getCssValue(s);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return webElement.getScreenshotAs(outputType);
    }

    @SuppressWarnings("deprecation")
    @Override
    public Coordinates getCoordinates() {
        return ((Locatable) webElement).getCoordinates();
    }

    @Override
    public WebElement getWrappedElement() {
        return webElement;
    }
}
