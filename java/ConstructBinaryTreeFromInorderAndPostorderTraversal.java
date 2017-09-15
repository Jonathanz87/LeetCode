/*
	problem 106
	Given inorder and postorder traversal of a tree, 
	construct the binary tree.
	Note:
	You may assume that duplicates do not exist in the tree.
*/

public class ConstructBinaryTreeFromInorderAndPostorderTraversal{

	//Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(inorder.length <= 0){
			return null;
		}
		int index = -1;
		int inorderIndex = inorder.length - 1;
		TreeNode[] nodeStock = new TreeNode[inorder.length];

		TreeNode root = new TreeNode(postorder[postorder.length - 1]);
		nodeStock[++index] = root;
		TreeNode currentNode = root;

		for(int i = postorder.length - 2; i >= 0; i--){
			if(nodeStock[index].val != inorder[inorderIndex]){
				TreeNode node = new TreeNode(postorder[i]);
				currentNode.right = node;
				nodeStock[++index] = node;
				currentNode = node;
			}else{
				while(index > -1 && inorder[inorderIndex] == nodeStock[index].val){
					inorderIndex--;
					currentNode = nodeStock[index--];
				}
				TreeNode node = new TreeNode(postorder[i]);
				currentNode.left = node;
				nodeStock[++index] = node;
				currentNode = node;
			}
		}

		return root;
	}
}