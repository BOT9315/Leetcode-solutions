
class Solution {
public:
    vector<int> assignTasks(vector<int>& servers, vector<int>& tasks) {

        priority_queue<pair<int, int>,
            vector<pair<int, int>>,
            greater<pair<int, int>>> free;

        priority_queue<tuple<long long, int, int>,
            vector<tuple<long long, int, int>>,
            greater<tuple<long long, int, int>>> busy;

        int n = servers.size();
        int m = tasks.size();

        vector<int> ans(m);

        // Add all servers to free heap
        for (int i = 0; i < n; i++) {
            free.push({servers[i], i});
        }

        long long currentTime = 0;

        for (int i = 0; i < m; i++) {

            currentTime = max(currentTime, (long long)i);

            // Release servers that have completed tasks
            while (!busy.empty() &&
                   get<0>(busy.top()) <= currentTime) {

                auto [time, weight, index] = busy.top();
                busy.pop();

                free.push({weight, index});
            }

            // Wait if all servers are busy
            if (free.empty()) {

                currentTime = get<0>(busy.top());

                // Release all servers available at this time
                while (!busy.empty() &&
                       get<0>(busy.top()) <= currentTime) {

                    auto [time, weight, index] = busy.top();
                    busy.pop();

                    free.push({weight, index});
                }
            }

            // Select server with smallest weight and index
            auto [weight, index] = free.top();
            free.pop();

            ans[i] = index;

            // Mark server as busy
            busy.push({
                currentTime + tasks[i],
                weight,
                index
            });
        }

        return ans;
    }
};
