package chp25_generic.ex3_lagacy;

public class EX2_GenericSample {
    public static void main(String[] args) {
        //EX2_GenericSample sample = new EX2_GenericSample();
        checkGenericDTO();
    }
    public static void checkGenericDTO() {
        EX2_CastingGenericDTO<String> dto1 = new EX2_CastingGenericDTO<String>();
        dto1.setObject(new String());
        EX2_CastingGenericDTO<StringBuffer> dto2 = new EX2_CastingGenericDTO<StringBuffer>();
        dto2.setObject(new StringBuffer());
        EX2_CastingGenericDTO<StringBuilder> dto3 = new EX2_CastingGenericDTO<StringBuilder>();
        dto3.setObject(new StringBuilder());
        
        String temp1 = dto1.getObject();
        String temp2 = dto2.getObject();
        String temp3 = dto3.getObject();
    }
    
}
