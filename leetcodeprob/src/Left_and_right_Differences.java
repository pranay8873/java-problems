public class Left_and_right_Differences {

        public int[] leftRightDifference(int[] nums) {
            int n = nums.length;
            int[] answer = new int[n];

            // Step 1: Calculate total sum
            int totalSum = 0;
            for (int num : nums) {
                totalSum += num;
            }

            // Step 2: Calculate leftSum and rightSum for each index
            int leftSum = 0;
            for (int i = 0; i < n; i++) {
                // rightSum is total minus what's on the left and the current element
                int rightSum = totalSum - leftSum - nums[i];

                // Calculate absolute difference
                answer[i] = Math.abs(leftSum - rightSum);

                // Update leftSum for the next index
                leftSum += nums[i];
            }

            return answer;
        }

}
