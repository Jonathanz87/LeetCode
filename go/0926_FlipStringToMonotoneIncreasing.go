package main

import "fmt"

/*
	A binary string is monotone increasing if it consists of some number of 0's (possibly none),
	followed by some number of 1's (also possibly none).

	You are given a binary string s. You can flip s[i] changing it from 0 to 1 or from 1 to 0.

	Return the minimum number of flips to make s monotone increasing.

	Example 1:
	Input: s = "00110"
	Output: 1
	Explanation: We flip the last digit to get 00111.
	Example 2:

	Input: s = "010110"
	Output: 2
	Explanation: We flip to get 011111, or alternatively 000111.
	Example 3:

	Input: s = "00011000"
	Output: 2
	Explanation: We flip to get 00000000.

	Constraints:

	1 <= s.length <= 105
	s[i] is either '0' or '1'.
*/

func minFlipsMonoIncr(s string) int {
	flipCount := make([]int, len(s))

	if s[0] == '1' {
		flipCount[0] = 1
	}

	for i, l := 1, len(s); i < l; i++ {
		if s[i] == '1' {
			flipCount[i] = flipCount[i-1] + 1
		} else {
			flipCount[i] = flipCount[i-1]
		}
	}

	var last int
	if s[len(s)-1] == '0' {
		last = 1
	} else {
		last = 0
	}
	min := flipCount[len(s)-1] + last

	if min == 0 {
		return 0
	}

	for i := len(s) - 2; i >= 0; i-- {
		if s[i] == '0' {
			last += 1
		}

		if flipCount[i]+last < min {
			min = flipCount[i] + last
		}
	}

	if min == 0 {
		return 0
	}

	return min - 1
}

func main() {
	fmt.Println(minFlipsMonoIncr("111111111111"))
}
