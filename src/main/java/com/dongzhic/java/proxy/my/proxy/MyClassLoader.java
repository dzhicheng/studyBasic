package com.dongzhic.java.proxy.my.proxy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @Author dongzhic
 * @Date 7/12/21 5:06 PM
 */
public class MyClassLoader extends ClassLoader {

    private File dir;

    public MyClassLoader(String path) {
        dir = new File(path);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        if (dir != null) {
            File clazzFile = new File(dir, name + ".class");
            try {
                FileInputStream fis = new FileInputStream(clazzFile);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        return super.findClass(name);
    }
}
