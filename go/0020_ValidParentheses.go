/*
	20. Valid Parentheses
	Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
	determine if the input string is valid.
	An input string is valid if:
	Open brackets must be closed by the same type of brackets.
	Open brackets must be closed in the correct order.
	Note that an empty string is also considered valid.
	Example 1:
		Input: "()"
		Output: true
	Example 2:
		Input: "()[]{}"
		Output: true
	Example 3:
		Input: "(]"
		Output: false
	Example 4:
		Input: "([)]"
		Output: false
	Example 5:
		Input: "{[]}"
		Output: true
*/

package main

import ( "fmt"; "os")

func main(){
	s := os.Args[1]
	fmt.Println(s," - ", isValid(s))


}

func isValid(s string) bool {
	chars := make([]rune, len(s))
	i := -1

	for _, c := range s {
		switch c {
		case ')':
			if i < 0 || chars[i] != '(' {
				return false
			}
			i--
		case ']':
			if i < 0 || chars[i] != '[' {
				return false
			}
			i--
		case '}':
			if i < 0 || chars[i] != '{' {
				return false
			}
			i--
		default:
			i++
			chars[i] = c
		}
	}
	return i == -1
}
