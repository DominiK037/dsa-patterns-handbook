import linkedlist.ListNode;

class ReverseLinkedListTwo92 {
    public static ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(0);
        ListNode currentNode = head;
        ListNode firstPartLastNode = dummy;

        //  Edge case if left is 1.
        dummy.next = head;

        //  We have 3 parts:
        //  1. Part from start(head) but before left
        //  2. Part from left to right
        //  3. Part after right till an end

        //  Part 1
        //  Place currentNode & firstPartLastNode, currentNode should end up on (left - 1) because indices starts at 0
        for (int i = 0; i < (left - 1); i++) {
            firstPartLastNode = currentNode;
            currentNode = currentNode.next;
        }
        //  For pointing next pointer backwards
        ListNode previousNode = null;

        //  Part 2: Reverse nodes from given range.
        //  previousNode will become head of the reversed nodes.
        //  currentNode will be on the node immediately after right.
        for (int i = 0; i < (right - left) + 1; i++) {
            ListNode nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }

        //  Connect part 2 & part 3
        //  Not connecting part 2 first, because we would be changing reversed node's next pointer.
        firstPartLastNode.next.next = currentNode;
        firstPartLastNode.next = previousNode;

        return dummy.next;
    }
}

//  Time Complexity: O(N) where N is the number of nodes in the linked list.
//  Space Complexity: O(1) as we are not using any extra space, apart from a few node objects which are also considered constant space.