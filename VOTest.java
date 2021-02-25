package Java_Study;

public class VOTest {

    public static void main(String[] args) {

        //ValueObject vo = new ValueObject();
        //생성자가 프라이빗이라 안된다
        ValueObject vo1 = ValueObject.create1();


        if(vo1.equals(ValueObject.create1())){
            //if(vo1.equals(vo2)) {
                System.out.println("둘이 같은게 맞습니다. ValueObject 란 이런것이죠");


            //}
        }
        else  {
            System.out.println("뭐야씨빨");
            System.out.println(vo1.hashCode());
            //System.out.println(vo2.hashCode());
        }
    }

}
