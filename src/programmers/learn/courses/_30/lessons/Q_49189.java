package programmers.learn.courses._30.lessons;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q_49189 {

	public static void main(String[] args) {
		System.out.println(new Answer_49189().solution(
				8
				, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}, {6,7}, {7,5}, {8,5}}
		));
	}
}

class Answer_49189 {
	private static List<List<Integer>> graph = new ArrayList<>();
	private static int[] oneToNDist;
	
    public int solution(int n, int[][] edge) {
    	oneToNDist = new int[n+1];
    	
    	graph.add(null);
    	for(int i=1; i<=n; i++) {
    		graph.add(new ArrayList<>());
    	}
    	
    	for(int[] e : edge) {
    		graph.get(e[0]).add(e[1]);
    		graph.get(e[1]).add(e[0]);
    	}
    	
    	bfs(1, n);
    	
    	int maxDist = 0;
    	int count = 0;
    	for(int dist : oneToNDist) {
    		if(dist > maxDist) {
    			maxDist = dist;
    			count = 1;
    		}else if(dist == maxDist) {
    			count++;
    		}
    	}
        return count;
    }
    
    public void bfs(int rootV, int n) {
    	Queue<Integer> nodeQueue = new LinkedList<>();
    	nodeQueue.offer(rootV);
    	
    	boolean[] visited = new boolean[n+1];
    	visited[rootV] = true;
    	
    	while(!nodeQueue.isEmpty()) {
    		int currentV = nodeQueue.poll();
	    	for(int nextV : graph.get(currentV)) {
	    		if(visited[nextV] == true) continue;
	    		visited[nextV] = true;
	    		nodeQueue.offer(nextV);
	    		oneToNDist[nextV] = oneToNDist[currentV] + 1;
	    	}
    	}
    }
}