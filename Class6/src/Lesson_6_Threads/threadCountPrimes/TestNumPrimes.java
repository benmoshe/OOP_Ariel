package Lesson_6_Threads.threadCountPrimes;

public class TestNumPrimes {

	public static void main(String[] args) {
		int numThreads = 100,min = 2, max = 1000000;
		long start = System.currentTimeMillis();
		CountPrimes.countPrimesWithThreads(numThreads, min, max);
		long end = System.currentTimeMillis();
		System.out.println("numOfPrimes = " + CountPrimes.getNumPrimes());
		System.out.println("time with threads: "+(end-start)+" ms");
		////////
		start = System.currentTimeMillis();
		int np = CountPrimes.countPrimes(min, max);
		end = System.currentTimeMillis();
		System.out.println("num of primes = " + np);
		System.out.println("time: "+(end-start)+" ms");
	}
}
