package com.qt.core.config.injection;

import com.google.inject.Injector;

public class GuiceInjectFactory {

    private volatile static ThreadLocal<GuiceInjectFactory> instance = new ThreadLocal<>();

    Injector injector;

    public static GuiceInjectFactory instance() {
        if(instance == null) {
            synchronized (GuiceInjectFactory.class) {
                if(instance.get() == null) {
                    instance.set(new GuiceInjectFactory());
                }
            }
        }
        return instance.get();
    }

    public <T> T createObjectInstance(Class<T> cls) {
        Injector injectInstance = instance.get().injector;
        return injectInstance.getInstance(cls);
    }
}
