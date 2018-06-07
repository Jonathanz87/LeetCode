/*
	problem 648
	In English, we have a concept called root,
	which can be followed by some other words to form another longer word - let's call this word successor.
	For example, the root an, followed by other, which can form another word another.
	Now, given a dictionary consisting of many roots and a sentence.
	You need to replace all the successor in the sentence with the root forming it.
	If a successor has many roots can form it, replace it with the root with the shortest length.
	You need to output the sentence after the replacement.
	Example 1:
		Input: dict = ["cat", "bat", "rat"]
		sentence = "the cattle was rattled by the battery"
		Output: "the cat was rat by the bat"
	Note:
		The input will only have lower-case letters.
		1 <= dict words number <= 1000
		1 <= sentence words number <= 1000
		1 <= root length <= 100
		1 <= sentence words length <= 1000
*/

import java.util.List;
public class ReplaceWords {
	private static class DictTree {
		String terminal;
		DictTree[] nodes = new DictTree[26];
	}

	public String replaceWords(List<String> dict, String sentence) {
		StringBuilder builder = new StringBuilder();
		DictTree root = new DictTree();
		for (String word : dict) {
			DictTree node = root;
			for (char c : word.toCharArray()) {
				if (node.nodes[c - 'a'] == null) {
					node.nodes[c - 'a'] = new DictTree();
				}
				node = node.nodes[c - 'a'];
			}
			node.terminal = word;
		}

		for (String word : sentence.split(" ")) {
			if (word.isEmpty()) continue;
			String terminal = null;
			DictTree node = root;
			for (char c : word.toCharArray()) {
				if (node.nodes[c - 'a'] == null) {
					break;
				}
				if (node.nodes[c - 'a'].terminal != null) {
					terminal = node.nodes[c - 'a'].terminal;
					break;
				}
				node = node.nodes[c - 'a'];
			}
			builder.append((terminal == null ? word : terminal) + " ");
		}

		if (builder.length() > 0) {
			builder.deleteCharAt(builder.length() - 1);
		}

		return builder.toString();
	}
}