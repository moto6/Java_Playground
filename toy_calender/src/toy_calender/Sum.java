package toy_calender;

//import java.io.IOException;
import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1,s2;
		s1 = sc.next();
		s2 = sc.next();
		//System.out.print(s1+s2);
		int a = Integer.parseInt(s1);
		int b = Integer.parseInt(s2);
		System.out.print(a+b);
		sc.close();
	}
}


/*
 * Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
 * 
 * */
