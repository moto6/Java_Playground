package chp501_validdate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateValidatorUsingLocalDate implements DateValidator{

    private DateTimeFormatter formatter;

    public DateValidatorUsingLocalDate(DateTimeFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public boolean isValid(String dateStr) {
        try {
            LocalDate.parse(dateStr, this.formatter);
        }catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }
}
