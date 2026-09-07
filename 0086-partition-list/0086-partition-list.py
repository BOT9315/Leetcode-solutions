# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:    
# Dummy nodes
        small = ListNode(0)
        large = ListNode(0)
        
        small_tail = small
        large_tail = large

        current = head
        while current:
            if current.val < x:
                small_tail.next = current
                small_tail = small_tail.next
            else:
                large_tail.next = current
                large_tail = large_tail.next
            current = current.next

        # End large list
        large_tail.next = None
        # Connect lists
        small_tail.next = large.next
        return small.next
     
     