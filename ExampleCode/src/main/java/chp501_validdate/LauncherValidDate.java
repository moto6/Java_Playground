package chp501_validdate;

public class LauncherValidDate {

    public static void main(String[] args) {
        DateValidator validator = new DateValidatorUsingDateFormat("MM/dd/yyyy");

        System.out.println("\n잘못된 일수");
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
