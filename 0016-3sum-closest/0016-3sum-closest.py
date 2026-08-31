class Solution(object):
    def threeSumClosest(self, nums, target):
        nums.sort()
        n = len(nums)

        closest = nums[0] + nums[1] + nums[2]

        for i in range(n - 2):
            l, r = i + 1, n - 1

            while l < r:
                curr = nums[i] + nums[l] + nums[r]

                if abs(curr - target) < abs(closest - target):
                    closest = curr

                if curr < target:
                    l += 1
                elif curr > target:
                    r -= 1
                else:
                    return curr  # exact match

        return closest
