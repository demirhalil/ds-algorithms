package arrays;

public class Mountain {

    public static void main(String[] args) {
        int[] input = {5, 6, 1, 2, 3, 4, 5, 4, 3, 2, 0, 1, 2, 3, -2, 4};
        System.out.println(highestMountain(input));
    }

    /**
     * The time complexity is => O(N)
     */
    private static int highestMountain(int[] arr) {
        int highestMountain = 0;

        /**
         * Ignore first and last element because they cannot be peak
         */
        for (int i = 1; i <= arr.length - 2; ) {
            /**
             * Check if current element is peak or not
             */
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                int count = 1;
                int j = i;
                /**
                 * Count backwards(left side)
                 */
                while (j >= 1 && arr[j] > arr[j - 1]) {
                    j--;
                    count++;
                }
                /**
                 * Count forwards(right side)
                 */
                while (i <= arr.length - 2 && arr[i] > arr[i + 1]) {
                    i++;
                    count++;
                }
                highestMountain = Math.max(count, highestMountain);
            } else {
                i++;
            }
        }
        return highestMountain;
    }


}
