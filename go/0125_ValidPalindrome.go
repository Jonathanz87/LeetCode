/*
	125. Valid Palindrome
	Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
	Note: For the purpose of this problem, we define empty string as valid palindrome.
	Example 1:
		Input: "A man, a plan, a canal: Panama"
		Output: true
	Example 2:
		Input: "race a car"
		Output: false
*/

package main

import( "fmt"; "os" )

func main(){
	fmt.Println(os.Args[1], " - ", isPalindrome(os.Args[1]))
}

func isPalindrome(s string) bool {
	runeArray := []rune(s)
	l, r := 0, len(runeArray) - 1

	for(l < r){
		for(l < r && !isAlphanumeric(runeArray[l])){
			l++
		}

		for(l < r && !isAlphanumeric(runeArray[r])){
			r--
		}

		if(l < r && toLowerCase(runeArray[l]) != toLowerCase(runeArray[r])){
			return false
		}

		l++
		r--
	}

	return true
}

func isAlphanumeric(r rune) bool {
	return (r >= 'a' && r <= 'z') || (r >= 'A' && r <= 'Z') || r >= '0' && r <= '9';
}

func toLowerCase(r rune) rune {
	if r >= 'A' && r <= 'Z' {
		return r + 'a' - 'A'
	}
	return r
}