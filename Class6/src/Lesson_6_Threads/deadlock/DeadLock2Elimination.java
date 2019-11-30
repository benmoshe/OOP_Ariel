package deadlock;
class FirstThreadElim extends Thread{
	Point resource1, resource2;
	public FirstThreadElim(Point resource1, Point resource2) {
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

class SecondThreadElim extends Thread{
	Point resource1, resource2;
	FirstThreadElim fth;
	public SecondThreadElim(Point resource1, Point resource2, FirstThreadElim fth) {
		this.resource1 = resource1;
		this.resource2 = resource2;
		this.fth = fth;
	}
	public void run() {
		while (fth.isAlive());
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


public class DeadLock2Elimination {

	public static void main(String[] args) {
		final Point resource1 = new Point(1,1);
		final Point resource2 = new Point(2,3);

		FirstThreadElim fth = new FirstThreadElim(resource1, resource2);
		SecondThreadElim sth = new SecondThreadElim(resource1, resource2, fth);
		fth.start();
		sth.start();

	}

}
