package exo3;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;

public class DonneHeure extends TimerTask {

	private String nom;
	long t0;
	
	public DonneHeure(String nom){
		this.nom = nom;
		t0 = System.currentTimeMillis();
	}
	
	
	@Override
	public void run() {
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		System.out.println("Heure de "+nom+" :");
		System.out.println(df.format(Calendar.getInstance().getTime()));
		
	}
	
	

}
