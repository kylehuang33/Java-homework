import java.util.ArrayList;

public class Daily extends Appointment{
	
	private static ArrayList<Daily> app = new ArrayList<Daily>();
	private static ArrayList<Appointment> del = new ArrayList<Appointment>();
	
	Daily(int year, int month, int day, String des) {
		super(year, month, day, des);
		// TODO Auto-generated constructor stub
		app.add(this);
	}

	public static boolean occursOn(int year, int month, int day)
	{
		for(Daily d : app)
		{
			for(Appointment de : del)
			{
				if(year > de.year)
					return false;
				else if(year == de.year)
				{
					if(month > de.month)
						return false;
					else
						if(day >= 28)
							return false;
				}
			}
			
			if(d.year == year)
				return true;
		}
		return false;
	}
	

	public static String showDescription(int year, int month, int day)
	{
		String des = null;
		
		for(Daily d1 : app)
			if(d1.occursOn(d1.year, d1.month, d1.day))
				des += d1.description + " \t";
		return des;
	}
	
	public static void deleteApp(int y , int m, int d)
	{
		del.add(new Appointment(y, m, d, ""));
	}
	
}
