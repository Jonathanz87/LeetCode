/*
	problem 88
	Given two sorted integer arrays nums1 and nums2,
	merge nums2 into nums1 as one sorted array.
	Note:
	You may assume that nums1 has enough space
	(size that is greater or equal to m + n) to hold additional elements from nums2.
	The number of elements initialized in nums1 and nums2 are m and n respectively.
*/

public class MergeSortedArray{
	public static void main(String[] args){

	}

	public static void merge(int[] nums1, int m, int[] nums2, int n){
		int index = m-- + n-- - 1;

		while(m >= 0 && n >= 0){
			nums1[index--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
		}

		while(n >= 0){
			nums1[index--] = nums2[n--];
		}
	}
}