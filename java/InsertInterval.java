/*
	problem 57
	Given a set of non-overlapping intervals,
	insert a new interval into the intervals (merge if necessary).
	You may assume that the intervals were initially sorted according to their start times.
	Example 1:
	Given intervals [1,3],[6,9],
	insert and merge [2,5] in as [1,5],[6,9].
	Example 2:
	Given [1,2],[3,5],[6,7],[8,10],[12,16],
	insert and merge [4,9] in as [1,2],[3,10],[12,16].
	This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
*/

import java.util.List;
import java.util.ArrayList;

public class InsertInterval{
	static public void main(String[] args){
		List<Interval> list = new ArrayList<Interval>(){{
			add(new Interval(1,2));
			add(new Interval(3,5));
			add(new Interval(6,7));
			add(new Interval(8,10));
			add(new Interval(12,16));
		}};

/*		Interval newInterval = new Interval(4, 9);
		for(Interval i : list){
			System.out.println(i.start + " " + i.end);
		}
		System.out.println("------------------");
		list = insert(list, newInterval);

		for(Interval i : list){
			System.out.println(i.start + " " + i.end);
		}*/
		System.out.println(findEndIntervalIndex(list, 7));
	}

	// Definition for an interval.
	static private class Interval{
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}

	static public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if(intervals == null || newInterval == null)
			return intervals;
		List<Interval> temp = new ArrayList<Interval>();
		int inserIndex = 0;

		for(Interval interval : intervals){
			if(interval.end < newInterval.start){
				temp.add(interval);
				inserIndex++;
			}else if(interval.start > newInterval.end){
				temp.add(interval);
			}else{
				if(interval.start < newInterval.start)
					newInterval.start = interval.start;
				if(interval.end > newInterval.end){
					newInterval.end = interval.end;
				}
			}
		}

		temp.add(inserIndex, newInterval);

		return temp;
	}

	static public int findStartIntervalIndex(List<Interval> intervals, int n) {
		int lastIndex = intervals.size() - 1;
		if(intervals.get(0).end >= n)
			return 1;
		if(intervals.get(lastIndex).end < n){
			return lastIndex + 1;
		}
		return findStartIntervalIndex(intervals, 0, lastIndex, n);
	}

	static public int findStartIntervalIndex(List<Interval> intervals, int fIndex, int bIndex, int n) {
		int size = bIndex - fIndex + 1;

		if(size == 2){
			return bIndex;
		}

		int mIndex = size / 2 + fIndex;

		if(n <= intervals.get(mIndex).end){
			return findStartIntervalIndex(intervals, fIndex, mIndex, n);
		}else{
			return findStartIntervalIndex(intervals, mIndex, bIndex, n);
		}
	}

	static public int findEndIntervalIndex(List<Interval> intervals, int n) {
		int lastIndex = intervals.size() - 1;
		if(n < intervals.get(0).start)
			return -1;
		if(n >= intervals.get(lastIndex).start){
			return lastIndex;
		}

		return findEndIntervalIndex(intervals, 0, lastIndex, n);
	}

	static public int findEndIntervalIndex(List<Interval> intervals, int fIndex, int bIndex, int n) {
		int size = bIndex - fIndex + 1;

		if(size == 2){
			return fIndex;
		}

		int mIndex = size / 2 + fIndex;

		if(n <= intervals.get(mIndex).start){
			return findStartIntervalIndex(intervals, fIndex, mIndex, n);
		}else{
			return findStartIntervalIndex(intervals, mIndex, bIndex, n);
		}
	}
}