TC : O(N)
SC: O(h) where is h is max height of the tree in recursive stack


class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        return inorder(root);
    
    }
    private boolean inorder(TreeNode root){
    if(root==null) return true;
    // recursive case
    if(inorder(root.left)==false) return false;
    if(prev!=null && prev.val>=root.val) return false;
    prev=root;
    return inorder(root.right);
    }
}


//Iterative code
class Solution {
   
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode prev=null;
        while(root!=null || !s.isEmpty()){
            while(root!=null){
                s.push(root);
                root=root.left;
            }
            root=s.pop();
            if(prev != null && prev.val>=root.val) return false;
            prev=root;
            root=root.right;
        }
        return true;
    }
}