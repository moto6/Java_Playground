package toy_calender;
import java.util.Scanner;
public class Calender {
	
	
	private static final String[] yo_kr = {"일","월","화","수","목","금","토"};
	private static final String[] yo_en = {"SUN","MON","TUE","WED","TUR","FRI","SAT"};
	private static final String LINE = "-----------------------------";
	private static final int[] MAX_DAYS= { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS= { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	
	
	public static void main(String[] args) {
		//test
		//printCalender(2017,1);
		
		
	}
	
	
	public static void printCalender(int year ,int month) {
		
			System.out.printf("\n <<   %2d - %4d>>   \n", year, month);
			System.out.println("SUN  MON  TUE  WED  THR  FRI  SAT");
			System.out.println("---------------------------------");
			System.out.println(" 1   2   3   4   5   6   7");
			System.out.println(" 8   9  10  11  12  13  14");
			System.out.println("15  16  17  18  19  20  21");
			System.out.println("22  23  24  25  26  27  28");
		
	}
	
	public int getMaxDaysofMonth(int year, int month) {
		//int calmonth[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		
		if(isLeapyear(year)) {
			return LEAP_MAX_DAYS[month];
		}
		else {
			return MAX_DAYS[month];
		}
	}
		
	
	
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
	
}
