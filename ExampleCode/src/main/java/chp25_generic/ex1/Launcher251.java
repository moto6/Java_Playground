package chp25_generic.ex1;

public class Launcher251 {

    public static void main(String[] args) {

        System.out.println("안녕하세요 한글나와랴");

        // no generic
        Box_NOGEN boxNOGEN = new Box_NOGEN();
        boxNOGEN.setBox("DongDong");
        String message1 = (String) boxNOGEN.getBox();

        boxNOGEN.setBox(new Apple());
        Apple apple = (Apple) boxNOGEN.getBox();


        // with generic
        Box_GEN<String> box_gen1 = new Box_GEN<>();
        box_gen1.setBox("Hello Dong");
        String message2 = box_gen1.getBox();

        Box_GEN<Apple> box_gen2 = new Box_GEN<>();
        box_gen2.setBox(new Apple());
        Apple apple2 = box_gen2.getBox();
    }

}
