/*
	problem 152
	Find the contiguous subarray within an array (containing at least one number)
	which has the largest product.
	For example,
		given the array [2,3,-2,4],
		the contiguous subarray [2,3] has the largest product = 6.
*/

/*
	solution
	2  3 -2  4
	| /| /| /
	6 -6 -8
	| /| /
	-12 -24		6*-6/3	and	-6*-8/-2
	| /
	-48			-12*-24/-6
*/

public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        if(nums.length == 1) return nums[0];
        int maxProduct = nums[0], len = nums.length - 1;
        int[][] productTable = new int[nums.length][];

        productTable[0] = nums;
        productTable[1] = new int[len];
        for (int j = 0; j < len; j++) {
            productTable[1][j] = productTable[0][j] * productTable[0][j + 1];
            maxProduct = Math.max(maxProduct, Math.max(productTable[0][j + 1], productTable[1][j]));
        }

        len--;

        for(int i = 2; i < nums.length; i++, len--) {
            productTable[i] = new int[len];
            for(int j = 0; j < len; j++) {

                productTable[i][j] = productTable[i - 2][j + 1] == 0
                                     ? 0
                                     : productTable[i - 1][j] * (productTable[i - 1][j + 1] / productTable[i - 2][j + 1]);

                if(productTable[i][j] > maxProduct) {
                    maxProduct = productTable[i][j];
                }
            }
        }
        return maxProduct;
    }

    if (A.length == 0) {
        return 0;
    }


/*
	solution n
	
	keep tracking current max and min values, 
	each time compare the production of min, max, and the number
	if meet 0 then all values will be reset to 0

	ex
	-2,-2	4,-2	8,-2	24,-2	0,0		4,0		12,0	max = 24
	-2		-2		2		3		0		4		3
*/
    public static int maxProduct2(int[] nums) {
		int currentMin = nums[0], currentMax = nums[0], max = nums[0];

		for(int i = 1; i < nums.length; i++){
			int tempMin = currentMin * nums[i];
			int tempMax = currentMax * nums[i];

			currentMax = Math.max(Math.max(tempMax, tempMin), nums[i]);
			currentMin = Math.min(Math.min(tempMin, tempMax), nums[i]);
			max = Math.max(currentMax, max);
		}

		return max;
    }

}