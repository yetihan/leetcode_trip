题目:
n\*n个方格组成的正方形,从左下角先向右然后耕牛式的蜿蜒向上,依次写上1至n\*n
方格;
如果你在方格x上,那你下一步只能移动到x+1, x+2, x+3, x+4, x+5, ... x+n,
若方格上存在梯子则需直接跳转到另一个方格.(不进行连续跳转)\
求解从1到n\*n的最少步数.若无法到达返回-1


Input: [\
[-1,-1,-1,-1,-1,-1],\
[-1,-1,-1,-1,-1,-1],\
[-1,-1,-1,-1,-1,-1],\
[-1,35,-1,-1,13,-1],\
[-1,-1,-1,-1,-1,-1],\
[-1,15,-1,-1,-1,-1]]\
Output: 4


思考:
可以看成一个树的遍历问题,广度优先

