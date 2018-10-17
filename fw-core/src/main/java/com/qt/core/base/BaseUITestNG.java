package com.qt.core.base;

import com.qt.core.listeners.TestNGSuiteListener;
import com.qt.core.listeners.UiTestExecutionListener;
import org.testng.annotations.Listeners;

@Listeners({UiTestExecutionListener.class, TestNGSuiteListener.class})
public class BaseUITestNG extends BaseExecutionTestNG{
}
