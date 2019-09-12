/*
	204. Count Primes
	Count the number of prime numbers less than a non-negative number, n.
	Example:
		Input: 10
		Output: 4
		Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
*/

package main

import( "fmt"; "os"; "strconv")

func main() {
	n, err := strconv.Atoi(os.Args[1])
	if err == nil {
		fmt.Println(countPrimes(n))
	}
}

func countPrimes(n int) int {
	isNotPrime := make([]bool, n)
	count := 0

	for i := 2; i < n; i++ {
		if !isNotPrime[i] {
			count++

			for j := 2; i * j < n; j++ {
				isNotPrime[i * j] = true
			}
		}
	} 
	return count
}