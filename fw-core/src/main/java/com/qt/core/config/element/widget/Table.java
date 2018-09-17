package com.qt.core.config.element.widget;

import com.qt.core.config.element.Element;
import com.qt.core.config.element.factory.internal.ImplementedBy;
import org.openqa.selenium.WebElement;

@ImplementedBy(TableImpl.class)
interface Table extends Element {

    int getRowCount();

    int getColumnCount();

    WebElement getCellAtIndex(int rowIdx, int colIdx);

}
