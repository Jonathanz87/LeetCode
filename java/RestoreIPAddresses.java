/*
	problem 93
	Given a string containing only digits,
	restore it by returning all possible valid IP address combinations.
	For example:
	Given "25525511135",
	return ["255.255.11.135", "255.255.111.35"].
	(Order does not matter)
*/
import java.util.List;
import java.util.ArrayList;

public class RestoreIPAddresses{
	public static void main(String[] args){
		String ip = "010010";
		restoreIpAddresses(ip).forEach(System.out::println);
	}

	public static List<String> restoreIpAddresses(String s) {
		List<String> ipList = new ArrayList<>();
		int minLength = 4, maxLength = 12;
		if(s.length() < minLength || s.length() > maxLength){
			return ipList;
		}

		restoreIpAddressesHelper(ipList, s, "", minLength, maxLength);
		return ipList;
	}

	public static void restoreIpAddressesHelper(List<String> ipList, String s, 
		String ip, int minLength, int maxLength){
		if(s.length() == 0 && minLength <= 0 && maxLength <= 0){
			ipList.add(ip.substring(0, ip.length() - 1));
		}

		minLength -= 1;
		maxLength -= 3;
		

		for(int len = 1, slen = s.length(); len <= 3 && slen >= len; len++){
			int num = Integer.parseInt(s.substring(0, len));

			if(slen - len >= minLength 
				&& slen - len <= maxLength 
				&& num <= 255 
				&& !(len > 1 && s.charAt(0) == '0')){
				restoreIpAddressesHelper(ipList, s.substring(len), 
					ip + num + ".", minLength, maxLength);
			}
		}
	}
}