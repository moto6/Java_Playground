package Chp25_Generic.ex1;

public class Launcher {

    public static void main(String[] args) {

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
