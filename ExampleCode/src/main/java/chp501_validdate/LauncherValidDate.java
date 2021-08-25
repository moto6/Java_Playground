package chp501_validdate;

import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Locale;

public class LauncherValidDate {

    public static void main(String[] args) {

        first_UsingDateFormat();
        second_UsingLocalDate();
        third_UsingDateTimeFormatter();

    }

    private static void third_UsingDateTimeFormatter() {
        System.out.println("\n\n메서드 : "+new Object() {}.getClass().getEnclosingMethod().getName());


        System.out.println("\n한글 로케일");
        DateTimeFormatter dateFormatter1 = DateTimeFormatter.ofPattern("uuuu-MM-dd", Locale.KOREA)
                .withResolverStyle(ResolverStyle.STRICT);
        DateValidator validator1 = new DateValidatorUsingDateTimeFormatter(dateFormatter1);

        tester(validator1.isValid("2019-02-28"));
        tester(validator1.isValid("2019-02-30"));



        System.out.println("\n영어 로케일");
        DateTimeFormatter dateFormatter2 = DateTimeFormatter.ofPattern("uuuu-MM-dd", Locale.US)
                .withResolverStyle(ResolverStyle.STRICT);
        DateValidator validator2 = new DateValidatorUsingDateTimeFormatter(dateFormatter2);

        tester(validator2.isValid("2019-02-28"));
        tester(validator2.isValid("2019-02-30"));


    }

    private static void second_UsingLocalDate() {
        System.out.println("\n\n메서드 : "+new Object() {}.getClass().getEnclosingMethod().getName());


        DateTimeFormatter dateFormatter = DateTimeFormatter.BASIC_ISO_DATE;
        DateValidator validator = new DateValidatorUsingLocalDate(dateFormatter);

        tester(validator.isValid("20190228"));
        tester(validator.isValid("20190230"));
        tester(validator.isValid("20190231"));
        tester(validator.isValid("20191230"));
        tester(validator.isValid("20192230"));
        tester(validator.isValid("90191230"));
        tester(validator.isValid("99991230"));
        tester(validator.isValid("100001230"));
        tester(validator.isValid("00001230"));

    }

    private static void tester(boolean valid) {
        System.out.println("날짜 유효성 검사 결과 : " + valid);
    }

    private static void first_UsingDateFormat() {
        System.out.println("\n\n메서드 : "+new Object() {}.getClass().getEnclosingMethod().getName());


        DateValidator validator = new DateValidatorUsingDateFormat("MM/dd/yyyy");

        System.out.println("잘못된 일수");
        System.out.println("날짜 유효성 검사 결과 : " + (validator.isValid("02/28/2019")));
        System.out.println("날짜 유효성 검사 결과 : " + (validator.isValid("02/30/2019")));

        System.out.println("\n잘못된 월수");
        System.out.println("날짜 유효성 검사 결과 : " + (validator.isValid("12/31/2999")));
        System.out.println("날짜 유효성 검사 결과 : " + (validator.isValid("12/32/2999")));
        System.out.println("날짜 유효성 검사 결과 : " + (validator.isValid("13/31/2999")));

        System.out.println("\n윤년 검사");
        System.out.println("날짜 유효성 검사 결과 : " + (validator.isValid("02/29/2020")));
        System.out.println("날짜 유효성 검사 결과 : " + (validator.isValid("02/29/2021")));
        System.out.println("날짜 유효성 검사 결과 : " + (validator.isValid("02/29/2022")));
        System.out.println("날짜 유효성 검사 결과 : " + (validator.isValid("02/29/2023")));
        System.out.println("날짜 유효성 검사 결과 : " + (validator.isValid("02/29/2024")));

    }




}
