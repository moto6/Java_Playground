package chp25_generic.ex5_raw;

public class Launcher255 {
    Box<String> stringBox = new Box<>();
    Box<Integer> integerBox = new Box<>();
    Box rawBox = new Box<>();
    Box rawBox2 = new Box();
    Box rawBox3 = stringBox;
    Box rawBox4 = integerBox;
    //Box 는 제네릭 형식 Box<T> 의 원시 형식입니다 .
    //rawBox3.setData(8); //에러발생

    //그러나 제네릭이 아닌 클래스 또는 인터페이스 유형은 원시 유형 이 아닙니다
    Lux rawLux = new Lux();
    //Tux rawTux = new Tux(); // 너무나 당연하게도 인터페이스는 인스턴스화시킬수 없다

}


class Box<T> {
    T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}


interface Tux<T> {
    public T getData();
    public void setData(T data);
}

class Lux<T> implements Tux<T> {
    T data;

    @Override
    public T getData() {
        return data;
    }

    @Override
    public void setData(T data) {
        this.data = data;
    }
}