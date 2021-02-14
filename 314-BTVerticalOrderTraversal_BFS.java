/**
 * Question: Given the root of a binary tree, return the vertical order traversal of its nodes' values. 
 * (i.e., from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.
 * 
 */

 /**LC-314
 * 
 * Time Complexity : O(N) 
 * Space Complexity : O(H)
 * Did this code successfully run on Leetcode : No
 * Any problem you faced while coding this : No
 * 
 * Algorithm:
 * 
   We can eliminate the use of a TreeMap because it takes an extra logN to sort the keys of the Hashmap, making a total NlogN(BFS + treemap insertion)
    We can do this by using two pointers min and max to keep the track of the range, and then just use a hashmap 
    and iterate between min and max. This make O(N) time/
    Here in the question we are using two queues but we can do that by one too using a Pair class.
 */
class Solution {
    HashMap<Integer, List<Integer>> map;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>(); 
        q.add(root);
        cols.add(0);
        int min = 0, max = 0;
        while(!q.isEmpty()){
            
            TreeNode curr = q.poll();
            int col = cols.poll();
            if(!map.containsKey(col)){
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(curr.val);
            if(curr.left != null){
                
                q.add(curr.left);
                cols.add(col - 1);
                min = Math.min(min, col - 1);
            }
            if(curr.right != null){
                q.add(curr.right);
                cols.add(col + 1);
                max = Math.max(max, col + 1);
            }
            
        }
       // System.out.println(map.toString());
            
        for(int i = min; i <= max; i++){
            
            result.add(map.get(i));
        }
        
        return result;
    }
 }