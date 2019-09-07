/*
	205. Isomorphic Strings
	Given two strings s and t, determine if they are isomorphic.
	Two strings are isomorphic if the characters in s can be replaced to get t.
	All occurrences of a character must be replaced with another character while preserving the order of characters. 
	xNo two characters may map to the same character but a character may map to itself.
	Example 1:
		Input: s = "egg", t = "add"
		Output: true
	Example 2:
		Input: s = "foo", t = "bar"
		Output: false
	Example 3:
		Input: s = "paper", t = "title"
		Output: true
		Note:
		You may assume both s and t have the same length.	
*/

package main

func isIsomorphic(s string, t string) bool {
	var defaultRune rune
	mapped := make([]bool, 256)
	charMap := make([]rune, 256)

	for i, len := 0, len(s); i < len; i++ {
		sIndex := int(s[i])
		tIndex := int(t[i])
	
	
		if charMap[sIndex] == defaultRune{
			if mapped[tIndex] {
				return false
			}

            charMap[sIndex] = rune(t[i])
			mapped[tIndex] = true
		}else {
            if charMap[sIndex] != rune(t[i]) {
				return false
			}
		}
	}
	
	return true
}