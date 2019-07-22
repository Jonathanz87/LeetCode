import java.util.Arrays;
import java.util.Objects;

public class UberInterview {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquare(new int[] { -5, -3, -1, 0, 1, 2, 3, 4, 5 })));
    }

    public static int[] sortedSquare(int[] sortedArray) {
        Objects.requireNonNull(sortedArray, "Input array cannot be null");
        int[] result = new int[sortedArray.length];

        int left = 0;
        int right = 0;
        int i = 0;

        while (right < sortedArray.length && sortedArray[right] < 0) {
            right++;
        }
        left = right - 1;

        while (left >= 0 && right < sortedArray.length) {
            if (-sortedArray[left] < sortedArray[right]) {
                result[i] = sortedArray[left] * sortedArray[left];
                left--;
            } else {
                result[i] = sortedArray[right] * sortedArray[right];
                right++;
            }
            i++;
        }

        while (left >= 0) {
            result[i++] = sortedArray[left] * sortedArray[left];
            left--;
        }

        while (right < sortedArray.length) {
            result[i++] = sortedArray[right] * sortedArray[right];
            right++;
        }

        return result;
    }
}