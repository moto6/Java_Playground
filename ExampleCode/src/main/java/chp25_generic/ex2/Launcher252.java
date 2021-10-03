package chp25_generic.ex2;

public class Launcher252 {
    public static void main(String[] args) {
        Product<K_Car, String> product1 = new Product<>();
        //Product<K_Car, String> product1 = new Product<K_Car, String>();
        // 다이아몬드 연산자 자바8이상에서 사용 >> 너무나도 뻔한 타입은 알아서 적어준다!

        product1.setKind(new K_Car());
        product1.setModel("Kalashnikov");
        K_Car k = product1.getKind();
        System.out.println( product1.getModel());

        Product<D_Car, String> product2 = new Product<D_Car, String>();
        product2.setKind(new D_Car());
        product2.setModel("Desperado");
        D_Car DCar = product2.getKind();
        System.out.println(product2.getModel());

        Product<H_Car, String> product3 = new Product<>();
        //product3.setKind(new D_Car()); //컴파일 에러
        product3.setKind(new H_Car());
        product3.setModel("Honolulu");
        H_Car h_car = product3.getKind();
        System.out.println(product3.getModel());

    }
}
