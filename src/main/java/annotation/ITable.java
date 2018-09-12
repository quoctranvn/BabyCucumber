package annotation;

import ui.Table;

@ImplementedBy(Table.class)
public interface ITable extends IElement{
    void superClick();
}
