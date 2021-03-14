import jdk.javadoc.internal.doclets.formats.html.resources.standard;

public class W5_blockInit {

    private int number ;
    {
        this.number = 10;
        System.out.println("block Initialize");
        // 이걸 쓰는 이유는, 코드블럭이니까 여기다가 코딩(if,for, 등등..)을 할수 있다
    }

    public W5_blockInit () {
        this.number = 100;
        System.out.println("Constructor");
    }

    public static void main(String[] args) {
        W5_blockInit inst = new W5_blockInit();
        System.out.println(inst.number);
    }
    

}