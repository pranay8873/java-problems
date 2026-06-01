import java.util.Arrays;
import java.util.Arrays;

public class candies_problem {
    {
        public int minimumCost(int[] cost) {
            // Sort the array in ascending order
            Arrays.sort(cost);

            int totalCost = 0;
            int n = cost.length;

            // Iterate from the most expensive candy down to the cheapest
            for (int i = n - 1; i >= 0; i--) {
                // Calculate the position of the candy in our current sequence
                int position = n - 1 - i;

                // We buy the 1st and 2nd candies, but get the 3rd for free.
                // If position % 3 is 2, it is the 3rd candy in the group, so we skip adding its cost.
                if (position % 3 != 2) {
                    totalCost += cost[i];
                }
            }

            return totalCost;
        }
    }

