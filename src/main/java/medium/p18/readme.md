# 4Sum

Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

**Note:**

The solution set must not contain duplicate quadruplets.

**Example**
```$xslt
Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
```

思路:
4sum 可以拆解成 2+ 2
把C(n,2)的和都写出来
然后再 做2sum即可.

想存成HashMap<Integer, ListNode<Pair<Integer,Integer>>>
太麻烦了,代码冗余的不行

give up


