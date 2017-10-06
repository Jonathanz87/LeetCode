/*
	problem 127
	Given two words (beginWord and endWord),
	and a dictionary's word list,
	find the length of shortest transformation sequence from beginWord to endWord,
	such that:
		Only one letter can be changed at a time.
		Each transformed word must exist in the word list.
		Note that beginWord is not a transformed word.
	For example,
		Given:
		beginWord = "hit"
		endWord = "cog"
		wordList = ["hot","dot","dog","lot","log","cog"]
		As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
		return its length 5.
	Note:
		Return 0 if there is no such transformation sequence.
		All words have the same length.
		All words contain only lowercase alphabetic characters.
		You may assume no duplicates in the word list.
		You may assume beginWord and endWord are non-empty and are not the same.
*/

import java.util.Arrays;
import java.util.List;

public class WordLadder {

	public static void main(String[] args) {
		List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
		String beginWord = "hit";
		String endWord = "mmt";

		System.out.println(ladderLength(beginWord, endWord, wordList));
	}


	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		int smallestIndex = 0, currentPath = 1;
		int[] pathCount = new int[wordList.size()];

		for (int i = 0, len = wordList.size(); i < len; i++) {
			smallestIndex = -1;
			for (int j = 0; j < pathCount.length; j++) {
				if (pathCount[j] == 0 && changeable(beginWord, wordList.get(j))) {
					if (endWord.equals(wordList.get(j))) {
						return currentPath + 1;
					}
					pathCount[j] = currentPath + 1;

				}

				if (pathCount[j] > 0 && (smallestIndex == -1 || pathCount[j] < pathCount[smallestIndex])) {
					smallestIndex = j;
				}
			}

			if (smallestIndex == -1) {
				return 0;
			}

			currentPath = pathCount[smallestIndex];
			pathCount[smallestIndex] = -1;
			beginWord = wordList.get(smallestIndex);
		}

		return 0;
	}

	private static boolean changeable(String str1, String str2) {
		int differentCount = 0;
		for (int i = 0, len = str1.length(); i < len; i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				differentCount++;
			}
		}
		return differentCount == 1;
	}



	public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
		if (wordList == null || wordList.size() == 0) return 0;
		Set<String> dic = new HashSet<>(wordList);//直接把list丢进去，创建一个hashset
		if (!dic.contains(endWord)) return 0;
		if (beginWord.equals(endWord)) return 1;
		Set<String> q1 = new HashSet<>(), q2 = new HashSet<>();//q1 q2都是包含很多string的一个set
		q1.add(beginWord);
		dic.remove(beginWord);//if the hashset doesn't have that element, remove method does nothing
		q2.add(endWord);
		dic.remove(endWord);
		return twoEndBFS(q1, q2, dic, 2);//q1 q2就相当于两个end， 所以是two end BFS，从两头开始BFS，length一上来就是2，因为至少是2，一个begin word 一个end word
	}

	//所谓twoEndBFS就是从source和target同时开始search，直到他们meet，这样快。

	private int twoEndBFS(Set<String> q1, Set<String> q2, Set<String> dic, int len) {
		if (q1.isEmpty() || q2.isEmpty()) return 0;
		if (q1.size() > q2.size()) return twoEndBFS(q2, q1, dic, len);//如果q1已经比q2大了，那就从尾巴开始查

		Set<String> temp = new HashSet<>();

		for (String word : q1) {//遍历q1里面的所有word。总之，q1是头，q2是尾巴。
			char[] chArr = word.toCharArray();
			for (int i = 0; i < chArr.length; ++i) {
				char c = chArr[i];//比如beginword是hit,那么这个c就是h，这个我们保存好。最后循环下一个位置的时候还得换回去。
				for (char newC = 'a'; newC <= 'z'; ++newC) {
					chArr[i] = newC;//把字母换掉
					String next = new String(chArr);//把array换回string
					if (q2.contains(next)) return len;//如果q2里面有这个新的，那就搞定了。
					if (dic.contains(next)) {//如果字典里面有这个新的，那就把这个新的放到temp里面，temp有点类似于visited
						temp.add(next);
						dic.remove(next);//把这个新的从字典里移除。
					}
					//如果上面两个if的情况都没有发生，那么就继续循环，从a变成b，以此类推
				}
				//经过这个for loop我们把hit的第一个位置从a到z全部循环了一遍，接下来要去循环第二个位置了，所以把h还给hit
				chArr[i] = c;
			}
		}
		//经过这个大的for loop循环，我们已经把q1里面所有的word都循环了一次，每一个word我们都在每一个位置上分别换成了a-z进行查找，然并卵，并没有找到q2里面也有一样的，所以我们这一层里面就没有找到。 就该进行下一层了。所以我们给lenth加上1，开始找下一层。


		//比如它题里面给的那个例子，hit是begin word，所以最开始q1里面只有一个hit，然后我们开始在h的位置循环，发现没有跟cog一样的，然后字典里也没有，所以我们就在第二个位置i循环，hXt也没有可能跟cog一样的，但是我们发现了hot是在字典里面的，所以我们把它放在temp里面。并把hot从字典里面移除（保证字典里面没有begin word和end word））给length加上1。 这样一来，第二次循环，我们的begin word就是hot了，给length加上1。同样道理，先从h位置循环，这回发现，dot在字典里面，所以temp里面再放一个dot，并把dot从字典里面移除。这是temp里面有一个hot， 有一个dot。都是我们visited过得word。然后我们第三次循环的时候，temp再充当q1就不合适了，因为temp里面已经有俩word了，q2却只有一个。所以我们从尾巴开始循环，让q2充当q1。 所以同理，先从cog开始，然后cog循环一圈找到了dog，这时候，一边是hot和dot 一边是cog和dog 还没有一样的。然后再找，就变成了一边是hot和dot，一边是cog和dog，dog循环的时候变成了dot，在hot和dot里面有！ 所以就meet了！这样一来我们总共循环了


		return twoEndBFS(temp, q2, dic, len + 1);
		//这下temp充当q1了，那这样下去的话，你不停的往temp里面加东西（看第29行），q1就会比q2大，然后你的算法是去遍历q1里面的每一个element，这样效率就很低了，所以当q1比q2大的时候，我们就让q2来充当q1，去遍历q2里面的所有元素。所以这就是为什么叫做two end BFS！！！因为我们从头查，然后又从尾巴查，然后又从头查。。。


	}
}