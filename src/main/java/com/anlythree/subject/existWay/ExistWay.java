package com.anlythree.subject.existWay;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ExistWay {

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        //  二维数组，第一维：下标 第二维：下标对应的数组，
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            adj[x].add(y);
            adj[y].add(x);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.offer(source);
        visited[source] = true;
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            if (vertex == destination) {
                break;
            }
            for (int next : adj[vertex]) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
        return visited[destination];
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{new int[]{0,1},new int[]{0,2},new int[]{3,5},new int[]{5,4},new int[]{4,3}};
        validPath(6,edges,0,5);
    }
}
