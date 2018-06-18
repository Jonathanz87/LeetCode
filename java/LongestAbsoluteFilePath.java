/*
	problem 388
	Suppose we abstract our file system by a string in the following manner:
	The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:
		dir
		    subdir1
		    subdir2
		        file.ext
	The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.
	The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:
		dir
		    subdir1
		        file1.ext
		        subsubdir1
		    subdir2
		        subsubdir2
		            file2.ext
	The directory dir contains two sub-directories subdir1 and subdir2.
	subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1.
	subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.
	We are interested in finding the longest (number of characters) absolute path to a file within our file system.
	For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext",
	and its length is 32 (not including the double quotes).
	Given a string representing the file system in the above format,
	return the length of the longest absolute path to file in the abstracted file system.
	If there is no file in the system, return 0.
	Note:
		The name of a file contains at least a . and an extension.
		The name of a directory or sub-directory will not contain a ..
		Time complexity required: O(n) where n is the size of the input string.
		Notice that a/aa/aaa/file1.txt is not the longest file path,
		if there is another path aaaaaaaaaaaaaaaaaaaaa/sth.png.
*/
import java.util.LinkedList;

public class LongestAbsoluteFilePath {
	public static void main(String[] args) {
		System.out.println(lengthLongestPath(args[0]));
	}
	public static int lengthLongestPath(String input) {
		LinkedList<Integer> dirLengthStack = new LinkedList<>();
		dirLengthStack.add(0);

		int lastFileLevel = -1;
		int currentFileLevel = 0;
		int currentLength = 0;
		int maxLength = 0;

		boolean isFile = false;


		for (char c : input.toCharArray()) {
			System.out.println(c);
			if (c == '\n') {
				if (isFile) {
					maxLength = Math.max(maxLength, (currentFileLevel + currentLength + dirLengthStack.getLast()));
				} else {
					if (currentFileLevel > lastFileLevel) {
						currentLength = currentLength + dirLengthStack.getLast();
						dirLengthStack.add(currentLength);
						lastFileLevel = currentFileLevel;
					} else if (currentFileLevel < lastFileLevel) {
						while (dirLengthStack.size() > currentFileLevel + 1) {
							dirLengthStack.removeLast();
						}
						lastFileLevel = currentFileLevel;
					} else {
						dirLengthStack.removeLast();
						currentLength = currentLength + dirLengthStack.getLast();
						dirLengthStack.add(currentLength);
					}
				}

				isFile = false;
				currentLength = 0;
				currentFileLevel = 0;

			} else if (c == '\t') {
				currentFileLevel++;
			} else {
				if (c == '.') {isFile = true;}
				currentLength++;
			}
		}
		if (isFile) {
			System.out.println(currentFileLevel + " - " + currentLength + " - " + dirLengthStack.getLast());
			maxLength = Math.max(maxLength, (currentFileLevel + currentLength + dirLengthStack.getLast()));
		}

		return maxLength;
	}

	public static int lengthLongestPath(String input) {
		int maxLength = 0;
		String[] files = input.split("\n");
		int[] pathLengthStack = new int[files.length + 1];
		pathLengthStack[0] = 0;

		for (String file : files) {
			int level = file.lastIndexOf('\t') + 2;
			if (file.contains(".")) {
				maxLength = Math.max(pathLengthStack[level - 1] + file.length(), maxLength);
			} else {
				pathLengthStack[level] = pathLengthStack[level - 1] + (file.length() - level + 1);
			}
		}

		return maxLength;
	}
}