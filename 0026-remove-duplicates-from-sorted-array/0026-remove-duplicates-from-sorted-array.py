class Solution:
    def removeDuplicates(self, nums):
        if not nums:
            return 0
        
        # i points to the index of the last unique element
        i = 0
        for j in range(1, len(nums)):
            if nums[j] != nums[i]:
                i += 1
                nums[i] = nums[j]  # move unique element forward
        
        # number of unique elements is i + 1
        return i + 1




def removeDuplicates(nums):
    if not nums:
        return 0

    k = 1  # index for placing next unique element

    for i in range(1, len(nums)):
        if nums[i] != nums[i - 1]:
            nums[k] = nums[i]
            k += 1

    return k
