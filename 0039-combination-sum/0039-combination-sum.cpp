class Solution {
public:
    vector<vector<int>> result;
    vector<int> path;

    void backtrack(vector<int>& candidates, int target, int start) {
        if (target == 0) {
            result.push_back(path);
            return;
        }

        if (target < 0) return;

        for (int i = start; i < candidates.size(); i++) {
            path.push_back(candidates[i]);
            backtrack(candidates, target - candidates[i], i);  // reuse allowed
            path.pop_back();
        }
    }

    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        backtrack(candidates, target, 0);
        return result;
    }
};
