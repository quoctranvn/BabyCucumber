package com.qt.core.config.element.widget;

import com.qt.core.config.element.ElementImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TableImpl extends ElementImpl implements Table {
    public TableImpl(WebElement webElement) {
        super(webElement);
    }

    @Override
    public int getRowCount() {
        return getRows().size();
    }

    @Override
    public int getColumnCount() {
        return findElement(By.cssSelector("tr")).findElements(
                By.cssSelector("*")).size();
    }

    @Override
    public WebElement getCellAtIndex(int rowIdx, int colIdx) {
        // Get the row at the specified index
        WebElement row = getRows().get(rowIdx);

        List<WebElement> cells;

        // Cells are most likely to be td tags
        if ((cells = row.findElements(By.tagName("td"))).size() > 0) {
            return cells.get(colIdx);
        }
        // Failing that try th tags
        else if ((cells = row.findElements(By.tagName("th"))).size() > 0) {
            return cells.get(colIdx);
        } else {
            final String error = String
                    .format("Could not find cell at row: %s column: %s",
                            rowIdx, colIdx);
            throw new RuntimeException(error);
        }
    }

    private List<WebElement> getRows() {
        List<WebElement> rows = new ArrayList<>();

        //Header rows
        rows.addAll(findElements(By.cssSelector("thead tr")));

        //Body rows
        rows.addAll(findElements(By.cssSelector("tbody tr")));

        //Footer rows
        rows.addAll(findElements(By.cssSelector("tfoot tr")));

        return rows;
    }
}
