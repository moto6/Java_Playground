package Chp30_AnnotationReflection.ex2;

import java.lang.reflect.Field;

class Person {
    private String address;
    private Integer asset;
    private int age;
    private String national;
}

public class Launcher302 {
    public static void main(String[] args) {
        Object obj = new Person();
        Field[] fields = obj.getClass().getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            System.out.println(Integer.toString(i) + " ================");
            System.out.println(fields[i].getName() + ", " + fields[i].toGenericString() + ", " + fields[i].toString() + "\r\n\r\n");
        }
    }
}

