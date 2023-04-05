package main

import "fmt"

/**
	520. Detect Capital
	We define the usage of capitals in a word to be right when one of the following cases holds:

	All letters in this word are capitals, like "USA".
	All letters in this word are not capitals, like "leetcode".
	Only the first letter in this word is capital, like "Google".
	Given a string word, return true if the usage of capitals in it is right.

	Example 1:
		Input: word = "USA"
		Output: true

	Example 2:
		Input: word = "FlaG"
		Output: false

	Constraints:
		1 <= word.length <= 100
		word consists of lowercase and uppercase English letters.
**/

func detectCapitalUse(word string) bool {
	if len(word) == 1 {
		return true
	}
	isFirstCapital := isCapital(word[0])
	isSecondCapital := isCapital(word[1])

	for i, l := 2, len(word); i < l; i++ {
		if isSecondCapital != isCapital(word[i]) {
			return false
		}
	}

	return isFirstCapital || (!isFirstCapital && !isSecondCapital)
}

func isCapital(c byte) bool {
	return c >= 'A' && c <= 'Z'
}

func main() {
	fmt.Println(detectCapitalUse("O"))
}
