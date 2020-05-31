public class SortingClass {

	public static void heapSort(int array[]) {
		int size = array.length;
		for (int i = size / 2 - 1; i >= 0; i--)
			heapify(array, size, i);

		for (int i = size - 1; i >= 0; i--) {

			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			heapify(array, i, 0);
		}
	}

	static void heapify(int array[], int n, int i) {
		int largestRoot = i;
		int left = 2 * i + 1; // left = 2*i + 1
		int right = 2 * i + 2; // right = 2*i + 2

		if (left < n && array[left] > array[largestRoot])
			largestRoot = left;

		if (right < n && array[right] > array[largestRoot])
			largestRoot = right;

		if (largestRoot != i) {
			int swap = array[i];
			array[i] = array[largestRoot];
			array[largestRoot] = swap;
			heapify(array, n, largestRoot);
		}
	}

	static void shellSort(int array[]) {
		int size = array.length;
		for (int buffer = size / 2; buffer > 0; buffer /= 2) {
			for (int i = buffer; i < size; i += 1) {
				int temp = array[i];
				int j;
				for (j = i; j >= buffer && array[j - buffer] > temp; j -= buffer)
					array[j] = array[j - buffer];
				array[j] = temp;
			}
		}
	}

	static void dualPivotQuicksort(int[] array, int left, int right) {
		if (right > left) {

			if (array[left] > array[right]) {
				swap(array, left, right);
			} // left sides value bigger than right sides value , Rule 1
			int pivotFirst = array[left], pivotSecond = array[right];
			int l = left + 1;
			int r = right - 1;
			int loopC = l;
			while (loopC <= r) {
				if (array[loopC] < pivotFirst) {
					swap(array, loopC, l);
					++l;
				} else if (array[loopC] >= pivotSecond) {
					while (array[r] > pivotSecond && loopC < r) {
						--r;
					}
					swap(array, loopC, r);
					--r;
					if (array[loopC] < pivotFirst) {
						swap(array, loopC, l);
						++l;
					}
				}
				++loopC;
			}
			--l;
			++r;

			swap(array, left, l);
			swap(array, right, loopC);
			dualPivotQuicksort(array, left, l - 1);
			dualPivotQuicksort(array, l + 1, loopC - 1);
			dualPivotQuicksort(array, loopC + 1, right);
		}
	}

	static void swap(int[] array, int first, int second) {
		int temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}

}
