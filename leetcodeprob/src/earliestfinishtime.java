//You are given two categories of theme park attractions: land rides and water rides.
//
//        Land rides
//landStartTime[i] – the earliest time the ith land ride can be boarded.
//landDuration[i] – how long the ith land ride lasts.
//Water rides
//waterStartTime[j] – the earliest time the jth water ride can be boarded.
//waterDuration[j] – how long the jth water ride lasts.
//A tourist must experience exactly one ride from each category, in either order.
//
//A ride may be started at its opening time or any later moment.
//If a ride is started at time t, it finishes at time t + duration.
//Immediately after finishing one ride the tourist may board the other (if it is already open) or wait until it opens.
//Return the earliest possible time at which the tourist can finish both rides.
//
//
//
//        Example 1:
//
//Input: landStartTime = [2,8], landDuration = [4,1], waterStartTime = [6], waterDuration = [3]
//
//Output: 9
public class earliestfinishtime {
    import java.util.*;


        public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
            return Math.min(solve(landStartTime, landDuration, waterStartTime, waterDuration),
                    solve(waterStartTime, waterDuration, landStartTime, landDuration));
        }

        private int solve(int[] start1, int[] dur1, int[] start2, int[] dur2) {
            int n = start1.length;
            int m = start2.length;

            // Combine and sort the second category by start time
            int[][] rides2 = new int[m][2];
            for (int i = 0; i < m; i++) {
                rides2[i][0] = start2[i];
                rides2[i][1] = dur2[i];
            }
            Arrays.sort(rides2, (a, b) -> Integer.compare(a[0], b[0]));

            int[] sortedStarts2 = new int[m];
            for (int i = 0; i < m; i++) sortedStarts2[i] = rides2[i][0];

            // Prefix Minimum of durations for Case 1 (start2 <= f1)
            int[] prefixMinDur = new int[m];
            prefixMinDur[0] = rides2[0][1];
            for (int i = 1; i < m; i++) {
                prefixMinDur[i] = Math.min(prefixMinDur[i - 1], rides2[i][1]);
            }

            // Suffix Minimum of finish times for Case 2 (start2 > f1)
            int[] suffixMinFinish = new int[m];
            suffixMinFinish[m - 1] = rides2[m - 1][0] + rides2[m - 1][1];
            for (int i = m - 2; i >= 0; i--) {
                suffixMinFinish[i] = Math.min(suffixMinFinish[i + 1], rides2[i][0] + rides2[i][1]);
            }

            int minOverallFinish = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                int f1 = start1[i] + dur1[i];

                // Binary search to find the split point where start2 > f1
                int idx = Arrays.binarySearch(sortedStarts2, f1);
                if (idx < 0) {
                    idx = -(idx + 1); // Point where starts2[idx] > f1
                } else {
                    // If found, move to the last occurrence of the same start time to include it in prefix
                    while (idx + 1 < m && sortedStarts2[idx + 1] == f1) {
                        idx++;
                    }
                    idx++; // Point where starts2[idx] > f1
                }

                int currentMinFinish = Integer.MAX_VALUE;

                // Case 1: Ride 2 can start exactly at f1 (because start2 <= f1)
                if (idx > 0) {
                    currentMinFinish = Math.min(currentMinFinish, f1 + prefixMinDur[idx - 1]);
                }

                // Case 2: Ride 2 must start after f1 (because start2 > f1)
                if (idx < m) {
                    currentMinFinish = Math.min(currentMinFinish, suffixMinFinish[idx]);
                }

                minOverallFinish = Math.min(minOverallFinish, currentMinFinish);
            }

            return minOverallFinish;
        }
    }

