/*
	problem 515
	You need to find the largest value in each row of a binary tree.
	Example:
	Input: 
	      1
	     / \
	    3   2
	   / \   \  
	  5   3   9 
	Output: [1, 3, 9]
*/
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class FindLargestValueInEachTreeRow{
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(2);
		root.right.right = new TreeNode(9);

		System.out.println(largestValues(root));
	}

	public static List<Integer> largestValues(TreeNode root) {
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		List<Integer> resultList = new LinkedList<>();
		int max = Integer.MIN_VALUE;

		if(root == null){
			return resultList;
		}

		nodeQueue.add(root);
		nodeQueue.add(null);
		while(true){
			TreeNode node = nodeQueue.poll();
			if(node == null){
				resultList.add(max);
				max = Integer.MIN_VALUE;		
				if(nodeQueue.size() == 0)
					break;
				nodeQueue.add(null);
			}else{
				max = Math.max(max, node.val);
				if(node.left != null){
					nodeQueue.add(node.left);
				}
				if(node.right != null){
					nodeQueue.add(node.right);
				}
			}
		}
		return resultList;
	}

	public static List<Integer> largestValues2(TreeNode root){
		List<Integer> resultList = new LinkedList<>();
		largestValues(resultList, root, 0);
		return resultList;
	}
	public static void largestValues(List<Integer> resultList, TreeNode root, int depth){
		if(root == null) return;
		if(depth >= resultList.size()){
			resultList.add(root.val);
		}else{
			resultList.set(depth, Math.max(resultList.get(depth), root.val)); 
		}
		largestValues(resultList, root.left, depth + 1);
		largestValues(resultList, root.right, depth + 1);
	}

	//Definition for a binary tree node.
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}