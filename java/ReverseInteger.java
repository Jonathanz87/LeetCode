public class ReverseInteger{

	static public void main(String[] args){
		System.out.print(reverse(Integer.parseInt(args[0])));
	}

	static public int reverse(int x) {
		int sign = 1;
		if(x < 0){
			sign = -1;
			x = x * sign;
		}

		double result = 0;

		while(x > 0){
			result = result * 10 + x % 10;
			x /= 10;
		}

		return result > Integer.MAX_VALUE ? 0 : (int)result * sign;
	}
}