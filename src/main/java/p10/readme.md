Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *


先考虑简单情况,没有 *

.*,表示1或更多个任意字符,真太搞了  -_-

在我的Solution1的基础要能够处理".*",要单独写一堆代码

I GIVE UP

看答案去了

递归的代码好理解

dp都快忘光了,看了一眼算法导论 DP的部分
这个问题下面:
dp(i, j) 涵义是 match(text[i:], pattern[j:])

回顾一下问题拆解的方式:
1. 无星号, firstMatch and dp(i+1,j+1)
2. 有星号,再分为两种
(1).`b*`代表0个b, dp(i,j+1)
(2).`b*`代表>=1个b, 这种只要递归(虚幻)的去掉一个b就行了,firstMatch and dp(i+1,j)

写top-bottom的dp的时候,bad case:isMatch("","b*"),
firstMatch会报错
```
boolean firstMatch = (p.charAt(0) == s.charAt(0) || p.charAt(0) =='.');
#改成
boolean firstMatch = !s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) =='.');
```
