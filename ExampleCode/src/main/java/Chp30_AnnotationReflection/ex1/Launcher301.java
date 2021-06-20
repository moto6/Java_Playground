package Chp30_AnnotationReflection.ex1;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
enum TestType {FIRST, FINAL}

@Retention(RetentionPolicy.RUNTIME)//런타임에만 사용하도록
@interface TestInfo {
    int count() default 1;
    String testBy();
    String[] testTools() default {"TESTUnit", "JUint5", "PainKiller"};
    TestType testType() default TestType.FIRST;
    Date testDate();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Date {
    String yyyymmdd();
}

@TestInfo(testBy = "Dong", testDate = @Date(yyyymmdd = "20210619"))
public class Launcher301 {
    public static void main(String[] args) {
        Class<Launcher301> lan301class = Launcher301.class;
        TestInfo annotationTestInfo = lan301class.getAnnotation(TestInfo.class);

        System.out.println("testBy = " + annotationTestInfo.testBy());
        System.out.println("testDate = " + annotationTestInfo.testDate().yyyymmdd());

        for (String str : annotationTestInfo.testTools()) {
            System.out.println("testTools = " + str);
        }

        for (Annotation a : Launcher301.class.getAnnotations()) {
            System.out.println(a);
        }
        System.out.println(annotationTestInfo);
    }
}
