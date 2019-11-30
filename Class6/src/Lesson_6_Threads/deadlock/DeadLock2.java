package deadlock;

class FirstThread extends Thread{
	Point resource1, resource2;
	public FirstThread(Point resource1, Point resource2) {
		this.resource1 = resource1;
		this.resource2 = resource2;
	}
	public void run() {
		// Lock resource 1
		synchronized (resource1) {
			System.out.println("Thread 1: locked resource 1");

/*			try {
				Thread.sleep(50);
			} 
			catch (InterruptedException e) {
			}
*/			synchronized (resource2) {
				System.out.println("Thread 1: locked resource 2");
			}
		}
		System.out.println("t1 DONE!");
	}

}

class SecondThread extends Thread{
	Point resource1, resource2;
	public SecondThread(Point resource1, Point resource2) {
		this.resource1 = resource1;
		this.resource2 = resource2;
	}
	public void run() {
		synchronized (resource2) {
			System.out.println("Thread 2: locked resource 2");
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {}

			synchronized (resource1) {
				System.out.println("Thread 2: locked resource 1");
			}
		}
		System.out.println("t2 DONE!");
	}

}

public class DeadLock2 {

	public static void main(String[] args) {
		final Point resource1 = new Point(1,1);
		final Point resource2 = new Point(2,3);

		FirstThread fth = new FirstThread(resource1, resource2);
		SecondThread sth = new SecondThread(resource1, resource2);
		fth.start();
		sth.start();
	}

}
