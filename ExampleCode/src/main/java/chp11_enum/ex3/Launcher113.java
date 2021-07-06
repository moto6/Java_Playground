package chp11_enum.ex3;

public class Launcher113 {

    public static void main(String[] args) {
//
        // 간단한 이넘 필드변수의 사용 예시
        WhiteshipLectureList myWish = WhiteshipLectureList.REST_API;
        System.out.printf("제가 원하는 강의 코드는 %s이고 가격은 %d 입니다 \n(설명 : %s)\n\n", myWish.name(), myWish.getPrice(), myWish.getKoreanDescription());
        WhiteshipLectureList seven = WhiteshipLectureList.SPRING_SECURITY;

        //Enum의 생성자가 호출되는 시점을 알아내기 위해, 강의 가격별 조회
        int maxi = 120000; //12만원
        int mini = 70000; //7만원

        WhiteshipLectureList[] lectureArray = WhiteshipLectureList.values();
        for (WhiteshipLectureList lec : lectureArray) {
            int curPrice = lec.getPrice();


            if ((mini <= curPrice) && (curPrice <= maxi)) {
                System.out.printf("가격 %d 짜리인 강의의의 주제는 %s 입니다\n\n", lec.getPrice(), lec.getKoreanDescription());

            }
        }

        WhiteshipLectureList one = WhiteshipLectureList.REST_API;
        WhiteshipLectureList two = WhiteshipLectureList.INTERVIEW_GUIDE_SOFTWARE_DEVELOPMENT_ENGINEER;
        WhiteshipLectureList three = WhiteshipLectureList.SPRING_BOOT_UPDATED;
        WhiteshipLectureList four = WhiteshipLectureList.SPRING_FRAMEWORK_INTRODUCTION_REVISED_EDITION;
        WhiteshipLectureList five = WhiteshipLectureList.SPRING_FRAMEWORK_WEB_MVC;
        WhiteshipLectureList six = WhiteshipLectureList.REST_API;


        int test = one.ordinal() + two.getPrice() + three.ordinal() + seven.ordinal();
        System.out.println(Integer.toString(test * five.getPrice()) + "뭐지..");
    }
}


enum WhiteshipLectureList {
    THE_JAVA_JAVA_8(55000, "더 자바, Java8"),
    THE_JAVA_CODE_MANIPULATION(49500, "더 자바, 코드를 조작하는 다양한 방법"),
    THE_JAVA_APPLICATION_TEST(66000, "더 자바, 애플리케이션을 테스트하는 다양한 방법"),
    SPRING_FRAMEWORK_INTRODUCTION(0, "스프링 프레임워크 입문"),
    SPRING_FRAMEWORK_INTRODUCTION_REVISED_EDITION(0, "예제로 배우는 스프링 입문(개정판)"),
    SPRING_FRAMEWORK_CORE(55000, "스프링 프레임워크 핵심 기술"),
    SPRING_FRAMEWORK_WEB_MVC(110000, "스프링 웹 MVC"),
    SPRING_BOOT(110000, "스프링 부트 개념과 활용"),
    SPRING_BOOT_UPDATED(66000, "스프링 부트 업데이트"),
    SPRING_AND_JPA_BASED_WEB_APPLICATION_DEVELOPMENT(330000, "스프링과 JPA 기반 웹 애플리케이션 개발"),
    SPRING_SECURITY(88000, "스프링 시큐리티"),
    REST_API(99000, "스프링 기반 REST API 개발"),
    SPRING_DATA_JPA(88000, "스프링 데이터 JPA"),
    INTERVIEW_GUIDE_SOFTWARE_DEVELOPMENT_ENGINEER(220000, "더 개발자, 인터뷰 가이드");


    private int price;
    private String koreanDescription;
    //private final int price;
    //final 키워드로 수정을 막을 수 있다.


    // 파라미터 두개짜리 생성자로 Enum 생성
    WhiteshipLectureList(int price, String koreanDescription) {
        System.out.printf("enum constructor > price: %d , desc:%s\n", price, koreanDescription);  // 생성자가 언제 호출되는지 알아보기 위해서
        this.price = price;
        this.koreanDescription = koreanDescription;
    }

    // 하나짜리 생성자도 가능
    WhiteshipLectureList(int price) {
        this.price = price;
    }

    WhiteshipLectureList(String koreanDescription) {
        this.koreanDescription = koreanDescription;
    }


    //getter && setter ====================
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getKoreanDescription() {
        return koreanDescription;
    }

    public void setKoreanDescription(String koreanDescription) {
        this.koreanDescription = koreanDescription;
    }
}
//출처: https://xxxelppa.tistory.com/204?category=858435 [한칸짜리책상서랍]