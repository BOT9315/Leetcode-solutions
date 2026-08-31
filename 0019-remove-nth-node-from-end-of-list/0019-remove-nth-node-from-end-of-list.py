class Solution(object):
    def removeNthFromEnd(self, head, n):
        dummy = ListNode(0)
        dummy.next = head

        fast = dummy
        slow = dummy

        # move fast n steps ahead
        for _ in range(n):
            fast = fast.next

        # move both until fast reaches last node
        while fast.next:
            fast = fast.next
            slow = slow.next

        # remove nth node from end
        slow.next = slow.next.next

        return dummy.next
