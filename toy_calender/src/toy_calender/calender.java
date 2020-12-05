package toy_calender;

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
		
	}
}
