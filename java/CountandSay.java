/*
	problem 38
	The count-and-say sequence is the sequence of integers beginning as follows:
		1, 11, 21, 1211, 111221, ...
	1 is read off as "one 1" or 11.
	11 is read off as "two 1s" or 21.
	21 is read off as "one 2, then one 1" or 1211.
	Given an integer n, generate the nth sequence.
*/
public class CountandSay{
	static public void main(String[] args){
		System.out.println(countAndSay(Integer.parseInt(args[0])));
	}

	static public String countAndSay(int n){
		if(n <= 1) return "1";
		String str = "1";
		int i = 2;
		while(i++ <= n){
			StringBuilder temp = new StringBuilder("");
			char value = str.charAt(0);
			int ct = 1;

			for(int j = 1, len = str.length(); j < len; j++){
				if(str.charAt(j) == value){
					ct++;
				}else{
					temp.append(ct);
					temp.append(value);
					value = str.charAt(j);
					ct = 1;
				}
			}
			temp.append(ct);
			temp.append(value);
			str = new String(temp);
		}

		return str;
	}
}