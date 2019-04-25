# 32. Longest Valid Parentheses
Hard

1723

83

Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

**Example 1:**

```
Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
```

**Example 2:**


```
Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()
```



思路:

暴力求解,two for loop, 用辅助函数`isValid`  $O(n^3)$

双指针

dp



solution1
```
仿照 最大回文的思路

每增加一个字符,最长的合法括号串长度要么不变,要么增加2
```
这个结论是错的

```
"()(()"  -> "()(())" 2 变成 6
```

尝试DP;
状态转移方程:
dp\[lo][hi]  

如果charArr[lo]=='(' 且charArr[hi]==')' 则

dp\[lo][hi]  = dp\[lo+1][hi-1]  



