/*
	problem 14
	Write a function to find the longest common prefix string amongst an array of strings.
*/

public class LongestCommonPrefix{
	static public void main(String[] args){
		System.out.println(longestCommonPrefix(args));
	}

	static public String longestCommonPrefix(String[] strs) {
		if(strs.length < 1){
			return "";
		}

		String prefix = strs[0];
		int prefixLen = prefix.length();

		for(int i = 1, len = strs.length; i < len; i++){
			int minLen = Math.min(prefixLen, strs[i].length());
			int pIndex = 0;
			while(pIndex < minLen){
				if(prefix.charAt(pIndex) != strs[i].charAt(pIndex)){
					break;
				}
				pIndex++;
			}
			prefixLen = pIndex;
		}

		return prefix.substring(0, prefixLen);
	}
}