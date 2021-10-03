package chp25_generic.ex3_lagacy;

public class EX1_unGenericSample {
    

    public static void main(String[] args) {
        EX1_unGenericSample sample = new EX1_unGenericSample();
        sample.checkCastingDTO();
    }

    public void checkCastingDTO() {
        EX1_CastingDTO dto1 = new EX1_CastingDTO();
        dto1.setObject(new String());// Only String

        EX1_CastingDTO dto2 = new EX1_CastingDTO();
        dto2.setObject(new StringBuffer());// Buffer

        EX1_CastingDTO dto3 = new EX1_CastingDTO();
        dto3.setObject(new StringBuilder()); // Builder


        // Type Castring
        String temp1 = (String) dto1.getObject();
        StringBuffer temp2 = (StringBuffer) dto2.getObject();
        StringBuilder temp3 = (StringBuilder) dto3.getObject();

        try {

            //error
            errorSituation(dto1.getObject());
            // 이 부분의 주석을 풀고 실행하면 에러가 발생하는데
            // 런타임에 타입캐스팅이 잘못되면 큰일난다는 이야기를 하고싶으셨다
            errorSituation(dto2.getObject());
            errorSituation(dto3.getObject());
        }
        catch (Exception e) {
            System.out.println("\r\norrcur Exception !!!! \r\n");
            System.out.println(e.getMessage());

        }

    }


    public String errorSituation(Object object) {
        return (String) object;
    }
}
