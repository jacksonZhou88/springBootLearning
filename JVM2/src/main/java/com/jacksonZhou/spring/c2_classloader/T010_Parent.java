package com.jacksonZhou.spring.c2_classloader;

public class T010_Parent {
    private static com.mashibing.jvm.c2_classloader.T006_MSBClassLoader parent = new com.mashibing.jvm.c2_classloader.T006_MSBClassLoader();

    private static class MyLoader extends ClassLoader {
        public MyLoader() {
            super(parent);
        }
    }
}
