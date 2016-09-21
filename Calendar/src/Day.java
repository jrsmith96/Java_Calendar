public class Day 
{
	public Day(int aYear, int aMonth, int aDate)
	{
		year = aYear;
		month = aMonth;
		date = aDate;
		ymdValid = true;
		julianValid = false;
	}
	
	public int daysFrom(Day other)
	{
		ensureJulian();
		other.ensureJulian();
		return julian - other.julian;
	}
	
	private void ensureJulian()
	{
		if (julianValid) return;
		julian = toJulian(year, month, date);
		julianValid = true;
	}
	
	private void ensureYmd()
	{
		if (ymdValid) return;
		int[] ymd = fromJulian(julian);
		year = ymd[0];
		month = ymd[1];
		date = ymd[2];
		ymdValid = true;
	}
	
	public static int toJulian(int year, int month, int date)
	{
		int jy = year;
		if (year < 0) 
			jy++;
		int jm = month;
		if (month > 2) 
			jm++;
		else
		{
			jy--;
			jm += 13;
		}
		
		int jul = (int) (java.lang.Math.floor(365.25*jy) + java.lang.Math.floor(30.6001*jm) + date + 1720995.0);
		int IGREG = 15 + 31 * (10 + 12*1582);
		if (date + 31*(month + 12*year) >= IGREG)
		{
			int ja = (int)(0.01*jy);
			jul += 2 - ja + (int)(0.25*ja);
		}
		return jul;
	}
	
	private static int[] fromJulian(int j)
	{
		int ja = j;
		int JGREG = 2299161;
		if (j >= JGREG)
		{
			int jalpha = (int)(((float)(j - 1867216) - 0.25) / 36524.25);
			ja += 1 + jalpha - (int)(0.25*jalpha);
		}
		
		int jb = ja + 1524;
		int jc = (int)(6680.0 + ((float)(jb-2439870) - 122.1)/365.25);
		int jd = (int)(365*jc + (0.25*jc));
		int je = (int)((jb - jd)/30.6001);
		int date = jb- jd - (int)(30.6001*je);
		int month = je - 1;
		if (month > 12) 
			month -= 12;
		int year = jc - 4715;
		if (month > 2)
			--year;
		if (year <= 0)
			--year;
		return new int[] {year, month, date};
	}
	
	private int year;
	private int month;
	private int date;
	private int julian;
	private boolean ymdValid;
	private boolean julianValid;
}