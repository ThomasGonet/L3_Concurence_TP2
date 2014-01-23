package ex1;

public class Thrv2 {

	public static volatile int cp = 0;
	public static volatile boolean continu = true;


	public static void main(String[] args){

		//final Thrv2 test = new Thrv2();

		Runnable r1 = new Runnable(){
			public synchronized void run()
			{
				System.out.println("A");
				//System.out.println("notifyAll A");
				notifyAll();
				try {
					wait(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				while(continu)
				{
					//System.out.println(cp);
					if(cp == 2)
					{
						System.out.println(".");
						continu = false;						
					}
					else
					{
						//System.out.println("notifyAll A");
						notifyAll();
						try {
							wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			}};

			Runnable r2 = new Runnable(){
				public synchronized void run()
				{
					try {
						wait();
						//System.out.println("wait B");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("B");
					cp++;
					notifyAll();
				}
			};

			Runnable r3 = new Runnable(){
				public synchronized void run()
				{
					try {
						wait();
						//System.out.println("wait B");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("C");
					cp++;
					notifyAll();
				}
			};

			Thread t1 = new Thread(r1, "r1");
			Thread t2 = new Thread(r2, "r2");
			Thread t3 = new Thread(r3, "r3");

			t1.start();
			t2.start();
			t3.start();
	}
	
}