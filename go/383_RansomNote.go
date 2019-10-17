/*
	383. Ransom Note
	Given an arbitrary ransom note string and another string containing letters from all the magazines, 
	write a function that will return true if the ransom note can be constructed from the magazines; 
	otherwise, it will return false.
	Each letter in the magazine string can only be used once in your ransom note.
	Note:
	You may assume that both strings contain only lowercase letters.
		canConstruct("a", "b") -> false
		canConstruct("aa", "ab") -> false
		canConstruct("aa", "aab") -> true
*/

package main

func canConstruct(ransomNote string, magazine string) bool {
	letterCounter := make([]byte, 26)

	for _, c := range magazine {
		letterCounter[c - byte('a')]++
	}

	for c := range ransomNote {
		i := c - byte('a')
		letterCounter[i]--
		if letterCounter[i] < 0{
			return false
		}
	}
	return true
}