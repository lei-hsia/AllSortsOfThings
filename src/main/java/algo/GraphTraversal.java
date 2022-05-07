package algo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author lei
 * @date 01/09/2022 3:32 PM
 */
public class GraphTraversal {

    ListGraph graph;
    boolean[] visited;

    public GraphTraversal(ListGraph listGraph) {
        this.graph = listGraph;
        visited = new boolean[listGraph.graphs.size()];
    }

    // all vertices
    public void dfs() {
        for (int i = 0; i < graph.graphs.size(); i++) {
            if (!visited[i]){
                dfsTraversal(i);
            }
        }
    }
    // single vertex
    public void dfsTraversal(int v) {
        if (visited[v]) return;
        visited[v] = true;
        System.out.println(v + "->");
        Iterator<Integer> iterator = graph.graphs.get(v).iterator();// 找到相邻vertices构成的list
        while (iterator.hasNext()){
            Integer nextNode = iterator.next();
            if (!visited[nextNode]){
                dfsTraversal(nextNode);
            }
        }
    }

    public void bfs() {
        for (int i = 0; i < graph.graphs.size(); i++) {
            if (!visited[i]){
                bfsTraversal(i);
            }
        }
    }

    private void bfsTraversal(int v) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offerFirst(v);
        visited[v] = true;
        while (queue.size() != 0) {
            Integer cur = queue.pollFirst();
            System.out.println(cur + "->");
            Iterator<Integer> neighbors = graph.graphs.get(cur).iterator();
            while (neighbors.hasNext()){
                Integer nextNode = neighbors.next();
                if (!visited[nextNode]){
                    queue.offerLast(nextNode);
                    visited[nextNode] = true;
                }
            }
        }

    }
}

class ListGraph {
    ArrayList<ArrayList<Integer>> graphs;

    public ListGraph(int v) {
        graphs = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            graphs.add(new ArrayList<>());
        }
    }

    public void addEdge(int start, int end) {
        graphs.get(start).add(end);
    }

    public void removeEdge(int start, int end) {
        graphs.get(start).remove((Integer) end) ;
    }
}
