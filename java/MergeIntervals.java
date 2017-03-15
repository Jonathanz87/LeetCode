/*
	problem 56
	Given a collection of intervals,
	merge all overlapping intervals.

	For example,
	Given [1,3],[2,6],[8,10],[15,18],
	return [1,6],[8,10],[15,18].
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals{
	static public void main(String[] args){
		List<Interval> list = new ArrayList<Interval>();
		list.add(new Interval(1,3));
		list.add(new Interval(1,2));
		list.add(new Interval(1,4));
		list.add(new Interval(1,3));

		List<Interval>  mergedIntervals = merge(list);

		for(Interval i : mergedIntervals){
			System.out.println(i.start + " " + i.end);
		}
	}

	// Definition for an interval.
	static private class Interval{
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}

	static public List<Interval> merge(List<Interval> intervals) {
		int len = intervals.size();
		if(len <= 1) return intervals;

		int[] starts = new int[len];
		int[] ends = new int[len];
		List<Interval> mergedIntervals = new ArrayList<Interval>();

		for(int i = 0; i < len; i++){
			Interval interval = intervals.get(i);
			starts[i] = interval.start;
			ends[i] = interval.end; 
		}

		Arrays.sort(starts);
		Arrays.sort(ends);

		Interval interval = new Interval(starts[0], ends[0]);
		for(int i = 1; i < len; i++){
			if(starts[i] <= interval.end){
				interval.end = ends[i];
			}else{
				mergedIntervals.add(interval);
				interval = new Interval(starts[i], ends[i]);
			}
		}
		mergedIntervals.add(interval);

		return mergedIntervals;
	}
}