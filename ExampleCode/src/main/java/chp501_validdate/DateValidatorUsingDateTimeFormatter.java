package chp501_validdate;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateValidatorUsingDateTimeFormatter implements DateValidator{
    private DateTimeFormatter formatter;


    public DateValidatorUsingDateTimeFormatter(DateTimeFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public boolean isValid(String dateStr) {
        try {
            this.formatter.parse(dateStr);
        }catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }
}
