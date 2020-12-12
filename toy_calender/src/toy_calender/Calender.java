package toy_calender;
//import java.util.Scanner;
public class Calender {
	
	private static final String[] YO_KR = {"일","월","화","수","목","금","토"};
	private static final String[] YO = {"SUN","MON","TUE","WED","TUR","FRI","SAT"};
	private static final String LINE = "  ----------------------------";
	private static final int[] MAX_DAYS= { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS= { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	
	public static void main(String[] args) {
		//test
		Calender cal = new Calender();

		System.out.print("2020.12.12 : ");
		System.out.print(getWeekDay(2020, 12, 12));
		System.out.print(' ' + YO[getWeekDay(2020, 12, 12)] + '\n');
		
		System.out.print("2020.12.13 : ");
		System.out.print(getWeekDay(2020, 12, 13));
		System.out.print(' ' + YO[getWeekDay(2020, 12, 13)] + '\n');
		
		
		cal.printCalender(2020, 12);

		//int weekday = getWeekDay(year, month, 1); 
		cal = null;
	}
	
	
	public void printCalender(int year ,int month) {
		
			System.out.printf("\n\t<< %d  - %d  >>   \n", year, month);
			//System.out.println("  SUN  MON  TUE  WED  THR  FRI  SAT");
			for(int i=0 ; i<7 ; i++ ) {
				System.out.printf("%4s",YO_KR[i]);
			}
			System.out.print("\n  ");
			for(int i=0 ; i<7 ; i++ ) {
				System.out.printf("%4s",YO[i]);
			}
			System.out.print("\n");
			
			
			
			System.out.println(LINE);
			//System.out.println(" 1   2   3   4   5   6   7");
			//System.out.println(" 8   9  10  11  12  13  14");
			//System.out.println("15  16  17  18  19  20  21");
			//System.out.println("22  23  24  25  26  27  28");
			
			
			int weekday = getWeekDay(year, month, 1);
			int curday = 1;
			int endday = getMaxDaysofMonth(year,month);
			System.out.print("  ");// cursor adjustment
			
			
			//fistst line print of cal
			System.out.print("       ");
			
			for(int i= 0 ; i<7- weekday ; i++) {
				System.out.printf("%4d",curday);
				curday++;
			}
			System.out.print("\n ");
			
			
			//second ~ Last line print calender
			while(true) {
				for(int i= 0 ; i<7 ; i++) {
					System.out.printf("%4d",curday);
					curday++;
					if(endday <= curday) {
						break;
					}
					
				}
				if(endday <= curday) {
					break;
				}
				System.out.print("\n ");
			}
			
			System.out.print("\n\n");
	}
	
	public static int getMaxDaysofMonth(int year, int month) {
		//int calmonth[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		
		if(isLeapyear(year)) {
			return LEAP_MAX_DAYS[month];
		}
		else {
			return MAX_DAYS[month];
		}
	}
		
	
	
	public static boolean isLeapyear(int year) {
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
	
	private static int getWeekDay(int year, int month, int day) {
		int weekday = 0;
		if(!(2000<=year && year<=2100)) {
			//2000년부터 2100년까지의 요일을 알수 있다.
			year = 2020;
		}
		
		year = year-(2000);//올해는 일단 빠져있어
		int days = (year*365) + 6;//토요일 : 2000년 1월 1일, 그래서  +6
		days += (year/4);//2021년의 경우, 20으로 변경되었다가 
		//4년마다 돌아오는 윤년이 5번 돌아오므로 +5일을 더해줌
		//100년 400년은 실사용 영역이 아니므로 고려하지 않음
		
		//
		for(int i=0 ;i <month ; i++) {
			days+= getMaxDaysofMonth(year,i);
		}
		days+=day;
		//System.out.println(days);
		weekday = days%7;
	
		return weekday;
	}
	
	
	
	
}
