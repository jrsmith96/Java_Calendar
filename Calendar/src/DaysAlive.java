import java.util.Calendar;
import java.util.GregorianCalendar;

public class DaysAlive 
{
	GregorianCalendar currentDate;
	GregorianCalendar birthDate;
	
	DaysAlive(int year, int month, int dayOfMonth)
	{
		currentDate = new GregorianCalendar();
		birthDate = new GregorianCalendar(year, month, dayOfMonth);
	}
	
	public int calcDaysSinceBirth()
	{
		int daysSince = 0;
		boolean sameDy = birthDate.get(Calendar.DAY_OF_MONTH) == currentDate.get(Calendar.DAY_OF_MONTH);
		boolean sameYr = birthDate.get(Calendar.YEAR) == currentDate.get(Calendar.YEAR);
		boolean sameMn = birthDate.get(Calendar.MONTH) == currentDate.get(Calendar.MONTH);
		while(!(sameDy && sameYr && sameMn))
		{
			birthDate.add(Calendar.DAY_OF_MONTH, 1);
			daysSince++;
			sameDy = birthDate.get(Calendar.DAY_OF_MONTH) == currentDate.get(Calendar.DAY_OF_MONTH);
			sameYr = birthDate.get(Calendar.YEAR) == currentDate.get(Calendar.YEAR);
			sameMn = birthDate.get(Calendar.MONTH) == currentDate.get(Calendar.MONTH);
		}	
		return daysSince;
	}
	
	public void setDate(int year, int month, int dayOfMonth)
	{
		birthDate.set(year,  month, dayOfMonth);
	}
	
	public GregorianCalendar getDate()
	{
		return birthDate;
	}
	
	public static void main(String[] args)
	{
		int days;
		DaysAlive calculator = new DaysAlive(1996, 4, 24);
		days = calculator.calcDaysSinceBirth();
		System.out.println("Days alive: " + days);
	}
}