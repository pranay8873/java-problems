public class min_ele {
    public int minElement(int[] nums) {
        int minSum = Integer.MAX_VALUE;

        for (int num : nums) {
            int currentSum = 0;
            // Calculate the sum of the digits
            while (num > 0) {
                currentSum += num % 10;
                num /= 10;
            }
            // Update the minimum sum found so far
            minSum = Math.min(minSum, currentSum);
        }

        return minSum;
    }
}
