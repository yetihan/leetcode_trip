Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). 
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, 
which together with x-axis forms a container, such that the container contains the most water.



![](https://ws2.sinaimg.cn/large/006tNc79gy1g235aw4mhej30m90anwf1.jpg)



数学表达:

最大化 $(j-i)*min(a_i,a_j)$



