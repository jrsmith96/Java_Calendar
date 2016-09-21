import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;

public class Days 
{
	public static void main(String[] args) throws java.text.ParseException
	{
		java.text.DateFormat DF = DateFormat.getInstance();
		Calendar cal = Calendar.getInstance();
		String dob = "24/04/1996 07:21 AM";
		String s1[] = dob.split("/");
		int month = Integer.parseInt(s1[0]);
		int date = Integer.parseInt(s1[1]);
		String s2[] = s1[2].split(" ");
		int year = Integer.parseInt(s2[0]);
		Day birthDay = new Day(year, month + 1, date);
		Date todayDate = new Date();
		year = cal.get(cal.YEAR);
		month = cal.get(cal.MONTH);
		date = cal.get(cal.DATE);
		Day today = new Day(year, month+1, date);
		int no_days_alive = today.daysFrom(birthDay) + 1;
		System.out.println("Date Of Birth: " + dob);
		System.out.println("Today's Date: " + DF.format(todayDate));
		System.out.println("Number Of Days: " + no_days_alive);
	}
}
