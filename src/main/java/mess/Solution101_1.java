package mess;

/**
 * Created by hanzhou on 2018/7/9.
 */
// 101. Symmetric Tree

public class Solution101_1 {


    public boolean isSymmetric(TreeNode root) {


        return isMirror(root,root);
    }

    public boolean isMirror(TreeNode root1,TreeNode root2) {
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null) return false;

        if(root1.val!=root2.val) return false;
        else return isMirror(root1.left,root2.right) && isMirror(root1.right,root2.left);
    }


    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.left.left = new TreeNode(3);

        p.right = new TreeNode(2);
        p.right.right = new TreeNode(3);

        Solution101_1 solution = new Solution101_1();

        System.out.println(solution.isSymmetric(p));
    }
}
