package chp15_Lambda;

@FunctionalInterface
interface Myfunc{
    void mymethod();//public abstract void mymethod()
}

public class Launcher154 {
    public static void main(String[] args) {
        Myfunc f = () -> {};
        Object obj = (Myfunc) (() -> {});
        String s = ((Object) (Myfunc) (() -> {}) ).toString();

        System.out.println(f);
        System.out.println(obj);
        System.out.println(s);
        //System.out.println(()->());
        System.out.println((Myfunc)(() -> {}));
        //System.out.println((Myfunc)(() -> {}).toString;
        System.out.println(( (Object) (Myfunc)(() -> {})).toString());
        System.out.println(( (Object) (Myfunc)(() -> {})).toString());

    }
}
