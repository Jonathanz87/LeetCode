/*
	problem 70
	You are climbing a stair case.
	It takes n steps to reach to the top.
	Each time you can either climb 1 or 2 steps.
	In how many distinct ways can you climb to the top?
	Note: Given n will be a positive integer.
*/
import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs{
	public static void main(String[] args){
		long start = System.nanoTime();
		System.out.println(climbStairs(Integer.parseInt(args[0])) + "-" + (System.nanoTime() - start));
		start = System.nanoTime();
		System.out.println(climbStairs2(Integer.parseInt(args[0])) + "-" + (System.nanoTime() - start));
		start = System.nanoTime();
		System.out.println(climbStairs3(Integer.parseInt(args[0])) + "-" + (System.nanoTime() - start));
	}

	static private Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();

	public static int climbStairs(int n){
		if(n < 0){
			return 0;
		}
		if(n == 0)
			return 1;

		int a1, a2;
		if(countMap.containsKey(n - 2)){
			a1 = countMap.get(n - 2);
		}
		else{
			a1 = climbStairs(n - 2);
			countMap.put(n - 2, a1);
		}

		if(countMap.containsKey(n - 1)){
			a2 = countMap.get(n - 1);
		}
		else{
			a2 = climbStairs(n - 1);
			countMap.put(n - 1, a2);
		}

		return a1 + a2;
	}

	public static int climbStairs2(int n){
		if(n == 1) return 1;
		if(n == 2) return 2;
		int[] countMap = new int[n];

		countMap[0] = 1;
		countMap[1] = 2;
		for(int i = 2; i < n; i++)
			countMap[i] = countMap[i - 1] + countMap[i - 2];
		return countMap[n - 1];
	}

	public static int climbStairs3(int n){
		if(n == 1) return 1;
		if(n == 2) return 2;

		int first = 1;
		int second = 2;
		int result = 0;

		for(int i = 3; i <= n; i++){
			result = first + second;
			first = second;
			second = result;
		}
		return result;
	}

}