
	import java.util.Arrays;
	import java.util.Scanner;

	/**
	 * This class implements linear search and interpolation search algorithms to search for a key in an integer array.
	 */
	public class lab2694 {
	    /**
	     * Performs a linear search on the given array to find the specified key.
	     *
	     * @param arr the array to be searched
	     * @param key the search key
	     * @return the index of the key if found, -1 otherwise
	     */
	    public static int linearSearch(int[] arr, int key) {
	        for (int i = 0; i < arr.length; i++) {
	            if (arr[i] == key) {
	                return i; // Return the index where the key is found
	            }
	        }
	        return -1; // Return -1 if the key is not found
	    }

	    /**
	     * Performs an interpolation search on the given sorted array to find the specified key.
	     *
	     * @param arr the sorted array to be searched
	     * @param key the search key
	     * @return the index of the key if found, -1 otherwise
	     */
	    public static int interpolationSearch(int[] arr, int key) {
	        int low = 0;
	        int high = arr.length - 1;

	        while (low <= high && key >= arr[low] && key <= arr[high]) {
	            if (low == high) {
	                if (arr[low] == key) {
	                    return low;
	                }
	                break;
	            }

	            int pos = low + ((key - arr[low]) * (high - low)) / (arr[high] - arr[low]);

	            if (arr[pos] == key) {
	                return pos;
	            }

	            if (arr[pos] < key) {
	                low = pos + 1;
	            } else {
	                high = pos - 1;
	            }
	        }

	        return -1;
	    }

	    /**
	     * Performs an improved linear search on the given array to find the specified key.
	     * This implementation incorporates an early termination condition for better performance.
	     *
	     * @param arr the array to be searched
	     * @param key the search key
	     * @return the index of the key if found, -1 otherwise
	     */
	    public static int linearSearchImproved(int[] arr, int key) {
	        int lastIndex = arr.length - 1;
	        int lastElement = arr[lastIndex];

	        // Replace the last element with the key temporarily
	        arr[lastIndex] = key;

	        int i = 0;
	        while (arr[i] != key) {
	            i++;
	        }

	        // Restore the original last element
	        arr[lastIndex] = lastElement;

	        if (i < lastIndex || arr[lastIndex] == key) {
	            return i; // Return the index where the key is found
	        }

	        return -1; // Return -1 if the key is not found
	    }

	    /**
	     * Main method to demonstrate the linear search and interpolation search algorithms.
	     *
	     * @param args command line arguments (not used)
	     */
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Input the array size and elements
	        System.out.print("Enter the number of elements in the array: ");
	        int numElements = scanner.nextInt();

	        int[] arr = new int[numElements];
	        System.out.println("\nEnter the elements in the array:");
	        for (int i = 0; i < numElements; i++) {
	            arr[i] = scanner.nextInt();
	        }

	        // Input the search key
	        System.out.print("\nEnter the search key: ");
	        int key = scanner.nextInt();

	        // Linear Search
	        long linearStartTime = System.nanoTime();
	        int linearSearchIndex = linearSearch(arr, key);
	        long linearEndTime = System.nanoTime();
	        long linearExecutionTime = linearEndTime - linearStartTime;

	        if (linearSearchIndex != -1) {
	            System.out.println("\nUsing Linear Search:");
	            System.out.println("Search key FOUND at index " + linearSearchIndex + ".");
	        } else {
	            System.out.println("\nUsing Linear Search:");
	            System.out.println("Search key NOT FOUND.");
	        }
	        System.out.println("Linear Search Execution Time: " + linearExecutionTime + " nanoseconds.");

	        // Improved Linear Search
	        long improvedLinearStartTime = System.nanoTime();
	        int improvedLinearSearchIndex = linearSearchImproved(arr, key);
	        long improvedLinearEndTime = System.nanoTime();
	        long improvedLinearExecutionTime = improvedLinearEndTime - improvedLinearStartTime;

	        if (improvedLinearSearchIndex != -1) {
	            System.out.println("\nUsing Improved Linear Search:");
	            System.out.println("Search key FOUND at index " + improvedLinearSearchIndex + ".");
	        } else {
	            System.out.println("\nUsing Improved Linear Search:");
	            System.out.println("Search key NOT FOUND.");
	        }
	        System.out.println("Improved Linear Search Execution Time: " + improvedLinearExecutionTime + " nanoseconds.");

	        // Interpolation Search
	        int[] sortedArr = Arrays.copyOf(arr, arr.length);
	        Arrays.sort(sortedArr);

	        long interpolationStartTime = System.nanoTime();
	        int interpolationSearchIndex = interpolationSearch(sortedArr, key);
	        long interpolationEndTime = System.nanoTime();
	        long interpolationExecutionTime = interpolationEndTime - interpolationStartTime;

	        if (interpolationSearchIndex != -1) {
	            System.out.println("\nUsing Interpolation Search:");
	            System.out.println("Search key FOUND at index " + interpolationSearchIndex + ".");
	        } else {
	            System.out.println("\nUsing Interpolation Search:");
	            System.out.println("Search key NOT FOUND.");
	        }
	        System.out.println("Interpolation Search Execution Time: " + interpolationExecutionTime + " nanoseconds.");

	        scanner.close();
	    }
	}

