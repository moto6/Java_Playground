package Chp30_AnnotationReflection.ex3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class RelfectionTest {
    // private field!!
    private final String s;

    public RelfectionTest() {
        s = "This is a default value";
    }

    public void printString() {
        System.out.println(s);
    }
}

public class Launcher303 {
    public static void main(String[] args) throws Exception {
        RelfectionTest obj = new RelfectionTest();

        // getting class object
        Class woodyClass = obj.getClass();
        System.out.println("The name of class is " +
                woodyClass.getName());

        // getting constructor
        Constructor constructor = woodyClass.getConstructor();
        System.out.println("The name of constructor is " +
                constructor.getName());

        // getting methods
        Method[] methods = woodyClass.getMethods();
        for (Method method : methods)
            System.out.println("The name of method is " + method.getName());
        Method printString = woodyClass.getDeclaredMethod("printString");

        // invokes the method at runtime
        printString.invoke(obj);

        // getting private field 👀
        Field field = woodyClass.getDeclaredField("s");

        field.setAccessible(true);

        // trying to reset the value
        field.set(obj, "reset the private field value");

        // invokes the method at runtime
        printString.invoke(obj);

    }
}
