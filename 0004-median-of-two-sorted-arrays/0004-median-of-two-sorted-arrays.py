class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        # Ensure nums1 is the smaller array to optimize binary search
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1
        
        x, y = len(nums1), len(nums2)
        low, high = 0, x
        
        while low <= high:
            # Partition nums1
            partitionX = (low + high) // 2
            # Partition nums2 based on nums1
            partitionY = (x + y + 1) // 2 - partitionX
            
            # Handle edge cases where partition is at the beginning or end
            maxLeftX = float('-inf') if partitionX == 0 else nums1[partitionX - 1]
            minRightX = float('inf') if partitionX == x else nums1[partitionX]
            
            maxLeftY = float('-inf') if partitionY == 0 else nums2[partitionY - 1]
            minRightY = float('inf') if partitionY == y else nums2[partitionY]
            
            # Check if we found the correct partition
            if maxLeftX <= minRightY and maxLeftY <= minRightX:
                # If total elements are even
                if (x + y) % 2 == 0:
                    return (max(maxLeftX, maxLeftY) + min(minRightX, minRightY)) / 2.0
                # If total elements are odd
                else:
                    return max(maxLeftX, maxLeftY)
            
            # Binary Search Logic
            elif maxLeftX > minRightY:
                # We are too far right in nums1, move left
                high = partitionX - 1
            else:
                # We are too far left in nums1, move right
                low = partitionX + 1
                