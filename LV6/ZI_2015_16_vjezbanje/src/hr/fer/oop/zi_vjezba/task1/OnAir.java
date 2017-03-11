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
				System.out.format("-------------->Igraè u eteru %s%n",  player);
				//igraè razmišlja
				Thread.sleep(r.nextInt(10000));
				//i odgovara na pitanje
				if (r.nextInt(10) == 9 ){
					data.setGameOver(true);					
					System.out.format("IGRAÈ %s OSVOJIO NAGRADU%n",  player);					
				}
				else{
					System.out.format("------------------>Igraè %s nije toèno odgovorio na pitanje%n",  player);
				}
			}			
			catch (InterruptedException e1) {
			}					
		}
	}
}
