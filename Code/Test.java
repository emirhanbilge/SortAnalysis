import java.util.Random;

public class Test {

	public static void main(String[] args) {

		int Capacity = 100000; // Change 1 000 & 10 000 & 100 000
		
		int[] equalInteger = new int[Capacity];
		int[] randomInteger = new int[Capacity];
		int[] increasingInteger = new int[Capacity];
		int[] decreasingInteger = new int[Capacity];
		Random generate = new Random();

		for (int i = 0; i < Capacity; i++) {
			equalInteger[i] = 0;
			randomInteger[i] = generate.nextInt(Integer.MAX_VALUE);
			increasingInteger[i] = i;
			decreasingInteger[i] = (Integer.MAX_VALUE - i);
		}

		long start = System.currentTimeMillis();
		// SortingClass.shellSort(equalInteger);
		// SortingClass.dualPivotQuicksort(equalInteger, 0, equalInteger.length - 1);
		SortingClass.heapSort(equalInteger);
		System.out.println("Time 1 :" + (System.currentTimeMillis() - start));

		start = System.currentTimeMillis();
		// SortingClass.shellSort(randomInteger);
		// SortingClass.dualPivotQuicksort(randomInteger, 0, randomInteger.length - 1);
		SortingClass.heapSort(randomInteger);
		System.out.println("Time 2 :" + (System.currentTimeMillis() - start));

		start = System.currentTimeMillis();
		// SortingClass.shellSort(increasingInteger);
		// SortingClass.dualPivotQuicksort(increasingInteger, 0, increasingInteger.length - 1);
		SortingClass.heapSort(increasingInteger);
		System.out.println("Time 3 :" + (System.currentTimeMillis() - start));

		start = System.currentTimeMillis();
		// SortingClass.shellSort(decreasingInteger);
		// SortingClass.dualPivotQuicksort(decreasingInteger,0,decreasingInteger.length-1);
		SortingClass.heapSort(decreasingInteger);
		System.out.println("Time 4 :" + (System.currentTimeMillis() - start));

		/***
		 * 
		 * If the see stackoverFlow error
		 * 
		 * Run ->>Run Configuration ->>Argumants --> VM argumants --> Xss4m (mean = 4m
		 * is enough for 100 000)
		 * 
		 */
	}

}
