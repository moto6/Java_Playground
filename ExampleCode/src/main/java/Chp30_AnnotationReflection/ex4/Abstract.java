package Chp30_AnnotationReflection.ex4;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

class Node {
    public Node() {
    }

    public void print() {
        System.out.println("Hello world");
    }
}

public class Abstract {
    public Abstract() {
        try {
            // 멤버 변수를 취득
            for (Field field : AnnotationExample.class.getDeclaredFields()) {
                // DependancyInjection 어노테이션을 취득
                DependencyInjection anno = field.getDeclaredAnnotation(DependencyInjection.class);

                if (anno != null) {
                    // 접근 제한자 무시
                    field.setAccessible(true);
                    // value 함수 값 취득
                    Class<?> clz = anno.value();
                    Constructor<?> constructor;

                    if (clz == Object.class) {
                        // 멤버 변수의 타입을 취득
                        clz = field.getType();
                    }

                    constructor = clz.getConstructor();
                    // 값에 넣는다.
                    field.set(this, constructor.newInstance());
                }

            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
