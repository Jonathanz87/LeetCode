/*
    845. Longest Mountain in Array
    Let's call any (contiguous) subarray B (of A) a mountain if the following properties hold:
    B.length >= 3
    There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
    (Note that B could be any subarray of A, including the entire array A.)
    Given an array A of integers, return the length of the longest mountain. 
    Return 0 if there is no mountain.
    Example 1:
        Input: [2,1,4,7,3,2,5]
        Output: 5
        Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
    Example 2:
        Input: [2,2,2]
        Output: 0
        Explanation: There is no mountain.
        Note:
        0 <= A.length <= 10000
        0 <= A[i] <= 10000
    Follow up:
        Can you solve it using only one pass?
        Can you solve it in O(1) space?
*/
public class LongestMountainInArray{
    private static final int FLAT = 0, UP = 1, DOWN = 2;
    public int longestMountain(int[] A) {
        if(A == null || A.length < 3){
            return 0;
        }
        int max = 0;
        int upCount = 0;
        int downCount = 0;
        int prevStatus = FLAT;
        
        for(int i = 1; i < A.length; i++){
            if(A[i - 1] < A[i]){ //up
                if(prevStatus == UP){
                    upCount += 1;
                }else{
                    if(prevStatus == DOWN && upCount > 0 && downCount > 0){
                        max = Math.max(max, upCount + downCount);
                    }
                    upCount = 2;
                }

                prevStatus = UP;
                downCount = 0;
            }else if(A[i - 1] > A[i]){//down
                downCount++;
                prevStatus = DOWN;
            } else{
                if(upCount > 0 && downCount > 0){
                    max = Math.max(max, upCount + downCount);
                }
                upCount = 0;
                downCount = 0;
                prevStatus = FLAT;
            }

        }
        if(upCount > 0 && downCount > 0){
            max = Math.max(max, upCount + downCount);
        }
        return max;
    }
}
