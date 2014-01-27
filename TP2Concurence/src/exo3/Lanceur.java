package exo3;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;


public class Lanceur {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean continu1 = true;
		boolean continu2 = true;
		boolean continu3 = true;
		
		
		long start = System.currentTimeMillis();
		long end1 = start + 5*1000;
		long end2 = start + 10*1000;
		
		//System.out.println(start);
		//System.out.println(end1);
		
		DonneHeure d1 = new DonneHeure("d1");
		DonneHeure d2 = new DonneHeure("d2");
		DonneHeure d3 = new DonneHeure("d3");
		
		
		Timer t1 = new Timer();
		Timer t2 = new Timer();
		Timer t3 = new Timer();
		
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int month = Calendar.getInstance().get(Calendar.MONTH);
		int date = Calendar.getInstance().get(Calendar.DATE);
		
		GregorianCalendar d = new GregorianCalendar( year, month, date, 10, 30);
		
		t1.schedule(d1, 0, 5000);
		t2.schedule(d2, 2000, 2500);
		t3.schedule(d3, d.getTime());
		
		//SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		//System.out.println(df.format(d3.scheduledExecutionTime()));
		
		System.out.println("Le programme s'execute jusqu'à ce que les 3 timer aient executés leurs tâches");
		
		while(continu1 || continu2 || continu3)
		{
			if(System.currentTimeMillis() > end1  && continu1 == true)
			{
				System.out.println("fin du timer 1");
				continu1 = false;
				t1.cancel();
			}
			
			if(System.currentTimeMillis() > end2 && continu2 == true)
			{
				System.out.println("fin du timer 2");
				continu2 = false;
				t2.cancel();
			}
			
			if(System.currentTimeMillis() > d3.scheduledExecutionTime() && continu3==true)
			{
				System.out.println("fin du timer 3");
				continu3 = false;
				t3.cancel();
			}
		}
	}

}
