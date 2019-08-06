/*
	7. Reverse Integer
	Given a 32-bit signed integer, reverse digits of an integer.
	Example 1:
		Input: 123
		Output: 321
	Example 2:
		Input: -123
		Output: -321
	Example 3:
		Input: 120
		Output: 21
	Note:
		Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. 
		For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
*/


package main

import ("strconv";"fmt";"os")

func main() {
	n, err := strconv.Atoi(os.Args[1])
	if err == nil {
	   fmt.Println(n," - ", reverse(n))
	}
}

func reverse(x int) int {
	const max = 2147483647
	const min = -2147483648
	sign := 1
	result := 0
	if x < 0 {
		x = -x
		sign = -1
	}

	for x > 0 {
		result = result * 10 + x % 10
		x /= 10
	}

	result *= sign

	if result > max || result < min{
		return 0
	}

	return result
}