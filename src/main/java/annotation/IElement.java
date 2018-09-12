package annotation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Locatable;
import org.openqa.selenium.internal.WrapsElement;
import ui.Element;

@ImplementedBy(Element.class)
public interface IElement extends WebElement, WrapsElement, Locatable {

}
