package Chp30_AnnotationReflection.ex4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@DepandancyInjection
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DependencyInjection {
    // 자동 생성할 클래스 타입. 기본 타입은 Object
    public Class<?> value() default Object.class;
}
