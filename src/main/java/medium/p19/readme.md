
# 19. Remove Nth Node From End of List

Given a linked list, remove the n-th node from the end of list and return its head.

**Example:**
```$xslt
Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.

```

**Note:**

Given n will always be valid.


Follow up:

Could you do this in one pass?


---

one-pass没那么好想啊


学会使用dummy(哨兵)
双指针一个先走n,然后再 一起走,就可以实现one-pass了
