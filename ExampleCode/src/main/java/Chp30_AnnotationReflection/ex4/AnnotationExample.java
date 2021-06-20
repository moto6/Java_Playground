package Chp30_AnnotationReflection.ex4;

public class AnnotationExample extends Abstract {

    // 의존성 주입 어노테이션을 멤버 변수에 설정
    @DependencyInjection
    private Node node1;

    // 의존성 주입 어노테이션이 없는 멤버 변수
    private Node node2;

    // 출력 함수
    public void print() {
        if (this.node1 != null) {
            this.node1.print();
        } else {
            System.out.println("nodel1 null");
        }

        if (this.node2 != null) {
            this.node1.print();
        } else {
            System.out.println("node2 null");
        }

    }

    // 실행 함수
    public static void main(String[] args) {
        // Example 인스턴스 생성
        AnnotationExample ex = new AnnotationExample();
        // 함수 호출
        ex.print();

    }


}
