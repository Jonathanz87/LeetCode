/*
	problem 279
	Given a positive integer n,
	find the least number of perfect square numbers
	(for example, 1, 4, 9, 16, ...)
	which sum to n.
	For example,
		given n = 12,
		return 3 because 12 = 4 + 4 + 4;
	given n = 13,
		return 2 because 13 = 4 + 9.
*/

/*
	solution DP
*/

public class PerfectSquares {
    public int numSquares(int n) {
        int[] perfectSquares = new int[n + 1];
        perfectSquares[0] = 0;
        perfectSquares[1] = 1;

        for(int i = 2; i <= n; i++) {
            double square = Math.sqrt(i);
            if(Math.rint(square) == square) {
                perfectSquares[i] = 1;
            } else {
                int min = Integer.MAX_VALUE;
                for(int j = 1; j * j < i ; j++) {
                    min = Math.min(min, perfectSquares[i - j * j] + 1);
                }
                perfectSquares[i] = min;
            }
        }

        return perfectSquares[n];
    }

    private boolean isSquare(int n){
        int sq = (int)Math.sqrt(n);
        return sq*sq == n;
    }
    public int numSquares2(int n) {
        if(isSquare(n))
            return 1;
        // The result is 4 if and only if n can be written in the form of 4^k*(8*m + 7). Please refer to 
        // Legendre's three-square theorem.
        while(n % 4 == 0){
            n >>= 2;
        }
        if(n % 8 == 7)
            return 4;
        //check 2
        int sq = (int)Math.sqrt(n);
        for(int i = 1; i <= sq; i++){
            if(isSquare(n-i*i))
                return 2;
        }
        return 3;
    }
}