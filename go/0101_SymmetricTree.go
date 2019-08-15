/*
	101. Symmetric Tree
	Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
		For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
		    1
		   / \
		  2   2
		 / \ / \
		3  4 4  3
 		But the following [1,2,2,null,3,null,3] is not:
		  1
		 / \
		2   2
		 \   \
		 3    3
*/

package main

// Definition for a binary tree node.
type TreeNode struct {
    Val int
    Left *TreeNode
    Right *TreeNode
}

func isSymmetric(root *TreeNode) bool {
	if root == nil {
		return true
	}
	return isSymmetricHelper(root.Left, root.Right)
}

func isSymmetricHelper(left, right *TreeNode) bool {
    if left != nil && right != nil && left.Val == right.Val {
		return  isSymmetricHelper(left.Left, right.Right) && isSymmetricHelper(left.Right, right.Left)
	} else if left == nil && right == nil {
		return true
	} else {
		return false
	}
}