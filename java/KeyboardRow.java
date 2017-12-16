/*
	problem 500
	Given a List of words,
	return the words that can be typed using letters of alphabet on
	only one row's of American keyboard like the image below.
		American keyboard
			qwertyuiop
			asdfghjkl
			zxcvbnm
	Example 1:
		Input: ["Hello", "Alaska", "Dad", "Peace"]
		Output: ["Alaska", "Dad"]
	Note:
	You may use one character in the keyboard more than once.
	You may assume the input string will only contain letters of alphabet.
*/

public class KeyboardRow {
    public static String[] findWords(String[] words) {
        char[] groupMap = new char[26];
        groupMap['q' - 'a'] = 1;
        groupMap['w' - 'a'] = 1;
        groupMap['e' - 'a'] = 1;
        groupMap['r' - 'a'] = 1;
        groupMap['t' - 'a'] = 1;
        groupMap['y' - 'a'] = 1;
        groupMap['u' - 'a'] = 1;
        groupMap['i' - 'a'] = 1;
        groupMap['o' - 'a'] = 1;
        groupMap['p' - 'a'] = 1;
        groupMap['a' - 'a'] = 2;
        groupMap['s' - 'a'] = 2;
        groupMap['d' - 'a'] = 2;
        groupMap['f' - 'a'] = 2;
        groupMap['g' - 'a'] = 2;
        groupMap['h' - 'a'] = 2;
        groupMap['j' - 'a'] = 2;
        groupMap['k' - 'a'] = 2;
        groupMap['l' - 'a'] = 2;
        groupMap['z' - 'a'] = 3;
        groupMap['x' - 'a'] = 3;
        groupMap['c' - 'a'] = 3;
        groupMap['v' - 'a'] = 3;
        groupMap['b' - 'a'] = 3;
        groupMap['n' - 'a'] = 3;
        groupMap['m' - 'a'] = 3;

        List<String> resultList = new LinkedList<>();

        for (String s : words) {
            int groupId = 0;
            if (!s.isEmpty()) {
                groupId = groupMap[toLower(s.charAt(0)) - 'a'];
                for (char c : s.toCharArray()) {
                    if (groupMap[toLower(c) - 'a'] != groupId) {
                        groupId = -1;
                        break;
                    }
                }
                if (groupId != -1) {
                    resultList.add(s);
                }
            }
        }
        return resultList.toArray(new String[resultList.size()]);
    }

    private static char toLower(char c) {
        if ('A' <= c && 'Z' >= c) {
            c = (char) (c + 'a' - 'A');
        }
        return c;
    }
}