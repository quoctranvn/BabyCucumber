package com.qt.core.config.driver.selenium;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DriverConfig {

    private boolean maximize = false;
    private int width;
    private int height;
    private int implicitlyWait;
    private int pageLoadTimeout;
    private int scriptTimeout;

    public DriverConfig() {
        this.width = 0;
        this.height = 0;
        this.implicitlyWait = 10;
        this.pageLoadTimeout = 10;
        this.scriptTimeout = 10;
    }

    protected void manage(final WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(scriptTimeout, TimeUnit.SECONDS);
        driver.manage().window().setPosition(new Point(0, 0));

        if (implicitlyWait > 0) {
            driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
        }

        if (maximize) {
            driver.manage().window().maximize();
        }

        if (height > 0 && width > 0 && !maximize) {
            driver.manage().window().setSize(new Dimension(width, height));
        }
    }

    public boolean isMaximize() {
        return maximize;
    }

    public void setMaximize(boolean maximize) {
        this.maximize = maximize;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width < 0 ? 0 : width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height < 0 ? 0 : height;
    }

    public int getImplicitlyWait() {
        return implicitlyWait;
    }

    public void setImplicitlyWait(int implicitlyWait) {
        this.implicitlyWait = implicitlyWait < 0 ? 0 : implicitlyWait;
    }

    public int getPageLoadTimeout() {
        return pageLoadTimeout;
    }

    public void setPageLoadTimeout(int pageLoadTimeout) {
        this.pageLoadTimeout = pageLoadTimeout < 0 ? 0 : pageLoadTimeout;
    }

    public int getScriptTimeout() {
        return scriptTimeout;
    }

    public void setScriptTimeout(int scriptTimeout) {
        this.scriptTimeout = scriptTimeout < 0 ? 0 : scriptTimeout;
    }

}
