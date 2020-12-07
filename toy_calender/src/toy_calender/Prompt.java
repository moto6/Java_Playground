package toy_calender;
import java.util.Scanner;

public class Prompt {
	
	private final static String PROMPT = "Calender> ";
	
	public void runPrompt() {
		Scanner sc = new Scanner(System.in);
		Calender mycal = new Calender();
		
		int year = 2000;
		int month = 1;
		int weekday = 0;

		System.out.println("달을 입력하세요");
		System.out.print("Year> ");
		year = sc.nextInt();

		System.out.println("월을 입력하세요");
		System.out.print("Month> ");
		month = sc.nextInt();

		System.out.println("SUN/MON/TUE/WED/TUR/FRI/SAT");
		System.out.println("요일을 입력하세요");
		System.out.print("WekD> ");
		String sweek = sc.nextLine();
		weekday = parseDay(sweek);
		
		
		mycal.printCalender(year, month);
	}
	
	public static void main(String[] args) {
		Prompt p = new Prompt();
		p.runPrompt();
			
	}
	
	
	public static int parseDay(String week) {
		//-1 : ERROR, wrong day
		//0~6 ; sun~mon
		
		
		final String[] YOIL = {"SUN","MON","TUE","WED","TUR","FRI","SAT"};
		for(int i=0 ; i<7 ; i++) {
			if(YOIL[i].equals(week)) {
				return i;
			}
		}
		return -1;
	}
}
