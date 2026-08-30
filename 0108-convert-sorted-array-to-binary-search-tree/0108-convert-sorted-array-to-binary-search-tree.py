# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def sortedArrayToBST(self, nums):
        """
        :type nums: List[int]
        :rtype: Optional[TreeNode]
        """

        def createTree(left, right):

            # No elements
            if left > right:
                return None

            # Find middle
            mid = (left + right) // 2

            # Create root
            root = TreeNode(nums[mid])

            # Left half
            root.left = createTree(left, mid - 1)

            # Right half
            root.right = createTree(mid + 1, right)

            return root

        return createTree(0, len(nums) - 1)