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

class Pair{
    int sum;
    int count;
        Pair(int sum,int count){
            this.sum = sum;
            this.count=count;
        }
}

int ans = 0;


public Pair helper(TreeNode root){
if(root==null){
    return new Pair(0,0);
}
Pair left =helper( root.left);
Pair right =helper( root.right);

if((left.sum+right.sum+root.val)/(left.count+right.count+1)==root.val){
    ans++;
}


return new Pair(left.sum+right.sum+root.val,left.count+right.count+1);
}



    public int averageOfSubtree(TreeNode root) {
        
helper(root);
return ans;



    }
}