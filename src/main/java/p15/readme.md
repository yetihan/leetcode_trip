Given an array `nums` of *n* integers, are there elements *a*, *b*, *c* in `nums` such that *a* + *b* + *c* = 0? Find all unique triplets in the array which gives the sum of zero.



**Note:**

The solution set must not contain duplicate triplets.



**Example:**

```python
Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
```



先对数组排序,选定第一个数,然后用双指针法.

双指针法在利用某些限定条件后,可以少遍历很多情况.

```java
while (lo<hi){
    if(nums[lo]+nums[hi]==sum){
        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
        lo++;hi--;
        while (nums[lo]==nums[lo-1]&&lo<hi) lo++; 
        while (nums[hi]==nums[hi+1]&&lo<hi) hi--;
    }else if(nums[lo]+nums[hi]<sum) lo++;
    else hi--;
}
```

`lo` 和`hi`不需要都遍历一遍,上面是一个$O(n)$的操作







