package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triplets {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 15};
        int sum = 18;

        List<int[]> result = triplets(arr, sum);

        for (int[] ints : result) {
            System.out.println(Arrays.deepToString(new int[][]{ints}));
        }
    }

    /**
     * Complexity => O(N*logN + N^2) = O(N^2)
     */
    private static List<int[]> triplets(int[] arr, int sum) {
        /**
         * Complexity of sorting is O(N*logN)
         */
        Arrays.sort(arr);
        List<int[]> result = new ArrayList<>();

        /**
         * Complexity of this two pointer operation is O(N^2)
         */
        // Pick every a[i], pair sum for remaining part
        for (int i = 0; i <= arr.length - 3; i++) {
            int j = i + 1;
            int k = arr.length - 1;
            while (j < k) {
                int currentSum = arr[i];
                currentSum += arr[j];
                currentSum += arr[k];

                if (currentSum == sum) {
                    result.add(new int[]{arr[i], arr[j], arr[k]});
                    j++;
                    k--;
                } else if (currentSum > sum) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }
}
