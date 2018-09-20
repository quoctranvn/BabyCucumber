package com.qt.core.helper;

public class FileHelper {

    public static String getFilePath(String name, java.io.File file) {
        java.io.File[] list = file.listFiles();
        if (list != null) {
            for (java.io.File fil : list) {
                String path;
                if (fil.isDirectory()) {
                    path = getFilePath(name, fil);
                    if (path != null) {
                        return path;
                    }
                } else if (fil.getName().contains(name)) {
                    return fil.getAbsolutePath();
                }
            }
        }
        return null;
    }
}
