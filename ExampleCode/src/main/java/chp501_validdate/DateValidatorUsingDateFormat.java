package chp501_validdate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateValidatorUsingDateFormat implements DateValidator {


    private String dateFormat;

    public DateValidatorUsingDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }


    @Override
    public boolean isValid(String dateStr) {
//        DateFormat sdf = new SimpleDateFormat(this.dateFormat);

        DateFormat format = new SimpleDateFormat(this.dateFormat);
        format.setLenient(false);

        try {
            format.parse(dateStr);
        }catch (ParseException e) {
            return false;
        }

        return true;
        // DateFormat의 및 관련 클래스는 스레드로부터 안전하지 않습니다
        // 프로젝트 여러군데에서동시에 마구 호출하면 에러가 발생합니다
        // 해결책으로 >> 각 메서드 호출에 대해서(마다) >> 새로운 인스턴스를 만들어서 thread-Safe를 보장받을수 있습니다
        // 단점으로는 리소스(메모리)가 좀더 듭니다
        // 이것은 Java 8 이전에 가장 일반적인 솔루션입니다



    }
}
