import heapq

class Solution(object):
    def mergeKLists(self, lists):
        dummy = ListNode(0)
        curr = dummy
        heap = []

        # initialize heap
        for i, node in enumerate(lists):
            if node:
                # store tuple (node value, index, node) to avoid comparison issues
                heapq.heappush(heap, (node.val, i, node))

        while heap:
            val, i, node = heapq.heappop(heap)
            curr.next = node
            curr = curr.next
            if node.next:
                heapq.heappush(heap, (node.next.val, i, node.next))

        return dummy.next
