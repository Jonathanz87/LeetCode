/*
	69. Sqrt(x)
	Implement int sqrt(int x).
	Compute and return the square root of x,
	where x is guaranteed to be a non-negative integer.
	Since the return type is an integer, 
	the decimal digits are truncated and only the integer part of the result is returned.
	Example 1:
		Input: 4
		Output: 2
	Example 2:
		Input: 8
		Output: 2
		Explanation: The square root of 8 is 2.82842..., and since 
				the decimal part is truncated, 2 is returned.
*/
package main

import( "fmt"; "strconv"; "os")

func main() {
	n, err := strconv.Atoi(os.Args[1])
	if err == nil {
		fmt.Println(mySqrt(n))
	}
}

func mySqrt(x int) int {
	if x == 0 {
		return 0
	}
	l, r := 1, x / 2
	for l < r {
		m := (l + r + 1) >> 1
		if m * m > x {
			r = m - 1
		}else {
			l = m
		}
	}

	return l
}