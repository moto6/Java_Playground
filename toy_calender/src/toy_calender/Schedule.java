package toy_calender;
import java.util.Scanner;
import toy_calender.Calender;
//import Calender;
import java.text.ParseException;


public class Schedule {
	
	
	public int register(Scanner s, Calendar c) throws ParseException {
		// System.out.println("register");
		System.out.println("[새 일정 등록]");
		System.out.println("날짜를 입력해 주세요 (yyyy-MM-dd).");
		String date = s.next();
		String text = "";
		s.nextLine(); // ignore one newline
		System.out.println("일정을 입력해 주세요.");
		text = s.nextLine();
		c.registerPlan(date, text);

		return 0;

	}

	public int list() {
		System.out.println("list");
		return 0;
	}

	public int search() {
		System.out.println("search");
		return 0;
	}
}
