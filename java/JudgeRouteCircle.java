/*
	problem 657
	Initially, there is a Robot at position (0, 0).
	Given a sequence of its moves, judge if this robot makes a circle,
	which means it moves back to the original place.
	The move sequence is represented by a string.
	And each move is represent by a character.
	The valid robot moves are R (Right), L (Left), U (Up) and D (down).
	The output should be true or false representing whether the robot makes a circle.
	Example 1:
		Input: "UD"
		Output: true
	Example 2:
		Input: "LL"
		Output: false
*/

public class JudgeRouteCircle {
	public static void main(String[] args) {
		System.out.println(judgeCircle2(args[0]));
	}
	public static boolean judgeCircle(String moves) {
		if(moves.length() % 2 == 1) return false;
		int x = 0, y = 0;
		for (char c : moves.toCharArray()) {
			switch (c) {
			case 'U': y++; break;
			case 'D': y--; break;
			case 'L': x--; break;
			case 'R': x++; break;
			}
		}

		return x == 0 && y == 0;
	}

	public static boolean judgeCircle2(String moves) {
		if(moves.length() % 2 == 1) return false;
		int[] ct = new int[128];

		for(char c : moves.toCharArray()){
			ct[c]++;
		}

		return ct['D'] == ct['U'] && ct['L'] == ct['R'];
	}
}