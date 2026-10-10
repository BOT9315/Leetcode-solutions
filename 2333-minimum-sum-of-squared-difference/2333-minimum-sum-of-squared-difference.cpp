
class Solution {
public:
    long long minSumSquareDiff(vector<int>& nums1, vector<int>& nums2,
                               int k1, int k2) {
        long long k = (long long)k1 + k2;
        vector<int> diff;
        int maxDiff = 0;

        for (int i = 0; i < nums1.size(); i++) {
            int d = abs(nums1[i] - nums2[i]);
            diff.push_back(d);
            maxDiff = max(maxDiff, d);
        }

        long long total = 0;
        for (int d : diff) {
            total += d;
        }

        if (k >= total) {
            return 0;
        }

        vector<long long> freq(maxDiff + 1, 0);

        for (int d : diff) {
            freq[d]++;
        }

        for (int d = maxDiff; d > 0 && k > 0; d--) {
            long long count = freq[d];
            long long moves = min(k, count);

            freq[d] -= moves;
            freq[d - 1] += moves;
            k -= moves;
        }

        long long ans = 0;

        for (int d = 1; d <= maxDiff; d++) {
            ans += freq[d] * d * d;
        }

        return ans;
    }
};
