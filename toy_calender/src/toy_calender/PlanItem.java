package toy_calender;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PlanItem {
	
	public Date planDate;
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
		this.planDate = getDatefromString(date);
		this.detail = detail;
	}
	
	public Date getDate() {
		return planDate;
	}
	
	public void addpeople(String name) {
		peoples += name + ",";
	}
	
	public String saveString() {
		//String ret = "";
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		String sdate = fmt.format(planDate);
		return (sdate + "," + "\""+detail +"\""+ "\n");
	}
}
