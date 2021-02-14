/**LC-314
 * 
 * Time Complexity : O(NlogN) (Extra logN because of TreeMap)(Can use hashmap & two pointer method and make it N)
 * Space Complexity : O(H)
 * Did this code successfully run on Leetcode : No
 * Any problem you faced while coding this : No
 * 
 * Algorithm:
    The main problem with a simple dfs is that we wont wont be able to keep the correct order
    for each column. Take a look in the below example...the node be at level 2 is printed before the node at level 1. 
    We can surely get a sol with DFS but with modifications. 
 */
//Test case failing: [3,9,8,4,0,1,7,null,null,null,2,5]
//output: [[4],[9,5],[3,0,1],[2,8],[7]]
//expected output: [[4],[9,5],[3,0,1],[8,2],[7]]
class Solution {
    TreeMap<Integer, List<Integer>> map;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        map = new TreeMap<>();
        
        preorder(root, 0);
        //System.out.print(map.toString());
        return new ArrayList<>(map.values());
    }
    
    private void preorder(TreeNode root, int horizontalDist){
        
        //base
        if(root == null) return;
        
        //logic
        if(!map.containsKey(horizontalDist)){
            map.put(horizontalDist, new ArrayList<>(List.of(root.val)));
        }
        else
            map.get(horizontalDist).add(root.val);
        
        preorder(root.left, horizontalDist - 1);
        preorder(root.right, horizontalDist + 1);
    }
}