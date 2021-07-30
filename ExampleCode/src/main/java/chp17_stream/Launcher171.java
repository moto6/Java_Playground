package chp17_stream;


import java.util.ArrayList;
import java.util.List;

public class Launcher171 {
    public static void main(String[] args) {

        List<Subject> subjectList = new ArrayList<>();
        insertDataSet(subjectList);


        // 문제1 : 문자열"spring" 으로 시작하는 Subject 를 String 으로 return 하기
        System.out.println(solution1(subjectList));

        // 문제2 : Subject의 이름만을 모아서 출력하는 String 으로 return 하기
        System.out.println(solution2(subjectList));

        // 문제3 : isClosed 가 true인것만 출력하도록 String 으로 return 하기
        System.out.println(solution3(subjectList));

        // 문제4 : priority 가 5 이상인것만 출력하도록 String 으로 return하기
        System.out.println(solution4(subjectList));
    }

    //여기에 코드를 작성하기
    private static String solution1(List<Subject> subjectList) {
        return "";
    }
    private static String solution2(List<Subject> subjectList) {
        return "";
    }
    private static String solution3(List<Subject> subjectList) {
        return "";
    }
    private static String solution4(List<Subject> subjectList) {
        return "";
    }


    private static void insertDataSet(List<Subject> subjectList) {
        subjectList.add(new Subject("spring boot 입문하기", 5,Boolean.TRUE));
        subjectList.add(new Subject("spring boot JPA", 6,Boolean.TRUE));
        subjectList.add(new Subject("DATABASE 접근 기술 JPA, JDBC Template", 4,Boolean.TRUE));
        subjectList.add(new Subject("spring 시큐리티", 7,Boolean.TRUE));
        subjectList.add(new Subject("스프링 클라우드", 3,Boolean.FALSE));
        subjectList.add(new Subject("REST API in 스프링백엔드", 2,Boolean.FALSE));
        subjectList.add(new Subject("inside 스프링 프레임워크", 8,Boolean.FALSE));
        subjectList.add(new Subject("spring 을 위한 OOP와 프레임워크 SOLID", 1,Boolean.TRUE));
        subjectList.add(new Subject("", 9,Boolean.FALSE));
    }

}


//==========  핼퍼 클래스, 데이터셋 ====

class Subject {
    String title;
    Integer priority;
    Boolean isClosed;

    public Subject(String title, Integer priority, Boolean isClosed) {
        this.title = title;
        this.priority = priority;
        this.isClosed = isClosed;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "title='" + title + '\'' +
                ", priority=" + priority +
                ", isClosed=" + isClosed +
                '}';
    }
}
