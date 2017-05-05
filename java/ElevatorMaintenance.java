package com.google.challenges;

public class ElevatorMaintenance {

	public static void main(String[] args) {
		String[] list = {"1.1.2", "1.0", "1.3.3", "1.0.12", "1.0.2"};
		
		for(String s: sort(list)){
			System.out.print(s + " - ");
		}
	}
	
	public static String[] sort(String[] list){
		quickSort(list, 0, list.length - 1);
		return list;
	}
	
	public static void quickSort(String[] list, int fIndex, int bIndex){
		if(fIndex >= bIndex)
			return;
		int trackIndex = fIndex;
		int swapIndex = fIndex;
		int pIndex = bIndex;
		
		while(trackIndex < bIndex){
			if(compare(list[trackIndex], list[pIndex]) > 0){
				String temp = list[swapIndex];
				list[swapIndex] = list[trackIndex];
				list[trackIndex] = temp;
				swapIndex++;
			}
			trackIndex++;
		}
		String temp = list[swapIndex];
		list[swapIndex] = list[pIndex];
		list[pIndex] = temp;
		
		quickSort(list, fIndex, swapIndex - 1);
		quickSort(list, swapIndex + 1, bIndex);
	}

	private static int compare(String str1, String str2){
		String[] numberList1 = str1.split("\\.");
		String[] numberList2 = str2.split("\\.");
		for(int i = 0, len = Math.min(numberList1.length, numberList2.length); i < len; i++){
			int n1 = Integer.parseInt(numberList1[i]);
			int n2 = Integer.parseInt(numberList2[i]);
			if(n1 != n2)
				return n2 - n1;
		}
		return numberList1.length == numberList2.length ? 0 : numberList2.length - numberList1.length;
	}
}
