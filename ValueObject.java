package Java_Study;

public class ValueObject {

    public static final char color1 = 'R';
    public static final char color2 = 'O';
    public static final char color3 = 'Y';
    public static final char color4 = 'G';
    public static final char color5 = 'B';
    public static final String[] HELPER = {
            "===placeholder===",
            "Red",
            "Orange",
            "Yellow",
            "Green",
            "Blue",
    };


    char Color;

    private ValueObject(char Color) {
        this.Color = Color;
    }

    //===================================

    public static ValueObject create1() {
        return new ValueObject(color1);
    }

    public static ValueObject create2() {
        return new ValueObject(color2);
    }

    public static ValueObject create3() {
        return new ValueObject(color3);
    }

    public static ValueObject create4() {
        return new ValueObject(color4);
    }

    public static ValueObject create5() {
        return new ValueObject(color5);
    }

    //===================================

    public void getHelpTip(ValueObject vo) {
        if(vo.equals(create1())){
            System.out.println(HELPER[1]);
        }

        if(vo.equals(create2())){
            System.out.println(HELPER[2]);
        }

        if(vo.equals(create3())){
            System.out.println(HELPER[3]);
        }

        if(vo.equals(create4())){
            System.out.println(HELPER[4]);
        }

        if(vo.equals(create5())){
            System.out.println(HELPER[5]);
        }


    }


}
