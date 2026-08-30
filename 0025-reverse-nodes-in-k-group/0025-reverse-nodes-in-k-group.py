class Solution:
    def reverseKGroup(self, head, k):
        cur = head
        count = 0

        # Step 1: check k nodes
        while cur and count < k:
            cur = cur.next
            count += 1
        if count < k:
            return head

        # Step 2: reverse k nodes
        prev = None
        cur = head
        for _ in range(k):
            nxt = cur.next
            cur.next = prev
            prev = cur
            cur = nxt

        # Step 3: connect remaining list
        head.next = self.reverseKGroup(cur, k)
        return prev
