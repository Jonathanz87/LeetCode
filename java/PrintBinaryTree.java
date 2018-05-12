/*
  problem 655
	Print a binary tree in an m*n 2D string array following these rules:
	The row number m should be equal to the height of the given binary tree.
	The column number n should always be an odd number.
	The root node's value (in string format) should be put in the exactly middle of the first row it can be put. 
	The column and the row where the root node belongs will separate the rest space into two parts (left-bottom part and right-bottom part). 
	You should print the left subtree in the left-bottom part and print the right subtree in the right-bottom part. 
	The left-bottom part and the right-bottom part should have the same size. Even if one subtree is none while the other is not, 
	you don't need to print anything for the none subtree but still need to leave the space as large as that for the other subtree. 
	However, if two subtrees are none, then you don't need to leave space for both of them.
	Each unused space should contain an empty string "".
	Print the subtrees following the same rules.
	Example 1:
		Input:
			  1
			 /
			2
		Output:
		[
			["", "1", ""],
			["2", "", ""]
		]
	Example 2:
		Input:
			  1
			 / \
			2   3
			 \
			  4
		Output:
		[
			["", "", "", "1", "", "", ""],
			["", "2", "", "", "", "3", ""],
			["", "", "4", "", "", "", ""]
		]
	Example 3:
		Input:
			      1
			     / \
			    2   5
			   / 
			  3 
			 / 
			4 
		Output:
		[
			["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
			["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
			["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
			["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
		]
	Note: The height of binary tree is in the range of [1, 10].
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class PrintBinaryTree {
	// Definition for a binary tree node.
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static List<List<String>> printTree(TreeNode root) {
		int height = getHeight(root);
		int size = (1 << height) - 1;
		String[][] result = new String[height][size];
		List<List<String>> list = new ArrayList<>(height / 3 * 4 + 1);

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < size; j++) {
				result[i][j] = "";
			}
		}

		dsf(result, root, 0, 0, size - 1);

		for (String[] s : result) {
			list.add(Arrays.asList(s));
		}

		return list;

	}

	private static void dsf(String[][] result, TreeNode node, int h, int l, int r) {
		if (node == null) return;
		int index =l + ((r - l + 1) >> 1);
		result[h][index] = Integer.toString(node.val);
		dsf(result, node.left, h + 1, l, index - 1);
		dsf(result, node.right, h + 1, index + 1, r);
	}

	private static int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
}
