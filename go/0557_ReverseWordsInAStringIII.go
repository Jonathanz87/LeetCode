/*
	557. Reverse Words in a String III
	Given a string, you need to reverse the order of characters in each word within a sentence
	while still preserving whitespace and initial word order.
	Example 1:
		Input: "Let's take LeetCode contest"
		Output: "s'teL ekat edoCteeL tsetnoc"
		Note: In the string, each word is separated by single space and there will not be any extra space in the string.
*/

package main

import (
	"strings"
)

func reverseWords(s string) string {
	result := ""
	for _, w := range strings.Split(s, " ") {
		result = result + *reversWord(&w) + " "
	}

	if len(result) > 0 {
		return result[:len(result) - 2]
	}

	return result
}

func reversWord(s *string) *string {
	rs := []rune(*s)

	for l, r := 0, len(rs)-1; l < r; {
		rs[l] = rs[l] ^ rs[r]
		rs[r] = rs[l] ^ rs[r]
		rs[l] = rs[l] ^ rs[r]
		l++
		r--
	}

	str := string(rs)
	return &str
}
