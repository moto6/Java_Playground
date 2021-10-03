package chp25_generic.ex4;

public class Launcher254 {
    public static void main(String[] args) {
        checkedGeneric();
        uncheckedObject();
    }

    private static void uncheckedObject() {
        ObjectSample o1 = new ObjectSample();
        ObjectSample o2 = new ObjectSample();
        ObjectSample o3 = new ObjectSample();

        o1.setObject(new String());
        o2.setObject(new StringBuffer());
        o3.setObject(new StringBuilder());

        // 런타임에 에러가 발생한다
        Object a1 = o1.getObject();
        String s1 = (String) a1;

        Object a2 = o1.getObject();
        String s2 = (String) a1;

        Object a3 = o1.getObject();
        String s3 = (String) a1;

        System.out.println( s1 + s2 + s3);
    }

    public static void checkedGeneric() {
        GenericSample<String> o1 = new GenericSample<String>();
        o1.setObject(new String());
        String temp1 = o1.getObject();


        GenericSample<StringBuffer> o2 = new GenericSample<StringBuffer>();
        o2.setObject(new StringBuffer());
        //아래 코드는 에러가 뜬다. 컴파일타임에 에러가 체크되기 때문
        //String temp2 = o2.getObject();
        //실행을 위해 주석
        StringBuffer tempOk2 = o2.getObject();



        GenericSample<StringBuilder> o3 = new GenericSample<StringBuilder>();
        o3.setObject(new StringBuilder());
        //아래 코드는 에러가 뜬다. 컴파일타임에 에러가 체크되기 때문
        //String temp3 = o3.getObject();
        //실행을 위해 주석
        StringBuilder tempOk3 = o3.getObject();
        


    }
    
}
