/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        
        if(root==null)return 0;
        int l = 0,r = 0 ;
        
      if(root.left!=null){
          l = maxDepth(root.left);
      }
       if(root.right!=null){
          r =  maxDepth(root.right);
      }
     return (1+Math.max(r,l));
    }
}