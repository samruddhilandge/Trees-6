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
      
        while(root != null || !st.isEmpty()){
            
            while(root != null){
                
                st.push(root);
                if(root.val > low)
                    root = root.left;
                else
                    break;
            }
            root = st.pop();
            if(root.val >= low && root.val <= high)
                sum += root.val;
            
            if(root.val < high)
                root= root.right;
            else
                break;
        }
       
        return sum;
    }
}