/*
	problem 91
	A message containing letters from A-Z is being encoded to numbers using the following mapping:
	'A' -> 1
	'B' -> 2
	...
	'Z' -> 26
	Given an encoded message containing digits, determine the total number of ways to decode it.
	For example,
	Given encoded message "12", 
	it could be decoded as "AB" (1 2) or "L" (12).
	The number of ways decoding "12" is 2.
*/

public class DecodeWays{
	public static void main(String[] args){
		System.out.println(numDecodings(args[0]));
	}

	public static int numDecodings(String s) {
		int len = s.length();
		int[] ways = new int[len + 1];
		if(len == 0 || s.charAt(0) == '0'){
			return 0;
		}

		ways[len] = 1;
		ways[--len] = s.charAt(len) == '0' ? 0 : 1;

		while(--len >= 0){
			if(s.charAt(len) != '0'){
				ways[len] = ways[len + 1];
				int num = (s.charAt(len) - '0') * 10 + (s.charAt(len + 1) - '0');
				if(num <= 26){
					ways[len] += ways[len + 2];
				}
			}
		}
		return ways[0];
	}

	public static int numDecodings2(String s) {
		int len = s.length();
		if(len <= 0){
			return 0;
		}
		return dfs(s, 0, len);
	}

	public static int dfs(String s, int index, int len){
		if(index >= len){
			return 1;
		}

		int ways = 0;
		if(s.charAt(index) != '0'){
			ways += dfs(s, index + 1, len);
			if(index + 1 < len){
				int num = Integer.parseInt(s.substring(index, index + 2));
				if(num <= 26){
					ways += dfs(s, index + 2, len);
				}
			}
		}

		return ways;
	}
}