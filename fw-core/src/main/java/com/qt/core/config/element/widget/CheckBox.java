package com.qt.core.config.element.widget;


import com.qt.core.config.element.Element;
import com.qt.core.config.element.factory.internal.ImplementedBy;

@ImplementedBy(CheckBoxImpl.class)
public interface CheckBox extends Element {

    void toggle();

    void check();

    void uncheck();

    boolean isChecked();

}
