package first;

class MyThread extends Thread{
	public MyThread(String name){
		super(name);
	}
	public void run() {
		for (long i=0; i<=100; i++) {
			System.out.print(i + ")");
			for(int a=0;a<40;a++) {
				System.out.print(this.getName());
			}
			System.out.println();
		}
		System.out.println(this.getName()+ "  DONE!");
	} 
}

public class SimpleThread1 {

	public static void main(String[] args) {
		MyThread t1 = new MyThread("a");
		System.out.println("t1 State:  " + t1.getState());
		MyThread t2 = new MyThread("b");
		System.out.println("t2 State:  " + t2.getState());
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		System.out.println("t1 State:  " + t1.getState());
		t2.start();
		System.out.println("t2 State:  " + t2.getState());
		System.out.println("main exit");
	}
}
