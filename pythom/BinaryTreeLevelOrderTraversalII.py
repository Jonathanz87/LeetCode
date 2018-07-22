# problem 107
# Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
# (ie, from left to right, level by level from leaf to root).
# 
# For example:
# Given binary tree [3,9,20,null,null,15,7],
#     3
#    / \
#   9  20
#     /  \
#    15   7
# return its bottom-up level order traversal as:
# [
#   [15,7],
#   [9,20],
#   [3]
# ]

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def levelOrderBottom(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        return self.help(root, [], 0)[::-1]
       


    def help(self, root, list, level):
        if root is None:
            return list

        if len(list) <= level:
            list.append([root.val])
        else:
            list[level].append(root.val)

        self.help(root.left, list, level + 1)
        self.help(root.right, list, level + 1)

        return list
