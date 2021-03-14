import jdk.tools.jlink.resources.plugins;

public class W5_ConsInit {
    String data = "";


    public W5_ConsInit() {
        data = "0";
    }

    public W5_ConsInit(int number) {
        this();//이렇게도 사용 가능하다
    }



    public static void main(String[] args) {
        W5_blockInit inst = new W5_blockInit();
    }
}
