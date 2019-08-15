/*
	111. Minimum Depth of Binary Tree
	Given a binary tree, find its minimum depth.
	The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
	Note: A leaf is a node with no children.
	Example:
		Given binary tree [3,9,20,null,null,15,7],
		  3
		 / \
		9  20
		  /  \
		 15   7
		return its minimum depth = 2.
*/

package main

//Definition for a binary tree node.
type TreeNode struct {
    Val int
    Left *TreeNode
    Right *TreeNode
}

func minDepth(root *TreeNode) int {
    if root == nil {
		return 0
	}

	return minDepthHelper(root)
}

func minDepthHelper(root *TreeNode) int {
    if root.Left == nil && root.Right == nil {
		return 1
	}

	if root.Left == nil {
		return minDepthHelper(root.Right) + 1
	} else if root.Right == nil {
		return minDepthHelper(root.Left) + 1
	} else {
		return min(minDepth(root.Left), minDepth(root.Right)) + 1
	}
}

func min(a, b int) int {
	if a < b {
		return a
	}

	return b
}