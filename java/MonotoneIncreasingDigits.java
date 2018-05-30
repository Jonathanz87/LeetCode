public class MonotoneIncreasingDigits {
	public int monotoneIncreasingDigits(int N) {
		char[] numbers = Integer.toString(N).toCharArray();
		int index = numbers.length;

		for (int i = numbers.length - 2; i >= 0; i--) {
			if (numbers[i] > numbers[i + 1]) {
				numbers[i]--;
				index = i;
			}
		}

		while(++index < numbers.length){
			numbers[index] = '9';
		}

		return Integer.parseInt(new String(numbers));
	}
}