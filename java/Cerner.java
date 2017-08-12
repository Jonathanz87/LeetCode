//Cerner interview

import java.util.Arrays;
public class Cerner{
	public static void main(String[] args){

	}
	//Given integers n, p1, and p2,
    //determine if the bits of n in position p1 and p2 are the same.
    //Positions p1, p2 are 1 based with 1 being the least significant bit.
    public static boolean isSameBits(int n, int p1, int p2) {
        return (n >> (p1 - 1) & 1) == (n >> (p2 - 1) & 1);
    }

    //You have (x, y) coordinates for 2 points and need to find the distance between them.
    public static double getDistance(String coordinates) {
        String[] s = coordinates.substring(1, coordinates.length() - 2)
                .replaceAll(" ", "")
                .split("\\)\\(");

        String[] c1 = s[0].split(",");
        String[] c2 = s[1].split(",");

        int x1 = Integer.parseInt(c1[0]);
        int y1 = Integer.parseInt(c1[1]);
        int x2 = Integer.parseInt(c2[0]);
        int y2 = Integer.parseInt(c2[1]);

        return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }
    //You are given an array of integers. Count the numbers of ways in which the sum of 4 elements in this array results in zero.
    public static int fourSum(int[] num, int target) {
        Arrays.sort(num);

        int ct = 0;
        for (int i = 0; i < num.length - 3; i++) {
            if (i != 0 && num[i] == num[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < num.length - 2; j++) {
                if (j != i + 1 && num[j] == num[j - 1])
                    continue;

                int left = j + 1;
                int right = num.length - 1;
                while (left < right) {
                    int sum = num[i] + num[j] + num[left] + num[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        ct++;
                        left++;
                        right--;
                        while (left < right && num[left] == num[left - 1]) {
                            left++;
                        }
                        while (left < right && num[right] == num[right + 1]) {
                            right--;
                        }
                    }
                }
            }
        }

        return ct;
    }
}