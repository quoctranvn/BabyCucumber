package com.qt.core.config.injection;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class GuiceInjectFactory {

    private volatile static GuiceInjectFactory instance;

    private Injector injector;

    public static GuiceInjectFactory instance() {
        if(instance == null) {
            synchronized (GuiceInjectFactory.class) {
                if(instance == null) {
                    instance = new GuiceInjectFactory();
                }
            }
        }
        return instance;
    }

    public void createInject(Module...modules) {
        injector = Guice.createInjector(modules);
    }
}
