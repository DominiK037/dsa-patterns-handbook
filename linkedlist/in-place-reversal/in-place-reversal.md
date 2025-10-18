## Pattern: In-place-reversal of a LinkedList

### **Look for these Hints & Constraints**

- Where we are asked to reverse nodes (all nodes/ certain range of nodes) 
- In-place (i.e. without using an extra space & using existing objects)
- Single pass O(n). (This is not mandatory but mostly yes)

### Approach:

- Reverse one node at a time using `previousNode, currentNode & nextNode`


- `currentNode` will point to head of the **LinkedList**.


- Initially `previousNode` will point to null. Because there is no node before the head, makes sense?


- We will keep incrementing `previousNode` as we process further nodes alongside `currentNode & nextNode`.


- Core algorithm:
  ````
    public ListNode reverseList(ListNode head) {

        //  currentNode tracks where we are
        ListNode currentNode = head;
        //  previousNode tracks the reversed part
        ListNode previousNode = null;

        while (currentNode != null) {

            // Step 1: store the next node (so we don't lose it after reversal)
            ListNode nextNode = currentNode.next;

            // Step 2: reverse the link by pointing current node to previous node
            currentNode.next = previousNode;

            // Step 3: move both pointers one step forward
            previousNode = currentNode;
            currentNode = nextNode;
        }

        // When the loop ends, previousNode will be the new head of the reversed list
        return previousNode;
    }

  ````

> Resources & Sequence I followed:

1. [Structy.net](https://structy.net/problem-index) (LinkedList I & LinkedList II)
2. Dry run on notebook for creating the best understanding & mental model.
3. [chanda-abdul-github-repository](https://github.com/Chanda-Abdul/Several-Coding-Patterns-for-Solving-Data-Structures-and-Algorithms-Problems-during-Interviews/blob/main/%E2%9C%85%20%20Pattern%2004%20:%20Merge%20Intervals.md)
4. [Reverse Linked List II](https://leetcode.com/problems/reverse-linked-list-ii/description/) (92-Medium | Solution Available✅)

