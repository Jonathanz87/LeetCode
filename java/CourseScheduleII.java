/*
	problem 210
	There are a total of n courses you have to take,
	labeled from 0 to n - 1.
	Some courses may have prerequisites,
	for example to take course 0 you have to first take course 1,
	which is expressed as a pair: [0,1]
	Given the total number of courses and a list of prerequisite pairs,
	return the ordering of courses you should take to finish all courses.
	There may be multiple correct orders,
	you just need to return one of them.
	If it is impossible to finish all courses,
	return an empty array.
	For example:
		2, [[1,0]]
		There are a total of 2 courses to take.
		To take course 1 you should have finished course 0.
		So the correct course order is [0,1]

		4, [[1,0],[2,0],[3,1],[3,2]]
		There are a total of 4 courses to take.
		To take course 3 you should have finished both courses 1 and 2.
		Both courses 1 and 2 should be taken after you finished course 0.
		So one correct course order is [0,1,2,3].
		Another correct ordering is[0,2,1,3].

*/

import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		List<Integer>[] map = new List[numCourses];
		int[] degreeArray = new int[numCourses];
		int[] zeroStack = new int[numCourses];
		int[] result = new int[numCourses];
		int stackIndex = -1;
		int resultIndex = -1;

		for (int[] prerequisite : prerequisites) {
			if (map[prerequisite[1]] == null) {
				map[prerequisite[1]] = new LinkedList<>();
			}
			map[prerequisite[1]].add(prerequisite[0]);
			degreeArray[prerequisite[0]]++;
		}

		for (int i = 0; i < degreeArray.length; i++) {
			if (degreeArray[i] == 0) {
				zeroStack[++stackIndex] = i;
			}
		}

		while (stackIndex > -1) {
			int courseLabel = zeroStack[stackIndex--];
			result[++resultIndex] = courseLabel;

			if (map[courseLabel] != null) {
				for (int course : map[courseLabel]) {
					degreeArray[course]--;
					if (degreeArray[course] == 0) {
						zeroStack[++stackIndex] = course;
					}
				}
			}
		}

		return resultIndex == numCourses - 1 ? result : new int[0];
	}
}