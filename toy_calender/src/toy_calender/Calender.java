package toy_calender;
import java.util.Scanner;
public class Calender {
	
	
	private static final String[] yo_kr = {"일","월","화","수","목","금","토"};
	private static final String[] yo_en = {"SUN","MON","TUE","WED","TUR","FRI","SAT"};
	private static final String LINE = "-----------------------------";
	private static final int[] MAX_DAYS= { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS= { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	public boolean isLeapyear(int year) {
		if(year%400 == 0) {
			return true;
		}
		else if(year%100 == 0) {
			return false;	
		}
		
		else if(year%4==0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Hello world!!");
		
		
		for(int i=0 ; i<7 ; i++ ) {
			System.out.print(yo_kr[i]+ "   ");
		}
		
		System.out.println('\n'+LINE);
		
		for(int i=0 ; i<4 ; i++) {
			for(int j=1 ; j<=7 ; j++) {
				System.out.print(i*7+j+ "  ");
			}
			System.out.print('\n');
		}

		////////////////////////////////////////////////
		
	}
	
	
	public void printCalender(int year ,int month) {
		if(isLeapyear(year)) {
			
		}
		else {
			System.out.printf("\n    <<%4d - %3d>>   \n", year, month);
			System.out.println(" 일   월  화  수  목  금   토");
			System.out.println("--------------------------");
			System.out.println(" 1   2   3   4   5   6   7");
			System.out.println(" 8   9  10  11  12  13  14");
			System.out.println("15  16  17  18  19  20  21");
			System.out.println("22  23  24  25  26  27  28");
		}
	}
	
	public void getMaxDaysofMonth() {
		//int calmonth[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		
		int a = sc.nextInt();
		if(1<= a && a<=12) {
			System.out.printf("%d월은 %d일까지 있습니다", a, calmonth[a]);
			//cal.printSampleCal(2020,)
			cal.printCal(2020,a);
			
		}
		else if(a == 0 || a==-1) {
			System.out.printf("종료키 입력으로 프로그램 정지");
			break;
		}
		else {
			//이상한거 입력됨
		}
	}
	
}
