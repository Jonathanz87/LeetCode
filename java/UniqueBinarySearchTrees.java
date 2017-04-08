/*
	Given n,
	how many structurally unique BST's (binary search trees) that store values 1...n?

	For example,
	Given n = 3,
	there are a total of 5 unique BST's.
		1         3     3      2      1
		 \       /     /      / \      \
		  3     2     1      1   3      2
		 /     /       \                 \
		2     1         2                 3
*/

public class UniqueBinarySearchTrees{
	public static void main(String[] args){
		System.out.println(numTrees(Integer.parseInt(args[0])));
	}

	public static int numTrees(int n){
		if(n < 2) return 1;

		int[] treeCounter = new int[n + 1];
		treeCounter[0] = 1;
		treeCounter[1] = 1;

		for(int i = 2; i <= n; i++){
			int result = 0;
			for(int j = 0, len = i / 2; j < len; j++){
				result += treeCounter[j] * treeCounter[i - j - 1];
			}
			result *= 2;

			if(i % 2 != 0){
				result += treeCounter[i / 2] * treeCounter[i / 2];
			}
			treeCounter[i] = result;
		}

		return treeCounter[n];
	}
}