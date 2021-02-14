/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
 
    public int rangeSumBST(TreeNode root, int low, int high) {
        
        if(root == null) return 0;
        int sum = 0;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
        
            root = st.pop();
            if(root == null) continue;
            if(root.val >= low && root.val <= high)
                sum += root.val;
            if(root.val > low)
                st.push(root.left);
            if(root.val < high)
                st.push(root.right);
        }
       
        return sum;
    }
}