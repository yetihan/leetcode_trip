import java.util.HashMap;

/**
 * Created by hanzhou on 2018/7/9.
 */
public class Solution105_1 {
    static private HashMap<Integer,Integer> inorder_hash = new HashMap<Integer,Integer>();;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorder_hash.put(inorder[i],i);
        }

        return buildTreeHelper(preorder,inorder,0,0,inorder.length-1);
    }

    // next 在前序遍历上移动,low 和 high在中序遍历上移动
    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int next,int low, int high){
        if(low > high) return null;

        TreeNode root = new TreeNode(preorder[next]);
        if(low == high) return root;//可以不要的

        int root_index = inorder_hash.get(preorder[next]);

        root.left = buildTreeHelper(preorder,inorder,next+1,low,root_index-1);
        root.right = buildTreeHelper(preorder,inorder, next+root_index-low+1,root_index+1,high);

        return root;
    }

    public static void main(String[] args) {

        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        Solution105_1 solution = new Solution105_1();
        System.out.println();
    }
}


