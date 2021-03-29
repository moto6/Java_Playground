public class excp1 {
    //프로그램 사용법 및 의도
    //run1, run2 중에 하나만 사용하고 하나는 주석처리하고 사용

    public static void main(String[] args) {
        //run1();
        run2();
    }

    static void run1() {
        try {
            Exception exception = new Exception("고의로 발생시킨 예외");
            throw exception;
        }catch(Exception e) {
            System.out.println("에러메시지 : "+ e.getMessage());
            e.printStackTrace();
        }

        System.out.println("프로그램 정상 종료");
    }

    static void run2() {
        try {
            throw new Exception("익명클래스로 만든거임");
        }catch(Exception e) {
            System.out.println("에러메시지 : "+ e.getMessage());
            e.printStackTrace();
        }
        System.out.println("프로그램 정상 종료");
    }


}
