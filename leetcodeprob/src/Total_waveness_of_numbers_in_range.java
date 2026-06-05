//3753. Total Waviness of Numbers in Range II
//Solved
//Hard
//Topics
//premium lock icon
//Companies
//Hint
//You are given two integers num1 and num2 representing an inclusive range [num1, num2].
//
//The waviness of a number is defined as the total count of its peaks and valleys:
//
//A digit is a peak if it is strictly greater than both of its immediate neighbors.
//A digit is a valley if it is strictly less than both of its immediate neighbors.
//The first and last digits of a number cannot be peaks or valleys.
//Any number with fewer than 3 digits has a waviness of 0.
//Return the total sum of waviness for all numbers in the range [num1, num2]

public class Total_waveness_of_numbers_in_range {


        static class Pair {
            long cnt;
            long wav;

            Pair(long c, long w) {
                cnt = c;
                wav = w;
            }
        }

        private String s;
        private Pair[][][][][][] memo;
        private boolean[][][][][][] vis;

        public long totalWaviness(long num1, long num2) {
            return solve(num2) - solve(num1 - 1);
        }

        private long solve(long n) {
            if (n < 0) return 0;

            s = String.valueOf(n);
            int m = s.length();

            memo = new Pair[m + 1][2][2][20][11][11];
            vis = new boolean[m + 1][2][2][20][11][11];

            return dfs(0, 1, 0, 0, 10, 10).wav;
        }

        private Pair dfs(int pos, int tight, int started,
                         int len, int prev2, int prev1) {

            if (pos == s.length()) {
                return new Pair(1, 0);
            }

            if (vis[pos][tight][started][len][prev2][prev1]) {
                return memo[pos][tight][started][len][prev2][prev1];
            }

            vis[pos][tight][started][len][prev2][prev1] = true;

            long totalCnt = 0;
            long totalWav = 0;

            int limit = tight == 1 ? s.charAt(pos) - '0' : 9;

            for (int d = 0; d <= limit; d++) {

                int ntight = (tight == 1 && d == limit) ? 1 : 0;

                if (started == 0 && d == 0) {
                    Pair nxt = dfs(pos + 1, ntight, 0,
                            0, 10, 10);

                    totalCnt += nxt.cnt;
                    totalWav += nxt.wav;
                } else {

                    int add = 0;

                    if (len >= 2) {
                        if ((prev1 > prev2 && prev1 > d) ||
                                (prev1 < prev2 && prev1 < d)) {
                            add = 1;
                        }
                    }

                    int nPrev2 = (len == 0) ? 10 : prev1;
                    int nPrev1 = d;

                    Pair nxt = dfs(pos + 1, ntight, 1,
                            len + 1, nPrev2, nPrev1);

                    totalCnt += nxt.cnt;
                    totalWav += nxt.wav + (long) add * nxt.cnt;
                }
            }

            return memo[pos][tight][started][len][prev2][prev1]
                    = new Pair(totalCnt, totalWav);
        }
    }

