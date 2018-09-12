package ui;

import annotation.ITable;
import org.openqa.selenium.WebElement;

public class Table extends Element implements ITable {
    private WebElement webElement;

    public Table(WebElement webElement) {
        super(webElement);
        this.webElement = getWrappedElement();
    }

    @Override
    public void superClick() {
        webElement.click();
    }
}
