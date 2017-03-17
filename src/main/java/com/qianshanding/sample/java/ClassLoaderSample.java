package com.qianshanding.sample.java;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author Fish
 *         类加载 - Class.forName
 */
public class ClassLoaderSample {
    public static void main(String[] args) throws ClassNotFoundException {
        Class clzStr = Class.forName("java.lang.String");
        Method[] methods = clzStr.getDeclaredMethods();
        for (Method m : methods) {
            String mod = Modifier.toString(m.getModifiers());
            System.out.print(mod + " " + m.getName() + "(");
            Class<?>[] ps = m.getParameterTypes();
            if (ps.length == 0)
                System.out.print(')');
            for (int i = 0; i < ps.length; i++) {
                char end = i == ps.length - 1 ? ')' : ',';
                System.out.print(ps[i].getSimpleName() + end);
            }
            System.out.println();
        }
    }
}
