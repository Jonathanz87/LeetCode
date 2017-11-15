/*
	problem 453
	Given a non-empty integer array of size n,
	find the minimum number of moves required to make all array elements equal,
	where a move is incrementing n - 1 elements by 1.
	Example:
		Input:
		[1,2,3]
		Output:
		3
	Explanation:
		Only three moves are needed (remember each move increments two elements):
		[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
*/

public class MinimumMovesToEqualArrayElements {
    public static void main(String[] args) {
        int[] nums = new int[args.length];

        for(int i = 0; i < args.length; i++) {
            nums[i] = Integer.parseInt(args[i]);
        }

        System.out.println(minMoves(nums));
    }

    public static int minMoves(int[] nums) {
        if(nums.length < 2) return 0;
        int smallest = nums[0], move = 0;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < smallest) {
                move += (smallest - nums[i]) * i;
                smallest = nums[i];
            } else {
                move += nums[i] - smallest;
            }
        }

        return move;
    }

    public int minMoves2(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int i : nums) {
            sum += i;
            if(i < min) min = i;
        }
        return sum - min * n;
    }
}