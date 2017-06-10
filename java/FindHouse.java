/*
	google interview
	find the house ID which
	1. ID appears most of times 
	2. if ID appears same, retuen the amount larger one
	3. if amount is same, return whoever appear earlier.
*/

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.LinkedList;

public class FindHouse{
	public static void main(String[] args){
		int[] house = {1,3,3,2};
		int[] money = {100,400,50,500};
		System.out.println(findHouse(house, money));

		house = new int[]{5,15,15,20,20};
		money = new int[]{30,50,100,80,80};
		System.out.println(findHouse(house, money));

		house = new int[]{1,3,2,3,2};
		money = new int[]{50,10,10,10,10};
		System.out.println(findHouse(house, money));
	}

    public static int findHouse(int[] house, int[] money){
        Map<Integer, List<Integer>> houseMap = new LinkedHashMap<>();
        int houseId = -1;
        int amount = -1;
        int size = -1;

        for(int i = 0, len = Math.min(house.length, money.length); i < len; i++){
            if(houseMap.containsKey(house[i])){
                houseMap.get(house[i]).add(money[i]);
            }else{
                List<Integer> temp = new LinkedList<>();
                temp.add(money[i]);
                houseMap.put(house[i], temp);
            }
        }

        for(Map.Entry<Integer, List<Integer>> entry : houseMap.entrySet()){
            if(entry.getValue().size() > size){
                size = entry.getValue().size();
                amount = entry.getValue().stream().mapToInt(Integer::intValue).sum();
                houseId = entry.getKey();
            }else if(entry.getValue().size() == size){
                int sum = entry.getValue().stream().mapToInt(Integer::intValue).sum();
                if(sum > amount){
                    amount = sum;
                    houseId = entry.getKey();
                }
            }
        }
        return houseId;
    }
}