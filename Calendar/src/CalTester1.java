public class CalTester1 
{
	public static void main(String[] args)
	{
		Cal c = new Cal();
			int year = 2016;
			for (int month = 1; month < 13; month++)
				c.print(month, year);
	}
}