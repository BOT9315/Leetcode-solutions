import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>()
        for (int i = 0; i < nums.l
            if (map.containsKey(
                return new int[]{map.get(n
            map.put(nums[i]
        re
