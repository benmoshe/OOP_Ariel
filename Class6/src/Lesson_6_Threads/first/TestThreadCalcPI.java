package first;
class ThreadCalcPI extends Thread{
   boolean negative = true;
   double pi=0.0; // Initializes to 0.0, by default
   public void run (){
      for (long i = 3; i < 100000000; i=i+2){
           if (negative)
               pi = pi - (1.0 / i);
           else
               pi = pi + (1.0 / i);
           negative = !negative;
      }
      pi = pi + 1.0;
      pi = pi*4.0;
      System.out.println ("Finished calculating PI");
   }
}

public class TestThreadCalcPI {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		ThreadCalcPI calcPi = new ThreadCalcPI ();
		System.out.println(calcPi.getState());
		calcPi.start ();
		System.out.println(calcPi.getState());
		int i = 0;
		while (calcPi.isAlive()){
		   try{
		       Thread.sleep (200); // Sleep for 200 milliseconds
		       System.out.println("Thread is alive? "+calcPi.isAlive()+"i= "+(i++));
				System.out.println(calcPi.getState());
		   }
		   catch (InterruptedException e){}
		}
		System.out.println ("pi = " + calcPi.pi);
		System.out.println(calcPi.getState());
	}
}
