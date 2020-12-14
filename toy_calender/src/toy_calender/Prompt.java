package toy_calender;
import java.util.Scanner;

public class Prompt {
	
	private final static String PROMPT = "Calender> ";
	private static Prompt p = new Prompt();
	public static Scanner sc = new Scanner(System.in);
	public static Calender mycal = new Calender();
	private static Schedule sch = new Schedule();
	
	
	public void runPrompt() {
		while(true) {
			String buf;
			
			p.print_menu();
			//buf = sc.nextLine(); // what's the diff? find next
			buf = sc.next();
			
			
			if(buf.equals("q")) {
				break;
			}
			else if(buf.equals("1")) {
				sch.register(sc,mycal);
			}
			else if(buf.equals("2")) {
				sch.search();
			}
			else if(buf.equals("3")) {
				p.print_cal_3();
			}
			else if(buf.equals("h")) {
				p.helper();
			}
			
			
		}
		

		System.out.print("Thankyou Bye!");
		sc.close();
	}
	
	public static void main(String[] args) {
		
		p.runPrompt();	
	}
	
	public void print_menu() {
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록");
		System.out.println("| 2. 일정 검색");
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말");
		System.out.println("| q. 종료");
		System.out.println("+----------------------+");
		System.out.println("명령 (1, 2, 3, h, q)");
	}
	
	public static int parseDay(String week) {
		//-1 : ERROR, wrong day
		//0~6 ; sun~mon
		
		
		final String[] YOIL = {"SUN","MON","TUE","WED","THR","FRI","SAT"};
		for(int i=0 ; i<7 ; i++) {
			if(YOIL[i].equals(week)) {
				return i;
			}
		}
		return -1;
	}
	
	private void print_cal_3() {

		int year = 2000;
		int month = 1;
		int weekday = 0;

		System.out.println("년도를 입력하세요");
		System.out.print("Year> ");
		year = sc.nextInt();

		System.out.println("월을 입력하세요");
		System.out.print("Month> ");
		month = sc.nextInt();

		//System.out.println("SUN/MON/TUE/WED/TUR/FRI/SAT");
		//System.out.println("요일을 입력하세요");
		//System.out.print("WekD> ");
		String sweek = sc.nextLine();
		weekday = parseDay(sweek);
				
		mycal.printCalender(year, month);
	}
	
	public void helper() {
		System.out.println("명령 (1, 2, 3, h, q)");
	}
}
