/*
	problem 71
	Given an absolute path for a file (Unix-style), simplify it.
	For example,
		path = "/home/", => "/home"
		path = "/a/./b/../../c/", => "/c"
*/

public class SimplifyPath{
	public static void main(String[] args){
		System.out.println(simplifyPath(args[0]));
	}

	public static String simplifyPath(String path){
		String[] folders = path.split("/");
		System.out.println(folders.length);
		int index = 0;
		for(int i = 0, len = folders.length; i < len; i++){
			if(folders[i].equals(".") || folders[i].equals("")){
				continue;
			}else if(folders[i].equals("..")){
				if(index != 0)
					index--;
			}else{
				folders[index++] = folders[i];
			}
		}

		StringBuilder result = new StringBuilder("");

		for(int i = 0; i < index; i++){
			result.append("/" + folders[i]);
		}

		return result.length() > 0 ? new String(result) : "/";
	}
}