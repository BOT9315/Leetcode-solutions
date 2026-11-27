
class Solution {
    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;

        // Find minimum price and maximum factor
        int minPrice = Integer.MAX_VALUE;
        int maxFactor = 0;

        int[] freq = new int[1501];

        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];

            freq[factor]++;

            minPrice = Math.min(minPrice, price);
            maxFactor = Math.max(maxFactor, factor);
        }

        // Count free items for each factor
        int[] count = new int[1501];

        for (int f = 1; f <= maxFactor; f++) {

            for (int j = f; j <= maxFactor; j += f) {
                count[f] += freq[j];
            }
        }

        // 0/1 Knapsack DP
        int[] dp = new int[budget + 1];

        // Unreachable states
        java.util.Arrays.fill(dp, -1000000);

        dp[0] = 0;

        for (int[] item : items) {

            int factor = item[0];
            int price = item[1];

            int free = count[factor] - 1;

            int value = 1 + free;

            // Reverse iteration for 0/1 knapsack
            for (int c = budget; c >= price; c--) {

                if (dp[c - price] != -1000000) {

                    dp[c] = Math.max(
                        dp[c],
                        dp[c - price] + value
                    );
                }
            }
        }

        // Buy additional cheapest items
        int ans = budget / minPrice;

        for (int c = 0; c <= budget; c++) {

            if (dp[c] != -1000000) {

                int remaining = budget - c;

                int total = dp[c] + remaining / minPrice;

                ans = Math.max(ans, total);
            }
        }

        return ans;
    }
}
