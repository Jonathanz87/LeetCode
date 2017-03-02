/*	The string "PAYPALISHIRING" is written in a zigzag pattern
	 on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

	P   A   H   N
	A P L S I I G
	Y   I   R
	And then read line by line: "PAHNAPLSIIGYIR"
	Write the code that will take a string and 
	make this conversion given a number of rows:

	string convert(string s, int numRows);
	convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/
import java.lang.Math;

public class ZigZagConversion{
	static public void main(String[] args){
		System.out.println(convert(args[0], Integer.parseInt(args[1])));
	}

	static String convert(String s, int numRows){
		if(numRows == 1 || s.length() <= numRows){
			return s;
		}
		char[] cstr = s.toCharArray();
		int length = cstr.length;
		char[] cZigzag = new char[length];
		int patternSize = numRows * 2 - 2;
		int nPatterns = (int)Math.ceil((double)length / patternSize);
		int zigzagIndex = 0;

		int strIndex = 0;
		while(strIndex < length){
			cZigzag[zigzagIndex++] = cstr[strIndex];
			strIndex += patternSize;
		}

		int r = 1;
		while(r < numRows - 1){
			strIndex = r;
			int strIndex2 = patternSize - strIndex;

			while(strIndex < length){
				cZigzag[zigzagIndex++] = cstr[strIndex];
				strIndex += patternSize;

				if(strIndex2 < length){
					cZigzag[zigzagIndex++] = cstr[strIndex2];	
					strIndex2 += patternSize;
				}
			}
			r++;
		}

		if(r == numRows - 1){
			strIndex = r;
			while(strIndex < length){
				cZigzag[zigzagIndex++] = cstr[strIndex];
				strIndex += patternSize;
			}

		}
		return new String(cZigzag);
	}
}a