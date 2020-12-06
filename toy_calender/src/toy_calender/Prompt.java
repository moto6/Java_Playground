package toy_calender;
import java.util.Scanner;

public class Prompt {
	
	private final static String PROMPT = "Calender> ";
	
	public void runPrompt() {
		
		Scanner sc = new Scanner(System.in);
		Calender cal = new Calender();
		
		
		while(true) {
			System.out.println("달을 입력하세요");
			System.out.print(PROMPT);
			
		}
		System.out.println("ByeBye!");
		sc.close();
		
	}
	
	public static void main(String[] args) {
		Prompt p = new Prompt();
		p.runPrompt();
			
	}
}
