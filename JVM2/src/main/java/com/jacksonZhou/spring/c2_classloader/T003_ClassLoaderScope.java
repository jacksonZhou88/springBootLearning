package com.jacksonZhou.spring.c2_classloader;

import java.util.Properties;
import java.util.Set;

public class T003_ClassLoaderScope {
    public static void main(String[] args) {

        Properties p = System.getProperties();
        Set s = p.keySet();
        s.forEach((o) -> System.out.println(o + " === " + p.get(o)));
//        String pathBoot = System.getProperty("sun.boot.class.path");
//        System.out.println(pathBoot.replaceAll(";", System.lineSeparator()));
//
//        System.out.println("--------------------");
//        String pathExt = System.getProperty("java.ext.dirs");
//        System.out.println(pathExt.replaceAll(";", System.lineSeparator()));
//
//        System.out.println("--------------------");
//        String pathApp = System.getProperty("java.class.path");
//        System.out.println(pathApp.replaceAll(";", System.lineSeparator()));
    }
}
