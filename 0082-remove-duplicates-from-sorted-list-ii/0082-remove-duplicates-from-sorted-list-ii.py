# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy=ListNode(0,head)
        prev=dummy
        while head:
            if head.next and head.val == head.next.val:
                #cheack the value is same if same thenn skip 

                while head.next and head.val == head.next.val:
                    #cheack value how many time same and skip

                    head = head.next
                prev.next = head.next
            else:
                prev = prev.next
                
            head=head.next
        return dummy.next



#example
## 0 1  2  3  3  3  4  5
#  p
#    H        move next if ot same
#     p  H  
#        p  H 
#           p  H   p==h then skip
#              p   H     p==h skip
#                    H  P
#                     p  H 
        