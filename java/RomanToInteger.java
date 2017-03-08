/*
	problem 13
	Given a roman numeral, convert it to an integer.
	Input is guaranteed to be within the range from 1 to 3999.
*/
import java.util.Map;
import java.util.HashMap;

public class RomanToInteger{
	static public void main(String[] args){
		System.out.println(romanToInt(args[0]));
	}

	static private Map<Character, Integer> map = new HashMap<Character, Integer>(){{
		put('I', 1);
		put('V', 5);
		put('X', 10);
		put('L', 50);
		put('C', 100);
		put('D', 500);
		put('M', 1000);
	}};

	static public int romanToInt(String s) {
		int len = s.length();
		int result = map.get(s.charAt(len - 1));

		for(int i = len - 2; i >= 0; i--){
			if(map.get(s.charAt(i + 1))  >  map.get(s.charAt(i))){
				result -= map.get(s.charAt(i));
			}else{
				result += map.get(s.charAt(i));
			}
		}

		return result;
	}
}