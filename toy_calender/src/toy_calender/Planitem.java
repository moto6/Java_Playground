package toy_calender;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Planitem {
	
	public Date planData;
	public String detail;
	
	
	public PlanItem(String date, String detail) {
		try {
			planData = new SimpleDateFormat("yyyy-MM-dd").parse(date); 
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
