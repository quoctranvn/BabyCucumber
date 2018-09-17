package com.qt.core.config.element;

import com.qt.core.config.element.factory.internal.ImplementedBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Locatable;
import org.openqa.selenium.internal.WrapsElement;

@SuppressWarnings("deprecation")
@ImplementedBy()
public interface Element extends WebElement, WrapsElement, Locatable {

}
