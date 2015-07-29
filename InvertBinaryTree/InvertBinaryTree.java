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
    public TreeNode invertTree(TreeNode root) {
       if(root==null)return null;
       swap(root);
       if(root.left!=null){
        invertTree(root.left);
       }
      
       if(root.right!=null)
        invertTree(root.right);
      return root;
    }
    public void swap(TreeNode root){
       
        TreeNode newNode = new TreeNode(0);//临时变量
        newNode=root.left;
        root.left = root.right;
        root.right=newNode;
    }
}