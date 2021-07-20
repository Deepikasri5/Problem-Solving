/*Assume we have a tree, u should have a arrayList result to store the values inorder.
So we should create a stack overhood which consists of TreeNode.
push the root inside the stack initially.
we should process everything till the recursion stack becomes empty and root becomes null
when we go to left most value, the root will be null but we will have values inside the recursive stack so you process ** This is the outer while loop**
so put the values inside the stack all the left most//while(root=!=null)
then take the value from the stack //stack.pop( )
go to right root=root.right
return result;*/



class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr=root;
        while(curr!=null || !st.isEmpty()) {
            while(curr!=null){
                st.push(curr);
                curr=curr.left;
            }
            curr=st.pop();
            result.add(curr.val);
            curr=curr.right;
        }
        return result;
    }
}