/*
	problem 28
	Implement strStr().
	Returns the index of the first occurrence of needle in haystack,
	or -1 if needle is not part of haystack.
*/

public class ImplementStrStr{
	static public void main(String[] args){
		if(args[2].equals("1")){
			long startTime=System.nanoTime();
			System.out.println(strStr(args[0], args[1]));
			System.out.println("time: "+(System.nanoTime()-startTime)+"ns");
		}else if(args[2].equals("2")){
			long startTime=System.nanoTime();
			System.out.println(strStr2(args[0], args[1]));
			System.out.println("time: "+(System.nanoTime()-startTime)+"ns");
		}
	}

	static public int strStr(String haystack, String needle) {
		int needleLen = needle.length();
		if(needleLen <= 0) return 0;

		for(int i = 0, len = haystack.length() - needleLen + 1; i < len; i++){
			if(haystack.charAt(i) == needle.charAt(0)){
				boolean isEqual = true;
				for(int j = 1; j < needleLen; j++){
					if(haystack.charAt(i + j) != needle.charAt(j)){
						isEqual = false;
						break;
					}
				}
				if(isEqual){
					return i;
				}
			}
		}

		return -1;
	}

	static public int strStr2(String haystack, String needle) {
		int needleLen = needle.length();
		if(needleLen <= 0) return 0;

		for(int i = 0, len = haystack.length() - needleLen + 1; i < len; i++){
			if(haystack.charAt(i) != needle.charAt(0)){
				while(i < len && haystack.charAt(++i) != needle.charAt(0));
			}

			if(i < len){
				int j = i + 1;
				for(int k = 1; k < len && haystack.charAt(j) == needle.charAt(k); j++, k++);
				if(j == len) return i;
			}

		}

		return -1;
	}
}