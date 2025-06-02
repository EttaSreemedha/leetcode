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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        findSol(root,res,targetSum,new ArrayList<>(),0);
        return res;
    }
    public void findSol(TreeNode root,List<List<Integer>> res,int targetSum,List<Integer> curr,int sum){
        if(root==null) return;
        curr.add(root.val);
        sum=sum+root.val;
        if(root.left==null && root.right==null && sum==targetSum){
            res.add(new ArrayList<>(curr));
        }
        else{
            findSol(root.left,res,targetSum,curr,sum);
             findSol(root.right,res,targetSum,curr,sum);
        }
        curr.remove(curr.size()-1);
    }
}