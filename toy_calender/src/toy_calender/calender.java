package toy_calender;
import java.util.Scanner;
public class calender {
	
	
	static String[] yo_kr = {"일","월","화","수","목","금","토"};
	static String[] yo_en = {"SUN","MON","TUE","WED","TUR","FRI","SAT"};
	static String LINE = "-----------------------------";
	
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
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int calmonth[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		System.out.printf("%d월은 %d일까지 있습니다", a, calmonth[a]);

		sc.close();
		
		
	}
}
