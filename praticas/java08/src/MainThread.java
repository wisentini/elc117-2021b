import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

class MyThread extends Thread {
	private char id;

	public MyThread(char id) {
		this.id = id;
	}

	public void run() {
		for (int count = 0; count < 10; count++) {
			System.out.println("Thread " + id + " counting: " + count);
		}
	}
}

class MyRunnable implements Runnable {
	private char id;

	public MyRunnable(char id) {
		this.id = id;
	}

	public void run() {
		for (int count = 0; count < 10; count++) {
			System.out.println("Runnable " + id + " counting: " + count);
		}
	}
}

class MyOtherThread extends Thread {
	private char id;

	public MyOtherThread(char id) {
		this.id = id;
	}

	private String getCurrentTime() {
		long currentTimeMillis = System.currentTimeMillis();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SS");
			Date date = new Date(currentTimeMillis);
			String currentTime = simpleDateFormat.format(date);
			return currentTime;
	}

	public void run() {
		int n = 20;

		for (int i = 0; i < n; i++) {
			String currentTime = getCurrentTime();
			System.out.println("Runnable " + this.id + ": " + currentTime);
		}
	}
}

class MyOtherRunnable implements Runnable {
	private char id;

	public MyOtherRunnable(char id) {
		this.id = id;
	}

	public void run() {
		for (int count = 0; count < 10; count++) {
			Random random = new Random();
			int randomNumber = random.nextInt(10) + 1;
			System.out.println("Runnable " + this.id + ": " + randomNumber);
		}
	}
}

class MainThread {
	public static void main(String[] args) {
		MyThread t1 = new MyThread('A');
		t1.start();

		Thread t2 = new Thread(new MyRunnable('B'));
		t2.start();

		MyOtherThread t3 = new MyOtherThread('C');
		t3.start();

		Thread t4 = new Thread(new MyOtherRunnable('D'));
		t4.start();
	}
}
