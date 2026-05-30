//You are given an integer array nums.
//
//You replace each element in nums with the sum of its digits.
//
//Return the minimum element in nums after all replacements.
//
//
//
//Example 1:
//
//Input: nums = [10,12,13,14]
//
//Output: 1
//
//Explanation:
//
//nums becomes [1, 3, 4, 5] after all replacements, with minimum element 1.
//
//Example 2:
//
//Input: nums = [1,2,3,4]
//
//Output: 1
//
//Explanation:
//
//nums becomes [1, 2, 3, 4] after all replacements, with minimum element 1.

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
