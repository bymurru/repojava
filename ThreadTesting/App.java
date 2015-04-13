import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * 
 */

/**
 * @author nicola
 *
 */
public class App {
	
	CyclicBarrier barrier = new CyclicBarrier(3);
	static CountDownLatch latch = new CountDownLatch(3);
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyThread t1 = new MyThread("A");
		MyThread t2 = new MyThread("B");
		MyThread t3 = new MyThread("C");
		

	
		/*
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new Runnable(){
			public void run(){
			for (int i = 0; i<50;i++){
				System.out.println(Thread.currentThread().getName() + " counting " + i);
				try {
					Thread.sleep(new Random().nextInt(150));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			latch.countDown();
			}
		});
		Thread t2 = new Thread(new Runnable(){
			public void run(){
			for (int i = 0; i<50;i++){
				System.out.println("\t"+Thread.currentThread().getName() + " counting " + i);
				try {
					Thread.sleep(new Random().nextInt(150));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			latch.countDown();
			}
		});
		Thread t3 = new Thread(new Runnable(){
			public void run(){
			for (int i = 0; i<50;i++){
				System.out.println("\t\t" +Thread.currentThread().getName() + " counting " + i);
				try {
					Thread.sleep(new Random().nextInt(150));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			latch.countDown();
			}
		});*/
		
		t1.start();
		t2.start();
		t3.start();
	
		try {
			latch.await();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/*
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println("Done!");
	}
	
	static class MyThread extends Thread implements Runnable {
	
		private String name;
		
		public MyThread(String name){
			this.name = name;
		}
		
		
		public void run(){
			for (int i = 0; i<50;i++){
				System.out.println(this.name + " counting " + i);
				try {
					Thread.sleep(new Random().nextInt(150));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			latch.countDown();
			}
		};
		
		
	}
	
	


