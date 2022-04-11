package arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestBand {

    public static void main(String[] args) {
        int[] arr = {1, 9, 3, 0, 18, 5, 2, 4, 10, 7, 12, 6};
        System.out.println(longestBand(arr));
    }

    private static int longestBand(int[] arr) {
        int longestBand = 0;
        Set<Integer> data = new HashSet<>();

        for (Integer curr : arr) {
            data.add(curr);
        }

        for (Integer element : data) {
            int parent = element - 1;
            if (!data.contains(parent)) {
                // find the entire band starting from the element
                int nextNumber = element + 1;
                int tempCounter = 1;

                while (data.contains(nextNumber)) {
                    nextNumber++;
                    tempCounter++;
                }

                longestBand = Math.max(tempCounter, longestBand);
            }
        }
        return longestBand;
    }

}
