/*
	problem 17
	Given a digit string, return all possible letter combinations that the number could represent.

	A mapping of digit to letters (just like on the telephone buttons) is given below.

	Input:Digit string "23"
	Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber{

	static public void main(String[] args){
		System.out.println(letterCombinations(args[0]));
	}

	static private String[][] map ={{},
									{},
									{"a","b","c"},
									{"d","e","f"},
									{"g","h","i"},
									{"j","k","l"},
									{"m","n","o"},
									{"p","q","r","s"},
									{"t","u","v"},
									{"w","x","y","z"}};

	static public List<String> letterCombinations(String digits){
		if(digits.length() <= 0){
			return new ArrayList<String>();
		}

		List<String> combinations = new ArrayList<String>();
		int index = digits.length() - 1;
		String[] result = map[digits.charAt(index) - '0'];

		while(--index >= 0){
			String[] temp = new String[result.length * map[digits.charAt(index) - '0'].length];
			int tempIndex = 0;
			for(int i = 0; i < map[digits.charAt(index) - '0'].length; i++){
				for(int j = 0; j < result.length; j++){
					temp[tempIndex++] = map[digits.charAt(index) - '0'][i] + result[j];
				}
			}
			result = temp;
		}

		for(String s : result){
			combinations.add(s);
		}
		return combinations;
	}

}