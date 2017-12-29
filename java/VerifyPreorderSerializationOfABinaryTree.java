/*
	problem 331
	One way to serialize a binary tree is to use pre-order traversal.
	When we encounter a non-null node, we record the node's value.
	If it is a null node, we record using a sentinel value such as #.
		    _9_
		   /   \
		  3     2
		 / \   / \
		4   1  #  6
		/ \ / \   / \
		# # # #   # #
	For example,
	the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#",
	where # represents a null node.
	Given a string of comma separated values,
	verify whether it is a correct preorder traversal serialization of a binary tree.
	Find an algorithm without reconstructing the tree.
	Each comma separated value in the string must be either an integer
	or a character '#' representing null pointer.
	You may assume that the input format is always valid,
	for example it could never contain two consecutive commas such as "1,,3".
	Example 1:
		"9,3,4,#,#,1,#,#,2,#,6,#,#"
		Return true
	Example 2:
		"1,#"
		Return false
	Example 3:
		"9,#,#,1"
		Return false
*/

public class VerifyPreorderSerializationOfABinaryTree {
	public static void main(String[] args) {
		System.out.println(isValidSerialization(args[0]));
	}

	public static boolean isValidSerialization(String preorder) {
		String[] nodeArray = preorder.split(",");
		final int NODE_SIZE = nodeArray.length;
		if (NODE_SIZE <= 0) return false;

		boolean[] stack = new boolean[NODE_SIZE];
		int statckIndex = -1;
		int i = 0;

		do {
			if (nodeArray[i].equals("#")) {
				boolean carry = true;

				while (carry && statckIndex >= 0) {
					if (!stack[statckIndex]) {
						stack[statckIndex] = true;
						carry = false;
					} else {
						--statckIndex;
					}
				}

			} else {
				stack[++statckIndex] = false;
			}
			i++;
		} while (i < NODE_SIZE && statckIndex >= 0);
		return i >= NODE_SIZE && statckIndex < 0;
	}

	public static boolean isValidSerialization2(String preorder) {
		int nodeCount = 1;

		for (String node : preorder.split(",")) {
			if (nodeCount <= 0) return false;
			if (node.equals("#")) {
				nodeCount--;
			} else {
				nodeCount++;
			}
		}

		return nodeCount == 0;
	}
}