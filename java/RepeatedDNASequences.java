/*
	problem 187
	All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
	for example: "ACGAATTCCG". When studying DNA,
	it is sometimes useful to identify repeated sequences within the DNA.
	Write a function to find all the 10-letter-long sequences (substrings)
	that occur more than once in a DNA molecule.
	For example,
		Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
		Return:
		["AAAAACCCCC", "CCCCCAAAAA"].
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
public class RepeatedDNASequences {
	public static void main(String[] args) {
		for (String s : findRepeatedDnaSequencesHashMap(args[0])) {
			System.out.println(s);
		}
	}

	public static List<String> findRepeatedDnaSequencesBitMap(String s) {
		return null;
	}

	public static List<String> findRepeatedDnaSequencesHashMap(String s) {
		Set<String> seqSet = new HashSet<>();
		Set<String> resultSet = new TreeSet<>();
		for (int i = 0, len = s.length() - 9; i < len; i++) {
			String seq = s.substring(i, i + 10);
			if (seqSet.contains(seq)) {
				resultSet.add(seq);
			} else{
				seqSet.add(seq);
			}
		}
		return new ArrayList<String>(resultSet);
	}


	public static List<String> findRepeatedDnaSequences(String s) {
		//0 = A; 1 = C; 2 = G; 3 = T
		boolean[][][][][][][][][][] DNASequences = new boolean[4][4][4][4][4][4][4][4][4][4];
		Set<String> repeatedSeq = new TreeSet<>();

		for (int i = 0, len = s.length() - 9; i < len; i++) {
			String seq = s.substring(i, i + 10);
			if (isRepeated(DNASequences, seq)) {
				repeatedSeq.add(seq);
			}
		}

		return new ArrayList<String>(repeatedSeq);
	}

	public static boolean isRepeated(boolean[][][][][][][][][][] DNASequences, String s) {
		int[] index = new int[10];
		for (int i = 0; i < index.length; i++) {
			if ('A' == s.charAt(i)) {
				index[i] = 0;
			} else if ('C' == s.charAt(i)) {
				index[i] = 1;
			} else if ('G' == s.charAt(i)) {
				index[i] = 2;
			} else if ('T' == s.charAt(i)) {
				index[i] = 3;
			}
		}
		boolean result = DNASequences[index[0]][index[1]][index[2]][index[3]][index[4]][index[5]][index[6]][index[7]][index[8]][index[9]];
		DNASequences[index[0]][index[1]][index[2]][index[3]][index[4]][index[5]][index[6]][index[7]][index[8]][index[9]] = true;
		return result;
	}

}