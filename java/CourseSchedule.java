/*
    problem 207
    There are a total of n courses you have to take,
    labeled from 0 to n - 1.
    Some courses may have prerequisites,
    for example to take course 0 you have to first take course 1,
    which is expressed as a pair: [0,1]
    Given the total number of courses and a list of prerequisite pairs,
    is it possible for you to finish all courses?
    For example:

        2, [[1,0]]
        There are a total of 2 courses to take.
        To take course 1 you should have finished course 0.
        So it is possible.

        2, [[1,0],[0,1]]
        There are a total of 2 courses to take.
        To take course 1 you should have finished course 0,
        and to take course 0 you should also have finished course 1.
        So it is impossible.
    Note:
    The input prerequisites is a graph represented by a list of edges,
    not adjacency matrices.
    Read more about how a graph is represented.
    You may assume that there are no duplicate edges in the input prerequisites.
*/
import java.util.List;
import java.util.LinkedList;

public class CourseSchedule {

    /*
        Topological sort
        1 get degree of all nodes(if a node can be visit, its degree + 1)
        2 find all the vertex(degree == 0)
        3 move vertex into visited list
        4 Traversal all the visitable node form vertex, and -1 on its degree
        5 if any of the degree of visitable node become 0, add into vertex list
        6 if size of vertex list == 0 and not all of notes are visited, looped
    */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] prerequisiteArray = new List[numCourses];
        int[] degreeArray = new int[numCourses];
        int[] zeroDegreeStack = new int[numCourses];
        int[] visitedStack = new int[numCourses];
        int zeroDegreeStackIndex = -1, visitedStackIndex = -1;

        for (int[] prerequest : prerequisites) {
            if (prerequisiteArray[prerequest[1]] == null) {
                prerequisiteArray[prerequest[1]] = new LinkedList<Integer>();
            }
            prerequisiteArray[prerequest[1]].add(prerequest[0]);
            degreeArray[prerequest[0]]++;
        }

        for (int i = 0; i < degreeArray.length; i++) {
            if (degreeArray[i] == 0) {
                zeroDegreeStack[++zeroDegreeStackIndex] = i;
            }
        }
        while (zeroDegreeStackIndex > -1) {
            int index = zeroDegreeStack[zeroDegreeStackIndex--];
            visitedStack[++visitedStackIndex] = index;
            if (prerequisiteArray[index] != null) {
                for (int i : prerequisiteArray[index]) {
                    if (--degreeArray[i] == 0) {
                        zeroDegreeStack[++zeroDegreeStackIndex] = i;
                    }
                }
            }
        }

        return visitedStackIndex >= numCourses - 1;
    }

    public static boolean canFinish2(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return false;
        }
        int[] courses = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            courses[i] = i;
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int[] curr = prerequisites[i];
            int currTgt = curr[0];
            int prereq = curr[1];
            courses[currTgt] = prereq;
            while (prereq != courses[prereq]) {
                prereq = courses[prereq];
                if (prereq == currTgt) {
                    return false;
                }
            }
        }
        return true;
    }
}
