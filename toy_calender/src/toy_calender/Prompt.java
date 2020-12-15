package toy_calender;
import java.util.Scanner;
import toy_calender.*;

public class Prompt {
	
	private final static String PROMPT = "Calender> ";
	
	//private static Schedule sch = new Schedule();
	

	public static void main(String[] args) {
		Prompt p = new Prompt();
		p.runPrompt();	
	}
	
	
	public void runPrompt() {
		Scanner sc = new Scanner(System.in);
		Calender cl = new Calender();
		//PlanItem pi = new PlanItem(date, detail)
		
		
		while(true) {
			String buf;
			
			this.print_menu();
			//buf = sc.nextLine(); // what's the diff? find next
			buf = sc.next();
			
			
			if(buf.equals("q")) {
				break;
			}
			else if(buf.equals("1")) {
				// 일정 등록
				//cl.(sc,cl);
				
			}
			else if(buf.equals("2")) {
				// 일정 검색
				//sch.search();
				
			}
			else if(buf.equals("3")) {
				//달력보기
				this.print_cal_3(sc,cl);
			}
			else if(buf.equals("h")) {
				this.helper();
			}
			
			
		}
		

		System.out.print("Thankyou Bye!");
		sc.close();
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
	
	private void print_cal_3(Scanner sc, Calender cl) {

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
		
		cl.printCalender(year, month);
	}
	
	public void helper() {
		System.out.println("명령 (1, 2, 3, h, q)");
		System.out.println(" === 도움말의 끝 === \n");
	}
	
	
	public void cmdSearch(Scanner s, Calender c) {
		System.out.println("[ 일정 검색 ]");
		System.out.println("날짜를 입력해 주세요 (yyyy-MM-dd).");
		String date = s.next();
		PlanItem plan;
		plan = c.searchPlan(date);
		//System.out.println(plan);
		
		if(plan != null) {
			
		}
		else {
			
		}
		
			
	}
	public void cmdRegister(Scanner s, Calender c) {
		System.out.println("[ 일정 검색 ]");
		System.out.println("날짜를 입력해 주세요 (yyyy-MM-dd).");
		String date = s.next();
		String text = "", word = "";
		
		System.out.println("일정을 입력해 주세요.(끝문자 ;)");
		//text = s.nextLine();
		
		while((word = s.next()).endsWith(";")) {
			text +=word;
		}
		text +=word;
		word = word.replace(";","");
		
		c.registerPlan(date,text);
			
	}
	
}
