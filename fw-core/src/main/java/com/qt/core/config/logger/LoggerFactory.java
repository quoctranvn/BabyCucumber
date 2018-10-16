package com.qt.core.config.logger;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.io.Serializable;

public class LoggerFactory implements Serializable {

    private static final long serialVersionUID = 123L;

    private static LoggerFactory loggerFactory;

    private LoggerFactory () { }

    public static synchronized LoggerFactory getInstance() {
        if (loggerFactory == null) {
            loggerFactory = new LoggerFactory();
        }
        return loggerFactory;
    }

    public Logger getLogger (Class<?> cls) {
        return LogManager.getLogger(cls);
    }
}
