import java.util.Arrays;
import java.util.Arrays;
//A shop is selling candies at a discount. For every two candies sold, the shop gives a third candy for free.
//
//The customer can choose any candy to take away for free as long as the cost of the chosen candy is less than or equal to the minimum cost of the two candies bought.
//
//For example, if there are 4 candies with costs 1, 2, 3, and 4, and the customer buys candies with costs 2 and 3, they can take the candy with cost 1 for free, but not the candy with cost 4.
//Given a 0-indexed integer array cost, where cost[i] denotes the cost of the ith candy, return the minimum cost of buying all the candies.
//
//
//
//Example 1:
//
//Input: cost = [1,2,3]
//Output: 5
//Explanation: The customer can buy the first two candies for a total cost of 3 and take the third candy for free.
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

