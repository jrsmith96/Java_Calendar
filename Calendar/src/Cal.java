import java.text.DateFormatSymbols;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class Cal 
{
	public void print(int month, int year)
	{
		month = month - 1;
		cal.set(year, month, 1);
		System.out.println(dFSymbols.getMonths()[month] + " " + year); //Month Year
		int firstDayOfWeek = cal.getFirstDayOfWeek();
		String firstDayString = dFSymbols.getShortWeekdays()[firstDayOfWeek];
		System.out.print(" " + firstDayString.charAt(0));
		for (int i = firstDayOfWeek + 1; i < firstDayOfWeek + 7; i++)
		{
			String dayString = dFSymbols.getShortWeekdays()[(i-1)%7+1];
			System.out.print("  " + dayString.charAt(0)); // S M T W T F S
		}
		
		System.out.println(); //Puts numbers underneath the days of the week
		int firstDayOfMonth = cal.get(Calendar.DAY_OF_WEEK);
		int daysToSkip = firstDayOfMonth - firstDayOfWeek;
		if (daysToSkip < 0)
			daysToSkip = 7 + daysToSkip;
		int lastDay = daysPerMonth[month];
		if (month == Calendar.FEBRUARY && cal.isLeapYear(year)) //no
			lastDay = 29; //no
		for (int day = 0; day < 3*daysToSkip - 1 + 2; day++)
			System.out.print(" ");
		for (int day = 1; day < 9; day++) //Prints out days 1 though 8
		{
			if (day < 10)
				System.out.print(day + " ");
			else
				System.out.print(day);
			if ((day + daysToSkip) % 7 == 0)
				System.out.print("\n ");
			else
				System.out.print(" ");
		}	
		
		for (int day = 9; day <= lastDay; day++) //Entire for loop prints out days past 8
		{
			System.out.print(day);
			if ((day + daysToSkip) % 7 == 0)
				System.out.print("\n");
			else
				System.out.print(" ");
		}
		System.out.println("\n");
	}
	private GregorianCalendar cal = new GregorianCalendar();
	private DateFormatSymbols dFSymbols = new DateFormatSymbols();
	private static int[] daysPerMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; 
}
