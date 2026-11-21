
import java.util.*;

class Solution {

    List<Integer>[] tree;
    List<Integer>[] newTree;
    int[] answer;
    int[] newParent;
    char[] str;

    public int[] findSubtreeSizes(int[] parent, String s) {

        int n = parent.length;

        tree = new ArrayList[n];
        newTree = new ArrayList[n];

        answer = new int[n];
        newParent = parent.clone();
        str = s.toCharArray();

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
            newTree[i] = new ArrayList<>();
        }

        // Build original tree
        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }

        // Store the closest ancestor for each character
        int[] last = new int[26];
        Arrays.fill(last, -1);

        dfsFind(0, last);

        // Build modified tree
        for (int i = 1; i < n; i++) {
            newTree[newParent[i]].add(i);
        }

        // Calculate subtree sizes
        dfsSize(0);

        return answer;
    }

    void dfsFind(int node, int[] last) {

        int ch = str[node] - 'a';

        int old = last[ch];

        // Find closest ancestor with same character
        if (old != -1) {
            newParent[node] = old;
        }

        last[ch] = node;

        // Visit original children
        for (int child : tree[node]) {
            dfsFind(child, last);
        }

        // Backtrack
        last[ch] = old;
    }

    int dfsSize(int node) {

        int size = 1;

        for (int child : newTree[node]) {
            size += dfsSize(child);
        }

        answer[node] = size;

        return size;
    }
}
