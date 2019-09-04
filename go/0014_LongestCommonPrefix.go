/*
	14. Longest Common Prefix
	Write a function to find the longest common prefix string amongst an array of strings.
	If there is no common prefix, return an empty string "".
	Example 1:
		Input: ["flower","flow","flight"]
		Output: "fl"
	Example 2:
		Input: ["dog","racecar","car"]
		Output: ""
		Explanation: There is no common prefix among the input strings.
	Note:
	All given inputs are in lowercase letters a-z.
*/

package main

import( "math" )

func longestCommonPrefix(strs []string) string {
    if strs == nil || len(strs) <= 0 {
		return ""
	}

	if len(strs) == 1 {
		return strs[0]
	}

	l := math.MaxInt32

	for i, len := 1, len(strs); i < len; i++ {
		l = findCommonPrefixLength(strs[i - 1], strs[i], l)
	}

	return strs[0][0:l]
}

func findCommonPrefixLength(s1, s2 string, max int) int {
	len := min(min(len(s1), len(s2)), max)
	i := 0
	for ;i < len && s1[i] == s2[i]; i++{}
	return i
}

func min(n1, n2 int) int {
	if n1 < n2 {
		return n1
	}

	return n2
}