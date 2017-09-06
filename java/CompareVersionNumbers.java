/*
	problem 165
	Compare two version numbers version1 and version2.
	If version1 > version2 return 1, 
	if version1 < version2 return -1, 
	otherwise return 0.

	You may assume that the version strings are non-empty 
	and contain only digits and the . character.
	The . character does not represent a decimal point and is used to separate number sequences.
	For instance, 2.5 is not "two and a half" or "half way to version three", 
	it is the fifth second-level revision of the second first-level revision.
	Here is an example of version numbers ordering:
	0.1 < 1.1 < 1.2 < 13.37
*/

public class CompareVersionNumbers{
	public static void main(String[] args){

	}

	public static int compareVersion(String version1, String version2) {
        String[] version1Arr = version1.split("\\.");
        String[] version2Arr = version2.split("\\.");
        int version1Len = version1Arr.length;
        int version2Len = version2Arr.length;

		int len = Math.min(version1Len, version2Len);
        for(int i = 0; i < len; i++){
        	if(Integer.parseInt(version1Arr[i]) > Integer.parseInt(version2Arr[i])){
        		return 1;
        	} else if(Integer.parseInt(version1Arr[i]) < Integer.parseInt(version2Arr[i])){
        		return -1;
        	}
        }

        if(version1Len > version2Len){
        	while(len < version1Len){
        		if(Integer.parseInt(version1Arr[len++]) != 0)
        			return 1;
        	}
        } else if(version1Len < version2Len){
        	while (len < version2Len) {
        		if(Integer.parseInt(version2Arr[len++]) != 0)
        			return -1;
        	}
        }
        return 0;
    }
}