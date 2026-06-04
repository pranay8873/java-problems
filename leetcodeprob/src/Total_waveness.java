//You are given two integers num1 and num2 representing an inclusive range [num1, num2].
//
//The waviness of a number is defined as the total count of its peaks and valleys:
//
//A digit is a peak if it is strictly greater than both of its immediate neighbors.
//A digit is a valley if it is strictly less than both of its immediate neighbors.
//The first and last digits of a number cannot be peaks or valleys.
//Any number with fewer than 3 digits has a waviness of 0.
//Return the total sum of waviness for all numbers in the range [num1, num2].

public class Total_waveness {

        public int totalWaviness(int num1, int num2) {
            int ans = 0;
            for (int x = num1; x <= num2; x++) {
                ans += f(x);
            }
            return ans;
        }

        private int f(int x) {
            int[] nums = new int[20];
            int m = 0;
            // Extract digits
            while (x > 0) {
                nums[m++] = x % 10;
                x /= 10;
            }

            // Numbers with fewer than 3 digits have a waviness of 0
            if (m < 3) {
                return 0;
            }

            int s = 0;
            // The digits were stored in reverse order, but checking
            // neighbors remains the same for peak/valley logic
            for (int i = 1; i < m - 1; i++) {
                // Check for peak
                if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                    s++;
                }
                // Check for valley
                else if (nums[i] < nums[i - 1] && nums[i] < nums[i + 1]) {
                    s++;
                }
            }
            return s;
        }

}
