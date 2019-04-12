Java 1.5版本后就提供了一个具备了小根堆性质的数据结构也就是优先队列PriorityQueue

第一版代码(Solution) 流程上错了

1. 所有list的第一个拿出来组成一个最小堆,然后最小值出堆
2. 最小值对应的list的下一个数入堆(这一步错了)

第二版(Solution1):
为了能知道是属于哪个list的值出堆的,加入一个hashmap ,key 是堆里面的值, value 是一个链表记录 这个值对应那些list

第三版(Solution1):
堆里面的元素不单单是数值,而是ListNode,记录值的同时记录next

往堆里面加入,自定义的类别,需要自己实现compare接口吗?
测试证明需要
```
Exception in thread "main" java.lang.ClassCastException: util.ListNode cannot be cast to java.lang.Comparable
```

```
// 匿名类实现
PriorityQueue<ListNode> minHeap2 = new PriorityQueue<>(new Comparator<ListNode>(){
    @Override
    public int compare(ListNode o1, ListNode o2) {
        return o1.val - o2.val;
    }
});

// lambda实现
PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((ListNode o1, ListNode o2 )-> o1.val - o2.val);

```

第三版 比第二版效率差