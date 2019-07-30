
/*
    310. Minimum Height Trees
    For an undirected graph with tree characteristics, we can choose any node as the root. 
    The result graph is then a rooted tree. Among all possible rooted trees, 
    those with minimum height are called minimum height trees (MHTs). Given such a graph, 
    write a function to find all the MHTs and return a list of their root labels.
    Format
    The graph contains n nodes which are labeled from 0 to n - 1. 
    You will be given the number n and a list of undirected edges (each edge is a pair of labels).
    You can assume that no duplicate edges will appear in edges. 
    Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
    Example 1 :
        Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
                  0
                  |
                  1
                 / \
                2   3 
        Output: [1]
    Example 2 :
        Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
                0  1  2
                 \ | /
                   3
                   |
                   4
                   |
                   5 
        Output: [3, 4]
    Note:
        According to the definition of tree on Wikipedia: “a tree is an undirected graph in 
        which any two vertices are connected by exactly one path. In other words,
        any connected graph without simple cycles is a tree.”
        The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
*/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1){
            List<Integer> result = new LinkedList<>();
            result.add(0);
            return result;
        }
        List<Integer>[] graph = new List[n];
        int[] degree = new int[n];
        List<Integer> result = new LinkedList<>();

        for (int[] edge : edges) {
            if (graph[edge[0]] == null) {
                graph[edge[0]] = new LinkedList<>();
            }
            if (graph[edge[1]] == null) {
                graph[edge[1]] = new LinkedList<>();
            }

            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                result.add(i);
                degree[i]--;
            }
        }

        while (!result.isEmpty()) {
            List<Integer> temp = new LinkedList<>();

            for (Integer v : result) {
                List<Integer> connectionList = graph[v];
                for (Integer i : connectionList) {
                    degree[i]--;
                    if (degree[i] == 1) {
                        temp.add(i);
                    }
                }
            }

            if (temp.isEmpty()) {
                break;
            }
            result = temp;
        }

        return result;
    }

    public List<Integer> findMinHeightTrees_n3(int n, int[][] edges) {
        List<Integer> result = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        int[][] floydTable = floyd(n, edges);

        for (int i = 0; i < n; i++) {
            int currentMax = 0;
            for (int j = 0; j < n; j++) {
                currentMax = Math.max(currentMax, floydTable[i][j]);
            }
            if (currentMax < min) {
                result.clear();
                result.add(i);
                min = currentMax;
            } else if (currentMax == min) {
                result.add(i);
            }
        }

        return result;
    }

    private static int[][] floyd(int n, int[][] edges) {
        int[][] floydTable = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                floydTable[i][j] = i == j ? 0 : Integer.MAX_VALUE;
            }
        }

        for (int[] edge : edges) {
            floydTable[edge[0]][edge[1]] = 1;
            floydTable[edge[1]][edge[0]] = 1;
        }

        for (int p = 0; p < n; p++) {
            for (int i = 0; i < n; i++) {
                if (i == p) {
                    continue;
                }
                for (int j = 0; j < n; j++) {
                    if (i != j && floydTable[i][p] != Integer.MAX_VALUE && floydTable[p][j] != Integer.MAX_VALUE
                            && floydTable[i][p] + floydTable[p][j] < floydTable[i][j]) {
                        floydTable[i][j] = floydTable[i][p] + floydTable[p][j];
                        floydTable[j][i] = floydTable[i][j];
                    }
                }
            }
        }

        return floydTable;
    }
}