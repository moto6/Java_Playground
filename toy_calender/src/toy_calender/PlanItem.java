package toy_calender;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PlanItem {
	
	public Date planData;
	public String detail;
	public String peoples = "";
	
	public static Date getDatefromString(String strDate) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate); 
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	
	public PlanItem(String date, String detail) {
		this.planData = getDatefromString(date);
		this.detail = detail;
	}
	
	public Date getDate() {
		return planData;
	}
	
	public void addpeople(String name) {
		peoples += name + ",";
	}
}
