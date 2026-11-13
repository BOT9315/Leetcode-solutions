
class Solution {
public:
    long long countNonDecreasingSubarrays(vector<int>& nums, int k) {
        int n = nums.size();

        // Step 1: Prefix Sum
        vector<long long> pref(n + 1, 0);

        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + nums[i];
        }

        // Step 2: Next Greater Element
        vector<int> nxt(n + 1, n);
        stack<int> st;

        for (int i = n - 1; i >= 0; i--) {

            while (!st.empty() && nums[st.top()] <= nums[i]) {
                st.pop();
            }

            if (!st.empty()) {
                nxt[i] = st.top();
            }

            st.push(i);
        }

        // Step 3: Binary Lifting
        int LOG = 1;

        while ((1 << LOG) <= n) {
            LOG++;
        }

        vector<vector<int>> up(LOG, vector<int>(n + 1, n));

        vector<vector<long long>> cost(
            LOG, vector<long long>(n + 1, 0)
        );

        // Base case
        for (int i = 0; i < n; i++) {

            up[0][i] = nxt[i];

            int len = nxt[i] - i;

            cost[0][i] =
                1LL * nums[i] * len -
                (pref[nxt[i]] - pref[i]);
        }

        // Build binary lifting tables
        for (int j = 1; j < LOG; j++) {

            for (int i = 0; i < n; i++) {

                int mid = up[j - 1][i];

                up[j][i] = up[j - 1][mid];

                cost[j][i] =
                    cost[j - 1][i] +
                    cost[j - 1][mid];
            }
        }

        // Step 4: Calculate operations in [l, r]
        auto getCost = [&](int l, int r) -> long long {

            long long ans = 0;
            int pos = l;

            for (int j = LOG - 1; j >= 0; j--) {

                int nextPos = up[j][pos];

                if (nextPos <= r + 1) {

                    ans += cost[j][pos];

                    pos = nextPos;
                }
            }

            // Remaining partial section
            if (pos <= r) {

                long long len = r - pos + 1;

                ans += 1LL * nums[pos] * len -
                       (pref[r + 1] - pref[pos]);
            }

            return ans;
        };

        // Step 5: Sliding Window + Binary Search
        long long answer = 0;

        for (int r = 0; r < n; r++) {

            int low = 0;
            int high = r;

            // Find smallest valid left index
            while (low < high) {

                int mid = low + (high - low) / 2;

                if (getCost(mid, r) <= k) {
                    high = mid;
                }
                else {
                    low = mid + 1;
                }
            }

            answer += (r - low + 1);
        }

        return answer;
    }
};
