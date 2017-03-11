package hr.fer.oop.zi_vjezba.task1;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Employee extends Thread {
	private SharedData data;	
	private int num;

	public Employee(SharedData data, int i) {
		this.data = data;		
		num = i;
	}

	public void run() {
		Random r = new Random();
		while (!data.isGameOver()) {
			try {				
				String player = data.getQueue().take();
				if (data.isGameOver()) break;
				System.out.format("Djelatnik %d preuzeo igra�a %s (rbr: %d) %n", num, player, data.nextId());
				// igra� razmi�lja
				Thread.sleep(r.nextInt(5000));
				// i odgovara na pitanje
				
				if (data.isGameOver()) break;//igra zavr�ena, svejedno �to je odgovorio
				if (r.nextBoolean()) {
					System.out.format("--->Igra� %s �eka uklju�enje u eter%n", player);
					// igra� �eka za u eter
					Thread t = new Thread(() -> {
						try {
							data.getAirQueue().put(player);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					});
					t.setDaemon(true);
					t.start();
				} else {
					System.out.format("Igra� %s nije to�no odgovorio na kvalifikacijsko pitanje%n", player);							
				}
				
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
}
