package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PairSum {
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 3, -6, 9, 11};
        int sum = 4;
        System.out.println("Brute force approach: " + Arrays.toString(pairSumWithBruteForce(arr, sum)));

        System.out.println("-------------------------");

        System.out.println("Sorting approach: " + Arrays.toString(pairSumWithSorting(arr,sum)));

        System.out.println("-------------------------");

        System.out.println("Using set: " + Arrays.toString(pairSumWithSorting(arr,sum)));
    }

    /**
     * Complexity is O(N^2)
     */
    private static int[] pairSumWithBruteForce(int[] arr, int sum) {
        int[] result = new int[2];

        for (int i = 0; i <= arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length ; j++) {
                int tempSum = arr[i] + arr[j];
                if (tempSum == sum) {
                    result[0] = arr[i];
                    result[1] = arr[j];
                    return result;
                }
            }
        }
        Arrays.fill(result, -1);
        return result;
    }

    /**
     * Complexity is O(N*logN)
     * Binary search complexity is O(logN)
     */
    private static int[] pairSumWithSorting(int[] arr, int sum) {
        int[] result = new int[2];
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int leftOver = sum - arr[i];
            int found = Arrays.binarySearch(arr, leftOver);
            if (found > 0) {
                result[0] = arr[i];
                result[1] = arr[found];
                return result;
            }
        }
        Arrays.fill(arr, -1);
        return result;
    }

    /**
     * Complexity is O(N)
     * Set used for performance improvement
     */
    private static int[] pairSumWithSet(int[] arr, int sum) {
        int[] result = new int[2];
        Set<Integer> data = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            int leftOver = sum - arr[i];
            if (data.contains(leftOver)) {
                result[0] = arr[i];
                result[1] = leftOver;
                return result;
            }
            data.add(arr[i]);
        }
        Arrays.fill(result, -1);
        return result;
    }
}
