 /**LC-314
 * 
 * Time Complexity : O(logN) (NOT SURE)
 * Space Complexity : O(H)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : Yes
 *  
 * 
 * Algorithm:
 * We can simply do a tree traversal and check at each node if it lies between the range.
 * The optimization which we can do here is due to the BST nature of the tree. We know the the 
 * value of the root is the greater than all the elements of the left subtree and smaller than right subtree elements.
 * So we can check this condition that if low < root, then only go to the left subtree, same goes right subtree tree, check if root < high
 */
class Solution {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        
        if(root == null) return 0;
        inorder(root, low, high);
        return sum;
    }
    
    private void inorder(TreeNode root, int low, int high){
        
        if(root == null) return;
        
        
        if(root.val > low)
            inorder(root.left, low, high);
        
        if(root.val >= low && root.val <= high) 
            sum += root.val;
        
        if(root.val < high)
            inorder(root.right, low, high);
    }
}