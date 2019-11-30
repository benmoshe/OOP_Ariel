package Lesson_6_Threads.threadCountPrimes;

public class CountPrimes {
	private static int numPrimes = 0;

	private static class CountPrimesThread extends Thread {
		int count = 0;
		int min, max;
		public CountPrimesThread(int min, int max) {
			this.min = min;
			this.max = max;
		}
		public void run() {
			count = countPrimes(min,max);
/*			System.out.println("There are " + count + 
					" primes between " + min + " and " + max);
*/			addToNumPrimes(count);
		}
	}
	public static void countPrimesWithThreads(int numThreads, int min, int max) {
		int step = (max - min)/numThreads;
		CountPrimesThread[] counter = new CountPrimesThread[numThreads];
		int from = 0, to = min-1;//for numThreads=1
		for(int i=0; i<numThreads-1; i++) {
			from = i*step+min; 
			to = from+step-1;
			counter[i] = new CountPrimesThread(from, to);
		}
		from = to+1; to = max;
		if (from <= to) counter[numThreads-1] = new CountPrimesThread(from, to);

		for(int i=0; i<numThreads; i++) {
			counter[i].start();
		}
		boolean flag = true;
		while(flag) {
			flag = counter[0].isAlive();
			for (int i=1; i<numThreads; i++) {
				flag = flag || counter[i].isAlive();
			}
		}

	}
	synchronized private static void addToNumPrimes(int num) {
		numPrimes = numPrimes + num;
		//System.out.println(numPrimes + " primes found");
	}

	public static int getNumPrimes() {
		return numPrimes;
	}
	private static boolean isPrime(int n) {
		double sq = Math.sqrt(n);
		for (int i = 2; i <= sq; i++) {
			if ( n % i == 0 ) return false;
		}
		return true;
	}
	static int countPrimes(int min, int max) {
		int count = 0;
		for (int i = min; i <= max; i++) {
			if (isPrime(i)) count++;
		}
		return count;
	}

}
