package basics;

public class ThreadJoinExample {

	public static void main(String[] args) {

		JoinThread t1 = new JoinThread("Thead 1");
		JoinThread t2 = new JoinThread("Thead 2");
		JoinThread t3 = new JoinThread("Thead 3");

		System.out.println("Present thread name is " + Thread.currentThread().getName());
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
		t3.start();

	}
}

class JoinThread extends Thread {

	public JoinThread(String name) {
		super(name);
	}

	@Override
	public void run() {

		for (int i = 1; i <= 5; i++) {

			System.out.println(Thread.currentThread().getName() + " counter " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("InterruptedException for " + Thread.currentThread().getName());
			}
		}

	}
}



/*output
 * 
Present thread name is main
Thead 1 counter 1
Thead 1 counter 2
Thead 1 counter 3
Thead 1 counter 4
Thead 1 counter 5
Thead 2 counter 1
Thead 3 counter 1
Thead 2 counter 2
Thead 3 counter 2
Thead 2 counter 3
Thead 3 counter 3
Thead 2 counter 4
Thead 3 counter 4
Thead 2 counter 5
Thead 3 counter 5

 * */
