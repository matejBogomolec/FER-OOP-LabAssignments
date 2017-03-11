package hr.fer.oop.zi_vjezba.task1;

import java.util.Random;

public class OnAir extends Thread {
	private SharedData data;

	public OnAir(SharedData data) {
		this.data = data;		
	}

	public void run() {
		Random r = new Random();
		while(!data.isGameOver()){		
			try {
				String player = data.getAirQueue().take();
				System.out.format("-------------->Igra� u eteru %s%n",  player);
				//igra� razmi�lja
				Thread.sleep(r.nextInt(10000));
				//i odgovara na pitanje
				if (r.nextInt(10) == 9 ){
					data.setGameOver(true);					
					System.out.format("IGRA� %s OSVOJIO NAGRADU%n",  player);					
				}
				else{
					System.out.format("------------------>Igra� %s nije to�no odgovorio na pitanje%n",  player);
				}
			}			
			catch (InterruptedException e1) {
			}					
		}
	}
}
