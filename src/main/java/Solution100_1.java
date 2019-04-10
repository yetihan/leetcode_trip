/**
 * Created by hanzhou on 2018/7/2.
 */

//100. Same Tree



public  class Solution100_1 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //输入值是否为空;input is or is not null
        if(p==null || q==null){
            return p==null && q==null;
        }

        //1.值不等, not same value
        // 2.左孩子或右孩子 空或不空的 状态不同, left child or right child is not null value at the same time;
        if(p.val!=q.val || (p.left==null) != (q.left==null) || (p.right==null) != (q.right==null))
            return false;

        else {
            //two left children and right children are all null value
            if(p.left==null && p.right==null)
                return true;
            else
                // recursion
                return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        }

    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        TreeNode q = new TreeNode(1);
        p.right = new TreeNode(2);
        q.right = new TreeNode(2);
        Solution100_1 solution100 = new Solution100_1();


        System.out.println(solution100.isSameTree(p,q));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x){
        val = x;
    }

}
